package com.example.farukhmakhmutkhodzhaev.controller;

import com.example.farukhmakhmutkhodzhaev.dto.BiographyDto;
import com.example.farukhmakhmutkhodzhaev.service.contract.BiographyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/biographies")
@RequiredArgsConstructor
public class BiographyController {

    private final BiographyService biographyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BiographyDto create(@Valid @RequestBody BiographyDto biographyDto) {
        return biographyService.create(biographyDto);
    }

    @PutMapping("/{id}")
    public BiographyDto update(@PathVariable UUID id, @Valid @RequestBody BiographyDto biographyDto) {
        biographyDto.setId(id);
        return biographyService.update(biographyDto);
    }

    @GetMapping("/{id}")
    public BiographyDto findById(@PathVariable UUID id) {
        return biographyService.findById(id);
    }

    @GetMapping
    public List<BiographyDto> findAll(@PageableDefault(sort = "created_at", direction = Sort.Direction.ASC) Pageable page) {
        return biographyService.findAll(page);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        biographyService.deleteById(id);
    }
}
