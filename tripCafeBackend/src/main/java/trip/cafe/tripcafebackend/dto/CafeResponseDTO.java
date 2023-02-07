package trip.cafe.tripcafebackend.dto;

import lombok.Getter;
import trip.cafe.tripcafebackend.domain.Cafe;

@Getter
public class CafeResponseDTO {

    private Long id;
    private String name;
    private String phoneNum;
    private String zipcode;
    private String street;
    private String detail;


    public CafeResponseDTO(Cafe entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.phoneNum = entity.getPhoneNum();
        this.zipcode = entity.getAddress().getZipcode();
        this.street = entity.getAddress().getStreet();
        this.detail = entity.getAddress().getDetail();
    }
}
