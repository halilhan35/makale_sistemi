package com.makale_sistemi.mapper;


import com.makale_sistemi.dto.MakaleAlanDto;
import com.makale_sistemi.entity.MakaleAlan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface MakaleAlanMapper {
    MakaleAlanDto entityToDto(MakaleAlan entity);

    MakaleAlan dtoToEntity(MakaleAlanDto dto);

    List<MakaleAlanDto> entityListToDtoList(List<MakaleAlan> entityList);
}