package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/api/members")
    public Member postMember(@RequestBody @Valid MemberRequestDto memberRequestDto) {
        Member member = new Member();
        member.setName(memberRequestDto.getName());
        member.setPassword(memberRequestDto.getPassword());
        member.setAge(memberRequestDto.getAge());
        member.setNickname(memberRequestDto.getNickname());

        memberService.insert(member);

        return member;
    }

    @DeleteMapping("/api/members/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/members")
    public List<MemberResponseDto> getAllMembers() {
        return memberService.getAll();
    }

    @GetMapping("/api/members/{id}")
    public MemberResponseDto getMemberById(@PathVariable Long id) {
        return memberService.getById(id);
    }

    @PutMapping("/api/members/{id}")
    public ResponseEntity<MemberResponseDto> updateMember(@RequestBody @Valid MemberRequestDto memberRequestDto, @PathVariable Long id) {
        MemberResponseDto updatedMember = memberService.updateMember(id, memberRequestDto.getName());
        return ResponseEntity.ok(updatedMember);
    }


}
