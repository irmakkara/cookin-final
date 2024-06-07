package com.group8.cookinBackend.entity;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
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
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeid ;

    @ManyToOne
    @JoinColumn(name = "recipetypeid", referencedColumnName = "recipetypeid")
    private RecipeType recipeType;

    @ManyToOne
    @JoinColumn(name = "eventtypeid", referencedColumnName = "eventtypesid")
    private EventType eventType;

    @Column(name = "Titles",nullable = true)
    private String Titles;

    @Column(name = "Summary",nullable = true)
    private String Summary;

    @Column(name = "Duration",nullable = true)
    private String Duration;

    @Column(name = "Difficulty",nullable = true)
    private String Difficulty;

    @Column(name = "Ingredients",nullable = true)
    private String Ingredients;

    @Column(name = "Steps",nullable = true)
    private String Steps;

    @Column(name = "URLimage",nullable = true)
    private String URLimage;

    @ManyToOne
    @JoinColumn(name = "createuserid", referencedColumnName = "id")
    private User createUser;

}
