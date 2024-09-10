package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ApiResponse {
    private Integer statusCode;
    private String message;

    public static ApiResponse of(ResponseCode responseCode) {
        return builder()
                .statusCode(responseCode.getStatusCode())
                .message(responseCode.getMessage())
                .build();
    }
}
