package com.example.demo.service.impl;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberResponseDTO;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    }

    @Override
    public List<MemberResponseDTO> getAll() {
        return null;
    }

    @Override
    public MemberResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public void updateMember(Long id, String name) {

    }


}
