package trip.cafe.tripcafebackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trip.cafe.tripcafebackend.domain.Cafe;
import trip.cafe.tripcafebackend.dto.CafeResponseDTO;

import java.util.List;
import java.util.Optional;


@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {

    /**
     * 카페 location별 조회
     */
    List<Cafe> findByLocation(String location);



}
