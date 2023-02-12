package trip.cafe.tripcafebackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import trip.cafe.tripcafebackend.dto.CafeResponseDTO;
import trip.cafe.tripcafebackend.dto.CafeSaveRequestDTO;
import trip.cafe.tripcafebackend.service.CafeService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api")

public class CafeApiController {

    private final CafeService cafeService;

    /**
     * 카페 생성
     */
    @PostMapping("/locations/cafes/new")
    public Long save(@RequestBody final CafeSaveRequestDTO requestDTO) {

        return cafeService.save(requestDTO);
    }


    /*
     * location별 카페 리스트 조회
     */
    @GetMapping("/locations/{location}")
    public ModelAndView findByLocation(@PathVariable String location) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/api/location-view");
        modelAndView.addObject("location", location);
        modelAndView.addObject("cafe", cafeService.findByLocationFirst(location));

        return modelAndView;
    }


}
