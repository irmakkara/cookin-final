package com.group8.cookinBackend.service;

import com.group8.cookinBackend.dto.RecipeDto;
import com.group8.cookinBackend.dto.SavedRecipesDto;
import com.group8.cookinBackend.entity.Recipe;

import java.util.List;

public interface SavedRecipesService {
    SavedRecipesDto createSavedRecipe(SavedRecipesDto savedRecipeDto);

    SavedRecipesDto getSavedRecipeById(int SavedRecipesId);

    List<SavedRecipesDto> getAllSavedRecipes();

    void deleteSavedRecipe(int SavedRecipesId);

    List<RecipeDto> getSavedRecipesByUserId(Long userId);

}
