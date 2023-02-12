package trip.cafe.tripcafebackend.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trip.cafe.tripcafebackend.domain.Board;
import trip.cafe.tripcafebackend.domain.Cafe;
import trip.cafe.tripcafebackend.repository.CafeRepository;
import trip.cafe.tripcafebackend.service.CafeService;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoardSaveRequestDTO {

    private CafeRepository cafeRepository;


    private String title;
    private String content;

    //Cafe id
    private Long cid;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .cafe(Cafe.builder().id(this.cid).build())
                .build();
    }
}
