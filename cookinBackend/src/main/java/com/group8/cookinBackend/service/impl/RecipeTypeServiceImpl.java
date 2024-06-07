package com.group8.cookinBackend.service.impl;

import com.group8.cookinBackend.dto.RecipeTypeDto;
import com.group8.cookinBackend.entity.EventType;
import com.group8.cookinBackend.entity.RecipeType;
import com.group8.cookinBackend.exception.ResourceNotFoundException;
import com.group8.cookinBackend.mapper.EventTypeMapper;
import com.group8.cookinBackend.mapper.RecipeTypeMapper;
import com.group8.cookinBackend.repository.EventTypeRepository;
import com.group8.cookinBackend.repository.RecipeTypeRepository;
import com.group8.cookinBackend.service.RecipeTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeTypeServiceImpl implements RecipeTypeService {
    private RecipeTypeRepository recipeTypeRepository;

    @Override
    public List<RecipeTypeDto> getAllRecipeTypes() {
        List<RecipeType> recipeTypes = recipeTypeRepository.findAll();
        return recipeTypes.stream().map((recipe) -> RecipeTypeMapper.INSTANCE.toDTO(recipe))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeTypeDto getRecipeTypeById(int id) {
        RecipeType recipeType = recipeTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecipeType not found with id: " + id));
        return RecipeTypeMapper.INSTANCE.toDTO(recipeType);
    }

    @Override
    public RecipeTypeDto createRecipeType(RecipeTypeDto recipeTypeDto) {
        RecipeType recipeType = RecipeTypeMapper.INSTANCE.toEntity(recipeTypeDto);
        RecipeType savedRecipeType = recipeTypeRepository.save(recipeType);
        return RecipeTypeMapper.INSTANCE.toDTO(savedRecipeType);
    }
}
