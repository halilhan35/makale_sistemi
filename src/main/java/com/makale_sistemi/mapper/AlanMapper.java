package com.makale_sistemi.mapper;


import com.makale_sistemi.dto.AlanDto;
import com.makale_sistemi.entity.Alan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface AlanMapper {
    AlanDto entityToDto(Alan entity);

    Alan dtoToEntity(AlanDto dto);

    List<AlanDto> entityListToDtoList(List<Alan> entityList);
}