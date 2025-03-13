package com.makale_sistemi.service;

import com.makale_sistemi.dto.MakaleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMakaleService {
    List<MakaleDto> findAll();

    Page<MakaleDto> findAllWithPageable(Pageable pageable);

    MakaleDto findById(Long id, boolean throwException) throws Exception;

    MakaleDto saveOrUpdate(MakaleDto dto) throws Exception;

    void deleteById(Long id) throws Exception;
}
