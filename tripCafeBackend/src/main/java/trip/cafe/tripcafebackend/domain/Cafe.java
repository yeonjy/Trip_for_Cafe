package trip.cafe.tripcafebackend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@Table(name = "cafe")
@NoArgsConstructor
@Entity
public class Cafe {  //사진 업로드 추가 필요

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_id")
    private Long id;

    private String name;

    private String phoneNum;

    @Column(name = "location_first")
    private String locationFirst;  //입력받은 주소에서 추출하기

    @Column(name = "location_second")
    private String locationSecond;

    @Column(name = "location_third")
    private String locationThird;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cafe")
    private List<CafeEvaluate> tags = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    @Builder
    public Cafe(Long id, String name, String phoneNum, Address address, String locationFirst, String locationSecond, String locationThird) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.locationFirst = locationFirst;
        this.locationSecond = locationSecond;
        this.locationThird = locationThird;
    }



    //update 추가하기
    public void update(String name, String phoneNum, String location) {
        this.name = name;
        this.phoneNum = phoneNum;

    }

    public void mappingCafeTag(CafeEvaluate cafeEvaluate) {
        this.tags.add(cafeEvaluate);
    }



}
