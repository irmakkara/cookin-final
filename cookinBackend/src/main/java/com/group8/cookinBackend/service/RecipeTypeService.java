package com.group8.cookinBackend.service;

import com.group8.cookinBackend.dto.RecipeTypeDto;

import java.util.List;

public interface RecipeTypeService {
    List<RecipeTypeDto> getAllRecipeTypes();
    RecipeTypeDto getRecipeTypeById(int id);
    RecipeTypeDto createRecipeType(RecipeTypeDto recipeTypeDto);
}
