package com.example.farukhmakhmutkhodzhaev.controller;

import com.example.farukhmakhmutkhodzhaev.dto.PostDto;
import com.example.farukhmakhmutkhodzhaev.service.contract.PostService;
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
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@Valid @RequestBody PostDto postDto) {
        return postService.create(postDto);
    }

    @PutMapping("/{id}")
    public PostDto update(@PathVariable UUID id, @Valid @RequestBody PostDto postDto) {
        postDto.setId(id);
        return postService.update(postDto);
    }

    @GetMapping("/{id}")
    public PostDto findById(@PathVariable UUID id) {
        return postService.findById(id);
    }

    @GetMapping
    public List<PostDto> findAll(@PageableDefault(sort = "created_at", direction = Sort.Direction.ASC) Pageable page) {
        return postService.findAll(page);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        postService.deleteById(id);
    }
}
