package com.example.farukhmakhmutkhodzhaev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BiographyDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private UUID userId;
}
