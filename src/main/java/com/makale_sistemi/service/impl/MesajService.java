package com.makale_sistemi.service.impl;

import com.makale_sistemi.dto.MesajDto;
import com.makale_sistemi.entity.Mesaj;
import com.makale_sistemi.mapper.MesajMapper;
import com.makale_sistemi.repository.MesajRepository;
import com.makale_sistemi.service.IMesajService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.makale_sistemi.constant.ApplicationConstants;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MesajService implements IMesajService {
    private final MesajRepository repository;
    private final MesajMapper mapper;

    public List<MesajDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    public Page<MesajDto> findAllWithPageable(Pageable pageable) {
        Page<Mesaj> entityPage = repository.findAll(pageable);
        return entityPage.map(mapper::entityToDto);
    }

    public MesajDto findById(Long id, boolean throwException) throws Exception {
        if (id == null) {
            if (throwException) {
                throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.id));
            }

            return null;
        }

        Optional<Mesaj> entityOpt = repository.findById(id);

        if (entityOpt.isPresent()) {
            return mapper.entityToDto(entityOpt.get());
        }

        if (throwException) {
            throw new Exception(String.format(ApplicationConstants.ID_ILE_KAYIT_BULUNAMADI_UYARI_MESAJI, id));
        }

        return null;
    }

    public MesajDto saveOrUpdate(MesajDto dto) throws Exception {
        if (dto == null) {
            throw new Exception(String.format(ApplicationConstants.ZORUNLU_UYARI_MESAJI, ApplicationConstants.RequestBody));
        }

        if (dto.getId() != null) {
            findById(dto.getId(), true);
        }

        Mesaj entity = mapper.dtoToEntity(dto);
        repository.save(entity);
        return mapper.entityToDto(entity);
    }

    public void deleteById(Long id) throws Exception {
        MesajDto dto = findById(id, true);
        repository.delete(mapper.dtoToEntity(dto));
    }
}
