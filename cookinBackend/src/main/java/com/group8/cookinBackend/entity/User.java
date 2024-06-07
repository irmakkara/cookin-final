package com.group8.cookinBackend.entity;
import com.group8.cookinBackend.dto.RecipeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = true)
    private String name;

    @Column(name = "surname",nullable = true)
    private String surname;

    @Column(name = "username",nullable = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password",nullable = true)
    private String password;
}
