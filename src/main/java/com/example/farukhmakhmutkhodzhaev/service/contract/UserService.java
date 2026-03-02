package com.example.farukhmakhmutkhodzhaev.service.contract;

import com.example.farukhmakhmutkhodzhaev.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto update(UserDto userDto);
    UserDto findById(UUID id);
    List<UserDto> findAll(Pageable pageable);
    void deleteById(UUID id);
}
