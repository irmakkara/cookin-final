package com.group8.cookinBackend.mapper;

import com.group8.cookinBackend.dto.EventTypeDto;
import com.group8.cookinBackend.entity.EventType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventTypeMapper {
    EventTypeMapper INSTANCE = Mappers.getMapper(EventTypeMapper.class);

    EventTypeDto toDTO(EventType eventType);
    EventType toEntity(EventTypeDto eventTypeDTO);
}