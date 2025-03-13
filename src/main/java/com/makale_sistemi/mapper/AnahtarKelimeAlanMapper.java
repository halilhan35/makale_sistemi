package com.makale_sistemi.mapper;


import com.makale_sistemi.dto.AnahtarKelimeAlanDto;
import com.makale_sistemi.entity.AnahtarKelimeAlan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface AnahtarKelimeAlanMapper {
    AnahtarKelimeAlanDto entityToDto(AnahtarKelimeAlan entity);

    AnahtarKelimeAlan dtoToEntity(AnahtarKelimeAlanDto dto);

    List<AnahtarKelimeAlanDto> entityListToDtoList(List<AnahtarKelimeAlan> entityList);
}