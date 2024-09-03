package com.example.demo.annotation;

import com.example.demo.validator.MapleNicknameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MapleNicknameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapleNickname {
    String message() default "닉네임에 부적절한 단어가 포함되어 있습니다.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
