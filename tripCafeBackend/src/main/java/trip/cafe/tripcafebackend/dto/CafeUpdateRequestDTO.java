package trip.cafe.tripcafebackend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CafeUpdateRequestDTO {
    private String name;
    private String phoneNum;
    private String location;

    @Builder
    public CafeUpdateRequestDTO(String name, String phoneNum, String location) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.location = location;
    }
}
