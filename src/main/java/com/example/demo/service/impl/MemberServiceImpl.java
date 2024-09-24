package com.example.demo.service.impl;

import com.example.demo.domain.Brand;
import com.example.demo.domain.Member;
import com.example.demo.domain.MemberBrand;
import com.example.demo.dto.BrandRequestDto;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.MemberBrandRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final BrandRepository brandRepository;
    private final MemberBrandRepository memberBrandRepository;
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
        return memberRepository.findAllMembersWithTeam().stream()
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

    @Override
    @Transactional
    public void addBrand(BrandRequestDto brandRequestDto) {
        Member member = memberRepository.findById(brandRequestDto.getMemberId())
                .orElseThrow(() -> new EntityNotFoundException("no entity"));

        Brand brand = brandRepository.findById(brandRequestDto.getBrandId())
                .orElseThrow(() -> new EntityNotFoundException("no entity"));

        MemberBrand memberBrand = new MemberBrand();
        memberBrand.setMember(member);
        memberBrand.setBrand(brand);
        memberBrand.setCount(brandRequestDto.getCount());

        memberBrandRepository.save(memberBrand);
    }

}
