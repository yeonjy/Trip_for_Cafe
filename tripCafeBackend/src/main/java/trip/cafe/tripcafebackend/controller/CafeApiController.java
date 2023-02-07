package trip.cafe.tripcafebackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trip.cafe.tripcafebackend.domain.Address;
import trip.cafe.tripcafebackend.domain.Cafe;
import trip.cafe.tripcafebackend.dto.CafeSaveRequestDTO;
import trip.cafe.tripcafebackend.service.CafeService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")

public class CafeApiController {

    private final CafeService cafeService;

//    @GetMapping("/locations/cafes/new")
//    public String createForm(Model model) {
//        model.addAttribute("cafeForm", new CafeForm());
//        return "api/createCafeForm";  //만들어야됨~
//    }

    /**
     * 카페 생성
     */
    @PostMapping("/locations/cafes/new")
    public Long save(@RequestBody final CafeSaveRequestDTO requestDTO) {

        return cafeService.save(requestDTO);

    }
}
