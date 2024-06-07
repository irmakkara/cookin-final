package com.group8.cookinBackend.service.impl;

import com.group8.cookinBackend.dto.RecipeDto;
import com.group8.cookinBackend.dto.SavedRecipesDto;
import com.group8.cookinBackend.entity.Recipe;
import com.group8.cookinBackend.entity.SavedRecipes;
import com.group8.cookinBackend.entity.User;
import com.group8.cookinBackend.exception.ResourceNotFoundException;
import com.group8.cookinBackend.mapper.RecipeMapper;
import com.group8.cookinBackend.mapper.SavedRecipesMapper;
import com.group8.cookinBackend.repository.RecipeRepository;
import com.group8.cookinBackend.repository.SavedRecipesRepository;
import com.group8.cookinBackend.repository.UserRepository;
import com.group8.cookinBackend.service.SavedRecipesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SavedRecipesServiceImpl implements SavedRecipesService {
    private final SavedRecipesRepository savedRecipesRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    @Override
    @Transactional
    public SavedRecipesDto createSavedRecipe(SavedRecipesDto savedRecipeDto) {
        SavedRecipes savedRecipe = SavedRecipesMapper.INSTANCE.toEntity(savedRecipeDto);

        User user = userRepository.findById(savedRecipeDto.getUserid())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + savedRecipeDto.getUserid()));
        Recipe recipe = recipeRepository.findById(savedRecipeDto.getRecipeid())
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + savedRecipeDto.getRecipeid()));

        savedRecipe.setUser(user);
        savedRecipe.setRecipe(recipe);

        SavedRecipes saveSavedRecipes = savedRecipesRepository.save(savedRecipe);
        return SavedRecipesMapper.INSTANCE.toDTO(saveSavedRecipes);
    }

    @Override
    public SavedRecipesDto getSavedRecipeById(int savedRecipesId) {
        SavedRecipes savedRecipe = savedRecipesRepository.findById(savedRecipesId)
                .orElseThrow(() -> new ResourceNotFoundException("SavedRecipe does not exist with the given id: " + savedRecipesId));
        return SavedRecipesMapper.INSTANCE.toDTO(savedRecipe);
    }

    @Override
    public List<SavedRecipesDto> getAllSavedRecipes() {
        List<SavedRecipes> savedRecipes = savedRecipesRepository.findAll();
        return savedRecipes.stream().map(SavedRecipesMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSavedRecipe(int savedRecipesId) {
        savedRecipesRepository.findById(savedRecipesId)
                .orElseThrow(() -> new ResourceNotFoundException("SavedRecipe does not exist with the given id: " + savedRecipesId));

        savedRecipesRepository.deleteById(savedRecipesId);
    }

    @Override
    public List<RecipeDto> getSavedRecipesByUserId(Long userid) {
        List<Recipe> savedRecipes = savedRecipesRepository.findSavedRecipesByUserId(userid);
        return savedRecipes.stream().map(RecipeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
