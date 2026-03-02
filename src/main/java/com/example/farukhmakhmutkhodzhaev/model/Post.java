package com.example.farukhmakhmutkhodzhaev.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
@Builder(toBuilder = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, unique = true)
    private String content;
    @Column(nullable = false, unique = true)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
