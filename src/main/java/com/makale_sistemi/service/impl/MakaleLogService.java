package com.makale_sistemi.service.impl;

import com.makale_sistemi.dto.MakaleLogDto;
import com.makale_sistemi.entity.MakaleLog;
import com.makale_sistemi.mapper.MakaleLogMapper;
import com.makale_sistemi.repository.MakaleLogRepository;
import com.makale_sistemi.service.IMakaleLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.makale_sistemi.constant.ApplicationConstants;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MakaleLogService implements IMakaleLogService {
    private final MakaleLogRepository repository;
    private final MakaleLogMapper mapper;

    public List<MakaleLogDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    public Page<MakaleLogDto> findAllWithPageable(Pageable pageable) {
        Page<MakaleLog> entityPage = repository.findAll(pageable);
        return entityPage.map(mapper::entityToDto);
    }

    public MakaleLogDto findById(Long id, boolean throwException) throws Exception {
        if (id == null) {
            if (throwException) {
                throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.id));
            }

            return null;
        }

        Optional<MakaleLog> entityOpt = repository.findById(id);

        if (entityOpt.isPresent()) {
            return mapper.entityToDto(entityOpt.get());
        }

        if (throwException) {
            throw new Exception(String.format(ApplicationConstants.ID_ILE_KAYIT_BULUNAMADI_UYARI_MESAJI, id));
        }

        return null;
    }

    public MakaleLogDto saveOrUpdate(MakaleLogDto dto) throws Exception {
        if (dto == null) {
            throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.RequestBody));
        }

        if (dto.getId() != null) {
            findById(dto.getId(), true);
        }

        MakaleLog entity = mapper.dtoToEntity(dto);
        repository.save(entity);
        return mapper.entityToDto(entity);
    }

    public void deleteById(Long id) throws Exception {
        MakaleLogDto dto = findById(id, true);
        repository.delete(mapper.dtoToEntity(dto));
    }
}
