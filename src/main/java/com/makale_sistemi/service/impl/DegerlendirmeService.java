package com.makale_sistemi.service.impl;

import com.makale_sistemi.dto.DegerlendirmeDto;
import com.makale_sistemi.entity.Degerlendirme;
import com.makale_sistemi.mapper.DegerlendirmeMapper;
import com.makale_sistemi.repository.DegerlendirmeRepository;
import com.makale_sistemi.service.IDegerlendirmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.makale_sistemi.constant.ApplicationConstants;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DegerlendirmeService implements IDegerlendirmeService {
    private final DegerlendirmeRepository repository;
    private final DegerlendirmeMapper mapper;

    public List<DegerlendirmeDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    public Page<DegerlendirmeDto> findAllWithPageable(Pageable pageable) {
        Page<Degerlendirme> entityPage = repository.findAll(pageable);
        return entityPage.map(mapper::entityToDto);
    }

    public DegerlendirmeDto findById(Long id, boolean throwException) throws Exception {
        if (id == null) {
            if (throwException) {
                throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.id));
            }

            return null;
        }

        Optional<Degerlendirme> entityOpt = repository.findById(id);

        if (entityOpt.isPresent()) {
            return mapper.entityToDto(entityOpt.get());
        }

        if (throwException) {
            throw new Exception(String.format(ApplicationConstants.ID_ILE_KAYIT_BULUNAMADI_UYARI_MESAJI, id));
        }

        return null;
    }

    public DegerlendirmeDto saveOrUpdate(DegerlendirmeDto dto) throws Exception {
        if (dto == null) {
            throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.RequestBody));
        }

        if (dto.getId() != null) {
            findById(dto.getId(), true);
        }

        Degerlendirme entity = mapper.dtoToEntity(dto);
        repository.save(entity);
        return mapper.entityToDto(entity);
    }

    public void deleteById(Long id) throws Exception {
        DegerlendirmeDto dto = findById(id, true);
        repository.delete(mapper.dtoToEntity(dto));
    }
}
