package com.makale_sistemi.service.impl;

import com.makale_sistemi.dto.AlanDto;
import com.makale_sistemi.entity.Alan;
import com.makale_sistemi.mapper.AlanMapper;
import com.makale_sistemi.repository.AlanRepository;
import com.makale_sistemi.service.IAlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.makale_sistemi.constant.ApplicationConstants;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlanService implements IAlanService {
    private final AlanRepository repository;
    private final AlanMapper mapper;

    public List<AlanDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    public Page<AlanDto> findAllWithPageable(Pageable pageable) {
        Page<Alan> entityPage = repository.findAll(pageable);
        return entityPage.map(mapper::entityToDto);
    }

    public AlanDto findById(Long id, boolean throwException) throws Exception {
        if (id == null) {
            if (throwException) {
                throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.id));
            }

            return null;
        }

        Optional<Alan> entityOpt = repository.findById(id);

        if (entityOpt.isPresent()) {
            return mapper.entityToDto(entityOpt.get());
        }

        if (throwException) {
            throw new Exception(String.format(ApplicationConstants.ID_ILE_KAYIT_BULUNAMADI_UYARI_MESAJI, id));
        }

        return null;
    }

    public AlanDto saveOrUpdate(AlanDto dto) throws Exception {
        if (dto == null) {
            throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.RequestBody));
        }

        if (dto.getId() != null) {
            findById(dto.getId(), true);
        }

        Alan entity = mapper.dtoToEntity(dto);
        repository.save(entity);
        return mapper.entityToDto(entity);
    }

    public void deleteById(Long id) throws Exception {
        AlanDto dto = findById(id, true);
        repository.delete(mapper.dtoToEntity(dto));
    }
}
