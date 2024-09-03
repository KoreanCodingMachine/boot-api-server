package com.example.demo.service.impl;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public void insert(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void delete(Long id) {
        if (!memberRepository.existsById(id)) {
           throw new EntityNotFoundException("no entity");
        }
        memberRepository.deleteById(id);
    }

    @Override
    public List<MemberResponseDto> getAll() {
        return memberRepository.findAll()
                .stream()
                .map(member -> MemberResponseDto.of(member))
                .collect(Collectors.toList());
    }

    @Override
    public MemberResponseDto getById(Long id) {
       return memberRepository.findById(id)
               .map(member -> MemberResponseDto.of(member))
               .orElseThrow(() -> new EntityNotFoundException("member not found"));
    }

    @Override
    public MemberResponseDto updateMember(Long id, String name) {
        memberRepository.findById(id).ifPresentOrElse(member -> {
            member.setName(name);  // 멤버의 이름을 업데이트
            memberRepository.save(member);  // 변경된 멤버를 저장
        }, () -> {
            throw new EntityNotFoundException("Member not found with id: " + id);
        });
        return null;
    }



}
