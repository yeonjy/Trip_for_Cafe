package trip.cafe.tripcafebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trip.cafe.tripcafebackend.dto.BoardSaveRequestDTO;
import trip.cafe.tripcafebackend.repository.BoardRepository;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    /*
     * 후기 작성
     */
    @Transactional
    public Long save(final BoardSaveRequestDTO requestDTO) {
        return boardRepository.save(requestDTO.toEntity()).getId();
    }

}
