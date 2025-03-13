package com.makale_sistemi.service;

import com.makale_sistemi.dto.AlanDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAlanService {
    List<AlanDto> findAll();

    Page<AlanDto> findAllWithPageable(Pageable pageable);

    AlanDto findById(Long id, boolean throwException) throws Exception;

    AlanDto saveOrUpdate(AlanDto dto) throws Exception;

    void deleteById(Long id) throws Exception;
}
