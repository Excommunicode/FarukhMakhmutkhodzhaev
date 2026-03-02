package com.example.farukhmakhmutkhodzhaev.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    private UUID userId;
}
