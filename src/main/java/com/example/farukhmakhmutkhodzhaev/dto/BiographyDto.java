package com.example.farukhmakhmutkhodzhaev.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    @NotEmpty
    @NotNull
    private String firstName;
    @NotBlank
    @NotEmpty
    @NotNull
    private String lastName;
    private LocalDate dateOfBirth;
}
