package trip.cafe.tripcafebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trip.cafe.tripcafebackend.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}

