package com.makale_sistemi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@NoArgsConstructor
@FieldNameConstants
public class AnahtarKelimeAlanDto {
    private Long id;
    private Long alanId;
    private String anahtarKelime;
}