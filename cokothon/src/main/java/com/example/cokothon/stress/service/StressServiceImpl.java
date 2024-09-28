package com.example.cokothon.stress.service;

import com.example.cokothon.member.entity.Member;
import com.example.cokothon.member.repository.MemberRepository;
import com.example.cokothon.member.service.MemberService;
import com.example.cokothon.stress.dto.StressDto;
import com.example.cokothon.stress.entity.Stress;
import com.example.cokothon.stress.repository.StressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StressServiceImpl implements StressService{

    private final MemberRepository memberRepository;
    private final StressRepository stressRepository;
    @Override
    public Stress createStress(StressDto stressDto) {
        Optional<Member> member = memberRepository.findByMember_id(stressDto.getMemberId());
        if(member.isPresent()) {
            Member member1 = member.get();
            Stress stress = Stress.builder()
                    .stress(stressDto.getStress())
                    .member(member1).build();
            stressRepository.save(stress);
            return stress;
        }
        return null;
    }

    @Override
    public List<Stress> getAllStress(Long memberId) {
        return stressRepository.findByMemberId(memberId);
    }
}
