package com.example.farukhmakhmutkhodzhaev.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "biographies")
@Builder(toBuilder = true)
public class Biography {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(name = "first_name")
    private String firstName;


    private String lastName;

    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
