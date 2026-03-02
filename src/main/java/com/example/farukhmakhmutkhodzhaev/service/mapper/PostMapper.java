package com.example.farukhmakhmutkhodzhaev.service.mapper;

import com.example.farukhmakhmutkhodzhaev.dto.PostDto;
import com.example.farukhmakhmutkhodzhaev.model.Post;
import com.example.farukhmakhmutkhodzhaev.model.User;
import com.example.farukhmakhmutkhodzhaev.repositori.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PostMapper {

    private final UserRepository userRepository;

    public PostDto toDto(Post post) {
        if (post == null) return null;
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .image(post.getImage())
                .userId(post.getUser() != null ? post.getUser().getId() : null)
                .build();
    }

    public Post toEntity(PostDto dto) {
        if (dto == null) return null;
        User user = null;
        if (dto.getUserId() != null) {
            user = userRepository.findById(dto.getUserId()).orElse(null);
        }
        return Post.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .image(dto.getImage())
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
