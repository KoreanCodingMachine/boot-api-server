package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseCode;
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
    public ApiResponse postMember(@RequestBody @Valid MemberRequestDto memberRequestDto) {

        memberService.insert(memberRequestDto);

        return ApiResponse.of(MemberResponseCode.MEMBER_CREATED_OK);
    }

    @DeleteMapping("/api/members/{id}")
    public ApiResponse deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return ApiResponse.of(MemberResponseCode.MEMBER_DELETED_OK);
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
    public ApiResponse updateMember(@RequestBody @Valid MemberRequestDto memberRequestDto, @PathVariable Long id) {
        memberService.updateMember(id, memberRequestDto.getName());
        return ApiResponse.of(MemberResponseCode.MEMBER_UPDATED_OK);
    }


}
