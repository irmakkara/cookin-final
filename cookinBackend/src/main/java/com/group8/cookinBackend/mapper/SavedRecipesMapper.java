package com.group8.cookinBackend.mapper;
import com.group8.cookinBackend.dto.SavedRecipesDto;
import com.group8.cookinBackend.entity.SavedRecipes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SavedRecipesMapper {
    SavedRecipesMapper INSTANCE = Mappers.getMapper(SavedRecipesMapper.class);

    SavedRecipesDto toDTO(SavedRecipes savedRecipe);
    SavedRecipes toEntity(SavedRecipesDto savedRecipeDTO);
}