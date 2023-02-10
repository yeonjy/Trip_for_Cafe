package trip.cafe.tripcafebackend.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import trip.cafe.tripcafebackend.domain.Cafe;
import trip.cafe.tripcafebackend.domain.CafeEvaluate;
import trip.cafe.tripcafebackend.domain.Tag;

import java.util.List;

@Slf4j
@SpringBootTest
public class CafeEvaluateRepositoryTest {

    @Autowired
    private CafeEvaluateRepository repository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CafeRepository cafeRepository;

    @Test
    public void 카페_등록() {

        //given
        Cafe cafe = Cafe.builder()
                .name("name")
                .phoneNum("010-0000-0000")
                .build();
        cafeRepository.save(cafe);

        Tag tag1 = Tag.builder()
                .tagName("풍경이 좋아요")
                .starScore(5)
                .build();
        tagRepository.save(tag1);

        Tag tag2 = Tag.builder()
                .tagName("빵이 맛있어요")
                .starScore(4)
                .build();
        tagRepository.save(tag2);



        //when
        CafeEvaluate cafeEvaluate1 = CafeEvaluate.builder()
                .cafe(cafe)
                .tag(tag1)
                .totalScore(4)
                .build();
        CafeEvaluate cafeEvaluate2 = CafeEvaluate.builder()
                .cafe(cafe)
                .tag(tag2)
                .totalScore(3)
                .build();
        repository.save(cafeEvaluate1);
        repository.save(cafeEvaluate2);


    }



}
