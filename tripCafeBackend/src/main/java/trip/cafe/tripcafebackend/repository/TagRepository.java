package trip.cafe.tripcafebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trip.cafe.tripcafebackend.domain.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
