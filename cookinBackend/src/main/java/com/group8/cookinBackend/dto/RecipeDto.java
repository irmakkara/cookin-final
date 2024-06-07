package com.group8.cookinBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private int recipeid;
    private int recipeTypeId;
    private int eventTypeId;
    private String Titles;
    private String Summary;
    private String Duration;
    private String Difficulty;
    private String Ingredients;
    private String Steps;
    private String URLimage;
    private Long createUserId;
}
