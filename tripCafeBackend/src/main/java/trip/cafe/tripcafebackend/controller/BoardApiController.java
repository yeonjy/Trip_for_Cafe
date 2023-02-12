package trip.cafe.tripcafebackend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import trip.cafe.tripcafebackend.domain.Board;
import trip.cafe.tripcafebackend.domain.Cafe;
import trip.cafe.tripcafebackend.dto.BoardSaveRequestDTO;
import trip.cafe.tripcafebackend.dto.CafeResponseDTO;
import trip.cafe.tripcafebackend.service.BoardService;
import trip.cafe.tripcafebackend.service.CafeService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class BoardApiController {

    private final BoardService boardService;
    private final CafeService cafeService;





    /*
     * 게시글 등록
     */

    @PostMapping("/locations/boards/new")
    public ModelAndView save(@RequestBody final BoardSaveRequestDTO requestDTO) {

        log.info("-----------------------------" + requestDTO.getCid() + "---------------------------------");

        log.info("------------------------------Add Cafe Review---------------------------------");

        Long boardId = boardService.save(requestDTO);

        log.info("-----------------------------------boardId: " + boardId + "-------------------------------------");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("api/locations");
        return modelAndView;

    }

    @GetMapping("locations/boards/new")
    public ModelAndView saveBoard(@RequestParam("id") Long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("api/board-save");
        modelAndView.addObject("cafeObj", cafeService.findById(id));

        return modelAndView;
    }
}
