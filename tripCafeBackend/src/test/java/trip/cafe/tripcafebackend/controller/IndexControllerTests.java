package trip.cafe.tripcafebackend.controller;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import trip.cafe.tripcafebackend.domain.Cafe;
import trip.cafe.tripcafebackend.dto.CafeSaveRequestDTO;
import trip.cafe.tripcafebackend.dto.CafeUpdateRequestDTO;
import trip.cafe.tripcafebackend.repository.CafeRepository;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CafeRepository cafeRepository;

    @AfterEach
    public void delete() throws Exception {
        cafeRepository.deleteAll();
    }



    @Test
    public void Cafe_수정된다() throws Exception {
        //given
        Cafe savedCafe = cafeRepository.save(Cafe.builder()
                .name("name")
                .phoneNum("010-0000-0000")
                .build());
        Long updateId = savedCafe.getId();
        String expectedName = "name2";
        String expectedPhoneNum = "010-1111-1111";
        String expectedLocation = "location2";

        CafeUpdateRequestDTO requestDTO = CafeUpdateRequestDTO.builder()
                .name(expectedName)
                .phoneNum(expectedPhoneNum)
                .location(expectedLocation)
                .build();

        String url = "http://localhost:" + port + "/api/location/cafes/"+updateId;

        HttpEntity<CafeUpdateRequestDTO> requestEntity = new HttpEntity<>(requestDTO);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.
                exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Cafe> all = cafeRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(expectedName);
        assertThat(all.get(0).getPhoneNum()).isEqualTo(expectedPhoneNum);
        assertThat(all.get(0).getLocation()).isEqualTo(expectedLocation);

    }

}