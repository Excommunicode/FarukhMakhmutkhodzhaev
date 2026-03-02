package com.example.farukhmakhmutkhodzhaev.controller;

import com.example.farukhmakhmutkhodzhaev.dto.UserDto;
import com.example.farukhmakhmutkhodzhaev.service.contract.UserService;
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
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@Valid @RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable UUID id, @Valid @RequestBody UserDto userDto) {
        userDto.setId(id);
        return userService.update(userDto);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserDto> findAll(@PageableDefault(sort = "created_at", direction = Sort.Direction.ASC) Pageable page) {
        return userService.findAll(page);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
    }
}
