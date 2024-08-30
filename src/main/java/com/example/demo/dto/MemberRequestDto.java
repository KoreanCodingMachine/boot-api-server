package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Getter
public class MemberRequestDto {
    @Size(min = 2, max = 5)
    private String name;

    @Min(20)
    @Max(50)
    private Integer age;

    @NotBlank
    private String password;

    private String nickname;

    @AssertTrue(message = "nickname에 부적절한 단어가 포함되어 있습니다.")
    public boolean isValidName() {
        // 부적절한 단어 체크 해서 있으면 false 로 반환할거야
        // fool, ac

        List<String> invalidWords = List.of("fool", "ac");

        for (String word : invalidWords) {
            if (StringUtils.containsIgnoreCase(nickname, word)) {
                return false;
            }
        }

        return true;
    }
}
