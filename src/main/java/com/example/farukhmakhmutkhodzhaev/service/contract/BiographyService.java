package com.example.farukhmakhmutkhodzhaev.service.contract;

import com.example.farukhmakhmutkhodzhaev.dto.BiographyDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface BiographyService {
    BiographyDto create(BiographyDto biographyDto);
    BiographyDto update(BiographyDto biographyDto);
    BiographyDto findById(UUID id);
    List<BiographyDto> findAll(Pageable pageable);
    void deleteById(UUID id);
}
