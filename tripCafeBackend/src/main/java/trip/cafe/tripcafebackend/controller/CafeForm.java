package trip.cafe.tripcafebackend.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import trip.cafe.tripcafebackend.domain.Address;

@Getter
public class CafeForm {

    @NotEmpty(message = "카페 이름은 필수입니다.")
    private String name;

    private String phoneNum;
    private String zipcode;
    private String street;
    private String detail;

    public CafeForm(String name, String phoneNum, String zipcode, String street, String detail) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.zipcode = zipcode;
        this.street = street;
        this.detail = detail;
    }



}
