package com.example.farukhmakhmutkhodzhaev.service;

import com.example.farukhmakhmutkhodzhaev.dto.BiographyDto;
import com.example.farukhmakhmutkhodzhaev.exception.NotFoundException;
import com.example.farukhmakhmutkhodzhaev.model.Biography;
import com.example.farukhmakhmutkhodzhaev.model.User;
import com.example.farukhmakhmutkhodzhaev.repositori.BiographyRepository;
import com.example.farukhmakhmutkhodzhaev.repositori.UserRepository;
import com.example.farukhmakhmutkhodzhaev.service.contract.BiographyService;
import com.example.farukhmakhmutkhodzhaev.service.mapper.BiographyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BiographyServiceImpl implements BiographyService {
    private final BiographyRepository biographyRepository;
    private final BiographyMapper biographyMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public BiographyDto create(BiographyDto biographyDto) {
        Biography biography = biographyMapper.toEntity(biographyDto);
        biography.setId(null);
        return biographyMapper.toDto(biographyRepository.save(biography));
    }

    @Override
    @Transactional
    public BiographyDto update(BiographyDto biographyDto) {


        Biography entity = biographyMapper.toEntity(biographyDto);
        return biographyMapper.toDto(biographyRepository.save(entity));

    }

    @Override
    public BiographyDto findById(UUID id) {
        Biography biography = biographyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Biography not found: " + id));
        return biographyMapper.toDto(biography);
    }

    @Override
    public List<BiographyDto> findAll(Pageable pageable) {
        return biographyRepository.findAll(pageable).stream()
                .map(biographyMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!biographyRepository.existsById(id)) {
            throw new NotFoundException("Biography not found: " + id);
        }
        biographyRepository.deleteById(id);
    }
}
