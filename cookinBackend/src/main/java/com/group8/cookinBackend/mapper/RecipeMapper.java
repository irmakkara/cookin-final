package com.group8.cookinBackend.mapper;

import com.group8.cookinBackend.dto.RecipeDto;
import com.group8.cookinBackend.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto toDTO(Recipe recipe);
    Recipe toEntity(RecipeDto recipeDto);
}
