package com.makale_sistemi.service;

import com.makale_sistemi.dto.MakaleLogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMakaleLogService {
    List<MakaleLogDto> findAll();

    Page<MakaleLogDto> findAllWithPageable(Pageable pageable);

    MakaleLogDto findById(Long id, boolean throwException) throws Exception;

    MakaleLogDto saveOrUpdate(MakaleLogDto dto) throws Exception;

    void deleteById(Long id) throws Exception;
}
