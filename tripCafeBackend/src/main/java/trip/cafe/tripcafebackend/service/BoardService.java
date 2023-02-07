package trip.cafe.tripcafebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trip.cafe.tripcafebackend.repository.BoardRepository;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
}
