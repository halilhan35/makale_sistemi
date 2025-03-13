package com.makale_sistemi.mapper;


import com.makale_sistemi.dto.MakaleLogDto;
import com.makale_sistemi.entity.MakaleLog;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface MakaleLogMapper {
    MakaleLogDto entityToDto(MakaleLog entity);

    MakaleLog dtoToEntity(MakaleLogDto dto);

    List<MakaleLogDto> entityListToDtoList(List<MakaleLog> entityList);
}