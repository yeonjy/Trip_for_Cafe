package trip.cafe.tripcafebackend.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import trip.cafe.tripcafebackend.domain.Member;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
//@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 등록() {

        IntStream.rangeClosed(1, 5).forEach(i -> {
            Member member = Member.builder()
                    .name("name" + i)
                    .password("pw" + i)
                    .nickname("nickname" + i)
                    .build();
            memberRepository.save(member);
        });
    }

    @Test
    public void 조회() {

        Long id = 5L;

        Optional<Member> result = memberRepository.findById(id);

        if (result.isPresent()) {
            Member member = result.get();
            log.info("Member5: " + member);
        }
    }

}