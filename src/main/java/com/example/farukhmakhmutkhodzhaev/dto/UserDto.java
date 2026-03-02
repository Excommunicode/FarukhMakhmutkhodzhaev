package com.example.farukhmakhmutkhodzhaev.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDto {
    private UUID id;
    @NotBlank
    @NotEmpty
    @NotNull
    private String username;
    @NotBlank
    @NotEmpty
    @NotNull
    private String password;
}
