package com.makale_sistemi.service;

import com.makale_sistemi.dto.MesajDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMesajService {
    List<MesajDto> findAll();

    Page<MesajDto> findAllWithPageable(Pageable pageable);

    MesajDto findById(Long id, boolean throwException) throws Exception;

    MesajDto saveOrUpdate(MesajDto dto) throws Exception;

    void deleteById(Long id) throws Exception;
}
