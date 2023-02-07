package trip.cafe.tripcafebackend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CafeEvaluate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_evaluate_id")
    private Long id;

    @ColumnDefault("0")
    @Max(5)  //5이하의 값만 받기
    private Integer totalScore;  //총점

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public void mappingCafe(Cafe cafe) {
        this.cafe = cafe;
        cafe.mappingCafeTag(this);
    }

    public void mappingTag(Tag tag) {
        this.tag = tag;
        cafe.mappingCafeTag(this);

    }

}
