package com.makale_sistemi.service;

import com.makale_sistemi.dto.AnahtarKelimeAlanDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAnahtarKelimeAlanService {
    List<AnahtarKelimeAlanDto> findAll();

    Page<AnahtarKelimeAlanDto> findAllWithPageable(Pageable pageable);

    AnahtarKelimeAlanDto findById(Long id, boolean throwException) throws Exception;

    AnahtarKelimeAlanDto saveOrUpdate(AnahtarKelimeAlanDto dto) throws Exception;

    void deleteById(Long id) throws Exception;
}
