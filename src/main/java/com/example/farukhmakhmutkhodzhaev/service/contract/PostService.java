package com.example.farukhmakhmutkhodzhaev.service.contract;

import com.example.farukhmakhmutkhodzhaev.dto.PostDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PostService {
    PostDto create(PostDto postDto);
    PostDto update(PostDto postDto);
    PostDto findById(UUID id);
    List<PostDto> findAll(Pageable pageable);
    void deleteById(UUID id);
}
