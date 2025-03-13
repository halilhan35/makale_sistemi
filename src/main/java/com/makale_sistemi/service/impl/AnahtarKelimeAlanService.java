package com.makale_sistemi.service.impl;

import com.makale_sistemi.dto.AnahtarKelimeAlanDto;
import com.makale_sistemi.entity.AnahtarKelimeAlan;
import com.makale_sistemi.mapper.AnahtarKelimeAlanMapper;
import com.makale_sistemi.repository.AnahtarKelimeAlanRepository;
import com.makale_sistemi.service.IAnahtarKelimeAlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.makale_sistemi.constant.ApplicationConstants;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnahtarKelimeAlanService implements IAnahtarKelimeAlanService {
    private final AnahtarKelimeAlanRepository repository;
    private final AnahtarKelimeAlanMapper mapper;

    public List<AnahtarKelimeAlanDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    public Page<AnahtarKelimeAlanDto> findAllWithPageable(Pageable pageable) {
        Page<AnahtarKelimeAlan> entityPage = repository.findAll(pageable);
        return entityPage.map(mapper::entityToDto);
    }

    public AnahtarKelimeAlanDto findById(Long id, boolean throwException) throws Exception {
        if (id == null) {
            if (throwException) {
                throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.id));
            }

            return null;
        }

        Optional<AnahtarKelimeAlan> entityOpt = repository.findById(id);

        if (entityOpt.isPresent()) {
            return mapper.entityToDto(entityOpt.get());
        }

        if (throwException) {
            throw new Exception(String.format(ApplicationConstants.ID_ILE_KAYIT_BULUNAMADI_UYARI_MESAJI, id));
        }

        return null;
    }

    public AnahtarKelimeAlanDto saveOrUpdate(AnahtarKelimeAlanDto dto) throws Exception {
        if (dto == null) {
            throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.RequestBody));
        }

        if (dto.getId() != null) {
            findById(dto.getId(), true);
        }

        AnahtarKelimeAlan entity = mapper.dtoToEntity(dto);
        repository.save(entity);
        return mapper.entityToDto(entity);
    }

    public void deleteById(Long id) throws Exception {
        AnahtarKelimeAlanDto dto = findById(id, true);
        repository.delete(mapper.dtoToEntity(dto));
    }
}
