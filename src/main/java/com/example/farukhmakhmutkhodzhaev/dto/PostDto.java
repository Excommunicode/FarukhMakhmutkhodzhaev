package com.example.farukhmakhmutkhodzhaev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PostDto {
    private UUID id;
    private String title;
    private String content;
    private String image;
    private UUID userId;
}
