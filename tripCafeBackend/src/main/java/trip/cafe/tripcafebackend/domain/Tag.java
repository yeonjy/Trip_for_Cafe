package trip.cafe.tripcafebackend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(length = 50)
    private String tagName;

    @ColumnDefault("0")
    @Max(5)  //5이하의 값만 받기
    private Integer starScore;  //별점


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
    private List<CafeEvaluate> cafes = new ArrayList<>();

    @Builder
    public Tag(String tagName, Integer starScore) {
        this.tagName = tagName;
        this.starScore = starScore;
    }

    public void mappingCafeTag(CafeEvaluate cafeEvaluate) {
        this.cafes.add(cafeEvaluate);
    }
}
