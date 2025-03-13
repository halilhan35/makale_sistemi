package com.makale_sistemi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Data
@NoArgsConstructor
@FieldNameConstants
public class DegerlendirmeDto {
    private Long id;
    private Long makaleId;
    private String yorum;
    private Date degerlendirmeTarihi;
}