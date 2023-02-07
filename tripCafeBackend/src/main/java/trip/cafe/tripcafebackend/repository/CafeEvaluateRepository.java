package trip.cafe.tripcafebackend.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trip.cafe.tripcafebackend.domain.CafeEvaluate;
import trip.cafe.tripcafebackend.domain.Tag;

import java.util.List;

@Repository
public interface CafeEvaluateRepository extends JpaRepository<CafeEvaluate, Long> {

    @EntityGraph(attributePaths = {"cafe"}, type = EntityGraph.EntityGraphType.FETCH)
    List<CafeEvaluate> findByTag(Tag tag);
}

