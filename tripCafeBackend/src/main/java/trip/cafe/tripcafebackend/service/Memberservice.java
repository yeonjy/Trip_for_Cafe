package trip.cafe.tripcafebackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trip.cafe.tripcafebackend.repository.MemberRepository;

@RequiredArgsConstructor
@Service
public class Memberservice {

    private final MemberRepository memberRepository;
}
