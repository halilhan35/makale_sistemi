package com.makale_sistemi.mapper;


import com.makale_sistemi.dto.MakaleDto;
import com.makale_sistemi.entity.Makale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface MakaleMapper {
    MakaleDto entityToDto(Makale entity);

    Makale dtoToEntity(MakaleDto dto);

    List<MakaleDto> entityListToDtoList(List<Makale> entityList);
}