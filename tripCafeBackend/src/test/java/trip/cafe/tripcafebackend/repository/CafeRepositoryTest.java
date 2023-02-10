package trip.cafe.tripcafebackend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import trip.cafe.tripcafebackend.domain.Tag;

import java.util.stream.IntStream;

@SpringBootTest
public class CafeRepositoryTest {

    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private TagRepository tagRepository;

    @Test
    public void Tag를_이용한_Cafe찾기() {  //intStream으로 간단하게 바꾸기

        //given
        String tagName1 = "풍경이 좋아요";
        String tagName2 = "빵이 맛있어요";

        Tag tag1 = Tag.builder().tagName(tagName1).starScore(5).build();
        Tag tag2 = Tag.builder().tagName(tagName1).starScore(3).build();
        Tag tag3 = Tag.builder().tagName(tagName1).starScore(5).build();
        Tag tag4 = Tag.builder().tagName(tagName2).starScore(3).build();
        Tag tag5 = Tag.builder().tagName(tagName2).starScore(3).build();
        tagRepository.save(tag1);
        tagRepository.save(tag2);
        tagRepository.save(tag3);
        tagRepository.save(tag4);
        tagRepository.save(tag5);


    }
}
