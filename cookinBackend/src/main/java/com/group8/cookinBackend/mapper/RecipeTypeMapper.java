package com.group8.cookinBackend.mapper;

import com.group8.cookinBackend.dto.RecipeTypeDto;
import com.group8.cookinBackend.entity.RecipeType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeTypeMapper {
    RecipeTypeMapper INSTANCE = Mappers.getMapper(RecipeTypeMapper.class);

    RecipeTypeDto toDTO(RecipeType recipeType);
    RecipeType toEntity(RecipeTypeDto recipeTypeDTO);
}
