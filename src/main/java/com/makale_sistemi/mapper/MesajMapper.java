package com.makale_sistemi.mapper;


import com.makale_sistemi.dto.MesajDto;
import com.makale_sistemi.entity.Mesaj;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface MesajMapper {
    MesajDto entityToDto(Mesaj entity);

    Mesaj dtoToEntity(MesajDto dto);

    List<MesajDto> entityListToDtoList(List<Mesaj> entityList);
}