package com.group8.cookinBackend.service;

import com.group8.cookinBackend.dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    RecipeDto createRecipe(RecipeDto recipeDto);

    RecipeDto getRecipeById(int recipeid);

    List<RecipeDto> getAllRecipes();
    List<RecipeDto> getRecipesByTypeId(int recipetypeid);
    List<RecipeDto> getRecipesByEventTypeId(int eventtypesid);
}
