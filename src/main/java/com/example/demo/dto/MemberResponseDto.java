package com.example.demo.dto;

import com.example.demo.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {
    private Long id;
    private String name;
    private String teamName;
    public static MemberResponseDto of (Member member) {
//        MemberResponseDTO build = builder()
//                .id(member.getId())
//                .name(member.getName())
//                .build();
//
//        return build;

        return builder()
                .id(member.getId())
                .name(member.getName())
                .teamName(member.getTeam().getName())
                .build();
    }
}
