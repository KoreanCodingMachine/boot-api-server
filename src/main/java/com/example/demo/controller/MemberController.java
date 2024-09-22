package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.MemberRequestDto;
import com.example.demo.dto.MemberResponseCode;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Operation(summary = "멤버 생성", description = "멤버 정보를 생성한다.")
    @PostMapping("/api/members")
    public ApiResponse postMember(@RequestBody @Valid MemberRequestDto memberRequestDto) {

        memberService.insert(memberRequestDto);

        return ApiResponse.of(MemberResponseCode.MEMBER_CREATED_OK);
    }

    @Operation(summary = "멤버 삭제", description = "멤버 정보 단건을 삭제한다.")
    @DeleteMapping("/api/members/{id}")
    public ApiResponse deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return ApiResponse.of(MemberResponseCode.MEMBER_DELETED_OK);
    }

    @Operation(summary = "멤버 조회", description = "모든 멤버를 조회한다.")
    @GetMapping("/api/members")
    public List<MemberResponseDto> getAllMembers() {
        return memberService.getAll();
    }

    @Operation(summary = "멤버 단건 조회", description = "멤버 아이디를 받아서 단건 조회한다.")
    @GetMapping("/api/members/{id}")
    public MemberResponseDto getMemberById(@PathVariable Long id) {
        return memberService.getById(id);
    }

    @Operation(summary = "멤버 수정", description = "멤버 id를 받아서 수정한다.")
    @PutMapping("/api/members/{id}")
    public ApiResponse updateMember(@RequestBody @Valid MemberRequestDto memberRequestDto, @PathVariable Long id) {
        memberService.updateMember(id, memberRequestDto.getName());
        return ApiResponse.of(MemberResponseCode.MEMBER_UPDATED_OK);
    }


}
