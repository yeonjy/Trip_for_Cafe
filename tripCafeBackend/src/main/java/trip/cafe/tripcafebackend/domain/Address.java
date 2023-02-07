package trip.cafe.tripcafebackend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String zipcode;
    private String street;
    private String detail;

    protected Address() {  //@Embeddable -> 안전
    }

    public Address(String zipcode, String street, String detail) {
        this.zipcode = zipcode;
        this.street = street;
        this.detail = detail;
    }
}
