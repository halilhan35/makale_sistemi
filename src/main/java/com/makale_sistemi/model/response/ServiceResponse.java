package com.makale_sistemi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceResponse {
    private boolean success;
    private int statusCode;
    private String message;
    private Object data;
    private LocalDateTime timestamp;
}