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

    private String location;  //select 이용해서 저장하기

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cafe")
    private List<CafeEvaluate> tags = new ArrayList<>();

    @Builder
    public Cafe(String name, String phoneNum, Address address) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
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
