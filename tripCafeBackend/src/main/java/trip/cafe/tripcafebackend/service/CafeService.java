package trip.cafe.tripcafebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trip.cafe.tripcafebackend.domain.Cafe;
import trip.cafe.tripcafebackend.dto.CafeResponseDTO;
import trip.cafe.tripcafebackend.dto.CafeSaveRequestDTO;
import trip.cafe.tripcafebackend.dto.CafeUpdateRequestDTO;
import trip.cafe.tripcafebackend.repository.CafeRepository;

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

    @Transactional
    public Long update(Long id, CafeUpdateRequestDTO requestDTO) {
        Cafe cafe = cafeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 카페가 존재하지 않습니다. id=" + id));

        cafe.update(requestDTO.getName(), requestDTO.getPhoneNum(), requestDTO.getLocation());

        return id;
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
