package com.makale_sistemi.service;

import com.makale_sistemi.dto.MakaleAlanDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMakaleAlanService {
    List<MakaleAlanDto> findAll();

    Page<MakaleAlanDto> findAllWithPageable(Pageable pageable);

    MakaleAlanDto findById(Long id, boolean throwException) throws Exception;

    MakaleAlanDto saveOrUpdate(MakaleAlanDto dto) throws Exception;

    void deleteById(Long id) throws Exception;
}
