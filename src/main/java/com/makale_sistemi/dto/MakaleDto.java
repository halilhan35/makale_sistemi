package com.makale_sistemi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Data
@NoArgsConstructor
@FieldNameConstants
public class MakaleDto {
    private Long id;
    private String takipNumarasi;
    private String url;
    private Long makaleId;
    private Date yuklemeTarihi;
}