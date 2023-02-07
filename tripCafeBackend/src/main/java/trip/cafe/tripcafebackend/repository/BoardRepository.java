package trip.cafe.tripcafebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trip.cafe.tripcafebackend.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
