package com.example.farukhmakhmutkhodzhaev.service;

import com.example.farukhmakhmutkhodzhaev.dto.UserDto;
import com.example.farukhmakhmutkhodzhaev.exception.NotFoundException;
import com.example.farukhmakhmutkhodzhaev.model.User;
import com.example.farukhmakhmutkhodzhaev.repositori.UserRepository;
import com.example.farukhmakhmutkhodzhaev.service.contract.UserService;
import com.example.farukhmakhmutkhodzhaev.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        User existing = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new NotFoundException("User not found: " + userDto.getId()));
        existing.setUsername(userDto.getUsername());
        if (userDto.getPassword() != null && !userDto.getPassword().isBlank()) {
            existing.setPassword(userDto.getPassword());
        }
        return userMapper.toDto(userRepository.save(existing));
    }

    @Override
    public UserDto findById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("User not found: " + id);
        }
        userRepository.deleteById(id);
    }
}
