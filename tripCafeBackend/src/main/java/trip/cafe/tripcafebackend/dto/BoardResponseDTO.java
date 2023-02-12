package trip.cafe.tripcafebackend.dto;

import lombok.Getter;
import trip.cafe.tripcafebackend.domain.Board;
import trip.cafe.tripcafebackend.domain.Cafe;

@Getter
public class BoardResponseDTO {

    private Long id;
    private String title;
    private String content;
    private Cafe cafe;

    public BoardResponseDTO(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.cafe = entity.getCafe();
    }
}
