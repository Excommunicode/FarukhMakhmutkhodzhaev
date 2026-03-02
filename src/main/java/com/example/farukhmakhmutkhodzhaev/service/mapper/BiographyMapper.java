package com.example.farukhmakhmutkhodzhaev.service.mapper;

import com.example.farukhmakhmutkhodzhaev.dto.BiographyDto;
import com.example.farukhmakhmutkhodzhaev.model.Biography;
import com.example.farukhmakhmutkhodzhaev.model.User;
import com.example.farukhmakhmutkhodzhaev.repositori.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class BiographyMapper {

    private final UserRepository userRepository;

    public BiographyDto toDto(Biography biography) {
        if (biography == null) return null;
        LocalDate dateOfBirth = null;
        if (biography.getDateOfBirth() != null) {
            dateOfBirth = biography.getDateOfBirth().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
        }
        return BiographyDto.builder()
                .id(biography.getId())
                .firstName(biography.getFirstName())
                .lastName(biography.getLastName())
                .dateOfBirth(dateOfBirth)
                .userId(biography.getUser() != null ? biography.getUser().getId() : null)
                .build();
    }

    public Biography toEntity(BiographyDto dto) {
        if (dto == null) return null;
        User user = null;
        if (dto.getUserId() != null) {
            user = userRepository.findById(dto.getUserId()).orElse(null);
        }
        Date dateOfBirth = null;
        if (dto.getDateOfBirth() != null) {
            dateOfBirth = Date.from(dto.getDateOfBirth().atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        return Biography.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dateOfBirth(dateOfBirth)
                .user(user)
                .build();
    }
}
