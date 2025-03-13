package com.makale_sistemi.mapper;


import com.makale_sistemi.dto.DegerlendirmeDto;
import com.makale_sistemi.entity.Degerlendirme;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface DegerlendirmeMapper {
    DegerlendirmeDto entityToDto(Degerlendirme entity);

    Degerlendirme dtoToEntity(DegerlendirmeDto dto);

    List<DegerlendirmeDto> entityListToDtoList(List<Degerlendirme> entityList);
}