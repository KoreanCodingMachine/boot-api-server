package com.example.demo.validator;

import com.example.demo.annotation.MapleNickname;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class MapleNicknameValidator implements ConstraintValidator<MapleNickname, String> {
    @Override
    public void initialize(MapleNickname constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 부적절한 단어 체크 해서 있으면 false 로 반환할거야
        // fool, ac

        List<String> invalidWords = List.of("fool", "ac");

        for (String word : invalidWords) {
            if (StringUtils.containsIgnoreCase(value, word)) {
                return false;
            }
        }

        return true;
    }
}
