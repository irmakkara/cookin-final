package com.group8.cookinBackend.service.impl;

import com.group8.cookinBackend.dto.RecipeDto;
import com.group8.cookinBackend.entity.Recipe;
import com.group8.cookinBackend.entity.User;
import com.group8.cookinBackend.exception.ResourceNotFoundException;
import com.group8.cookinBackend.mapper.RecipeMapper;
import com.group8.cookinBackend.mapper.UserMapper;
import com.group8.cookinBackend.repository.RecipeRepository;
import com.group8.cookinBackend.repository.UserRepository;
import com.group8.cookinBackend.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Override
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = RecipeMapper.INSTANCE.toEntity(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return RecipeMapper.INSTANCE.toDTO(savedRecipe);
    }

    @Override
    public RecipeDto getRecipeById(int recipeid) {
        Recipe recipe = recipeRepository.findById(recipeid)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe does not exist with the given id: " + recipeid));
        return RecipeMapper.INSTANCE.toDTO(recipe);
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(RecipeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> getRecipesByTypeId(int recipetypeid) {
        List<Recipe> recipes = recipeRepository.findByRecipeTypeId(recipetypeid);
        return recipes.stream()
                .map(RecipeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> getRecipesByEventTypeId(int eventtypesid) {
        List<Recipe> recipes = recipeRepository.findByEventTypeId(eventtypesid);
        return recipes.stream()
                .map(RecipeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
