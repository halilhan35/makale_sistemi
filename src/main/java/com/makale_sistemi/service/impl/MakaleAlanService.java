package com.makale_sistemi.service.impl;

import com.makale_sistemi.dto.MakaleAlanDto;
import com.makale_sistemi.entity.MakaleAlan;
import com.makale_sistemi.mapper.MakaleAlanMapper;
import com.makale_sistemi.repository.MakaleAlanRepository;
import com.makale_sistemi.service.IMakaleAlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.makale_sistemi.constant.ApplicationConstants;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MakaleAlanService implements IMakaleAlanService {
    private final MakaleAlanRepository repository;
    private final MakaleAlanMapper mapper;

    public List<MakaleAlanDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    public Page<MakaleAlanDto> findAllWithPageable(Pageable pageable) {
        Page<MakaleAlan> entityPage = repository.findAll(pageable);
        return entityPage.map(mapper::entityToDto);
    }

    public MakaleAlanDto findById(Long id, boolean throwException) throws Exception {
        if (id == null) {
            if (throwException) {
                throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.id));
            }

            return null;
        }

        Optional<MakaleAlan> entityOpt = repository.findById(id);

        if (entityOpt.isPresent()) {
            return mapper.entityToDto(entityOpt.get());
        }

        if (throwException) {
            throw new Exception(String.format(ApplicationConstants.ID_ILE_KAYIT_BULUNAMADI_UYARI_MESAJI, id));
        }

        return null;
    }

    public MakaleAlanDto saveOrUpdate(MakaleAlanDto dto) throws Exception {
        if (dto == null) {
            throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.RequestBody));
        }

        if (dto.getId() != null) {
            findById(dto.getId(), true);
        }

        MakaleAlan entity = mapper.dtoToEntity(dto);
        repository.save(entity);
        return mapper.entityToDto(entity);
    }

    public void deleteById(Long id) throws Exception {
        MakaleAlanDto dto = findById(id, true);
        repository.delete(mapper.dtoToEntity(dto));
    }
}
