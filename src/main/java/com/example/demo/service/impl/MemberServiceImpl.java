package com.example.demo.service.impl;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    @Transactional
    public void insert(MemberRequestDto memberRequestDto) {
        Member member = new Member();
        member.setName(memberRequestDto.getName());
        member.setPassword(memberRequestDto.getPassword());
        member.setAge(memberRequestDto.getAge());
        member.setNickname(memberRequestDto.getNickname());

        memberRepository.save(member);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Member memberFound = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
        memberRepository.deleteById(id);
    }

    @Override
    public List<MemberResponseDto> getAll() {
        return memberRepository.findAll().stream()
                .map(MemberResponseDto::of)
                .toList();
    }

    @Override
    public MemberResponseDto getById(Long id) {
        Member memberFound = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
        return MemberResponseDto.of(memberFound);
    }

    @Override
    @Transactional // setAutoCommit(false) [서비스 로직] commit (flush) 혹은 rollback
    public void updateMember(Long id, String name) {
        Member memberFound = memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
        memberFound.setName(name);
    }

}
