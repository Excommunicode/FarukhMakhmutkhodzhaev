package com.example.farukhmakhmutkhodzhaev.repositori;

import com.example.farukhmakhmutkhodzhaev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
