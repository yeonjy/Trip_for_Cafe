package trip.cafe.tripcafebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trip.cafe.tripcafebackend.domain.Cafe;
import trip.cafe.tripcafebackend.dto.CafeResponseDTO;
import trip.cafe.tripcafebackend.dto.CafeSaveRequestDTO;
import trip.cafe.tripcafebackend.dto.CafeUpdateRequestDTO;
import trip.cafe.tripcafebackend.repository.CafeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CafeService {
    private final CafeRepository cafeRepository;

    /**
     * 카페 생성
     */
    @Transactional
    public Long save(final CafeSaveRequestDTO requestDTO) {
        return cafeRepository.save(requestDTO.toEntity()).getId();
    }

    /*
     * location별 카페 리스트 조회
     */
    public List<CafeResponseDTO> findByLocationFirst (String location) {
//        Optional<Cafe> list = cafeRepository.findByLocation(location);
//        return list.stream().map(CafeResponseDTO::new).toList();

        return cafeRepository.findByLocationFirst(location)
                .stream()
                .map(CafeResponseDTO::new)
                .toList();

    }



//    @Transactional
//    public Long update(Long id, CafeUpdateRequestDTO requestDTO) {
//        Cafe cafe = cafeRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 카페가 존재하지 않습니다. id=" + id));
//
//        cafe.update(requestDTO.getName(), requestDTO.getPhoneNum(), requestDTO.getLocation());
//
//        return id;
//    }

    /*
     * 카페 전체 조회
     */
    public List<CafeResponseDTO> findAll() {

        List<Cafe> list = cafeRepository.findAll();
        return list.stream().map(CafeResponseDTO::new).toList();
    }



    /**
     * 카페 조회
     */
    public CafeResponseDTO findById(Long id) {
        Cafe entity = cafeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 카페가 존재하지 않습니다. id=" + id));

        return new CafeResponseDTO(entity);
    }

}
