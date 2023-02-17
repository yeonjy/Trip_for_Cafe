package trip.cafe.tripcafebackend.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import trip.cafe.tripcafebackend.dto.CafeUpdateRequestDTO;
import trip.cafe.tripcafebackend.service.CafeService;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("api")
public class IndexController {

    private final CafeService cafeService;

    @GetMapping("/locations")
    public String locations() {
        return "api/locations";
    }

    @GetMapping("locations/cafes/new")
    public String cafeSave() {
        return "api/cafe-save";
    }


}
