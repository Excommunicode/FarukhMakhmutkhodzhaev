package com.example.farukhmakhmutkhodzhaev.repositori;

import com.example.farukhmakhmutkhodzhaev.model.Biography;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BiographyRepository extends JpaRepository<Biography, UUID> {
}
