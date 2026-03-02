package com.example.farukhmakhmutkhodzhaev.service;

import com.example.farukhmakhmutkhodzhaev.dto.PostDto;
import com.example.farukhmakhmutkhodzhaev.exception.NotFoundException;
import com.example.farukhmakhmutkhodzhaev.model.Post;
import com.example.farukhmakhmutkhodzhaev.model.User;
import com.example.farukhmakhmutkhodzhaev.repositori.PostRepository;
import com.example.farukhmakhmutkhodzhaev.repositori.UserRepository;
import com.example.farukhmakhmutkhodzhaev.service.contract.PostService;
import com.example.farukhmakhmutkhodzhaev.service.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public PostDto create(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        post.setId(null);
        return postMapper.toDto(postRepository.save(post));
    }

    @Override
    @Transactional
    public PostDto update(PostDto postDto) {
        Post existing = postRepository.findById(postDto.getId())
                .orElseThrow(() -> new NotFoundException("Post not found: " + postDto.getId()));
        existing.setTitle(postDto.getTitle());
        existing.setContent(postDto.getContent());
        existing.setImage(postDto.getImage());
        if (postDto.getUserId() != null) {
            User user = userRepository.findById(postDto.getUserId())
                    .orElseThrow(() -> new NotFoundException("User not found: " + postDto.getUserId()));
            existing.setUser(user);
        }
        return postMapper.toDto(postRepository.save(existing));
    }

    @Override
    public PostDto findById(UUID id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Post not found: " + id));
        return postMapper.toDto(post);
    }

    @Override
    public List<PostDto> findAll(Pageable pageable) {
        return postRepository.findAll(pageable).stream()
                .map(postMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!postRepository.existsById(id)) {
            throw new NotFoundException("Post not found: " + id);
        }
        postRepository.deleteById(id);
    }
}
