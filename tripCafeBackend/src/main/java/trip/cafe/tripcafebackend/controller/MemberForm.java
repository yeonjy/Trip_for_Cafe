package trip.cafe.tripcafebackend.controller;

import lombok.Getter;

@Getter
public class MemberForm {

//    @NotEmpty(message = "회원 이름은 필수입니다.")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
