package com.example.farukhmakhmutkhodzhaev.repositori;

import com.example.farukhmakhmutkhodzhaev.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
