package com.group8.cookinBackend.service;

import com.group8.cookinBackend.dto.EventTypeDto;
import com.group8.cookinBackend.dto.RecipeTypeDto;

import java.util.List;

public interface EventTypeService {
    List<EventTypeDto> getAllEventTypes();
}
