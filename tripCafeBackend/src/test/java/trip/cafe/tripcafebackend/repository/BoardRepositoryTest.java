package trip.cafe.tripcafebackend.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import trip.cafe.tripcafebackend.domain.Board;
import trip.cafe.tripcafebackend.domain.Member;

@Slf4j
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

//    @Transactional
    @Test
    public void 게시글_등록() {

        Member member = Member.builder()
                .name("member1")
                .password("pw1")
                .nickname("nickname1")
                .build();
        memberRepository.save(member);

        Board board = Board.builder()
                .title("Board test")
                .content("board test content")
                .member(member)
                .build();
        boardRepository.save(board);

    }


}
