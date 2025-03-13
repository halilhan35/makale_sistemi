package com.makale_sistemi.service;

import com.makale_sistemi.dto.DegerlendirmeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDegerlendirmeService {
    List<DegerlendirmeDto> findAll();

    Page<DegerlendirmeDto> findAllWithPageable(Pageable pageable);

    DegerlendirmeDto findById(Long id, boolean throwException) throws Exception;

    DegerlendirmeDto saveOrUpdate(DegerlendirmeDto dto) throws Exception;

    void deleteById(Long id) throws Exception;
}
