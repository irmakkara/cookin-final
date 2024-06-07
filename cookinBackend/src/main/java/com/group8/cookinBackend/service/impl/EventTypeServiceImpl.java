package com.group8.cookinBackend.service.impl;

import com.group8.cookinBackend.dto.EventTypeDto;
import com.group8.cookinBackend.entity.EventType;
import com.group8.cookinBackend.mapper.EventTypeMapper;
import com.group8.cookinBackend.repository.EventTypeRepository;
import com.group8.cookinBackend.service.EventTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventTypeServiceImpl implements EventTypeService {
    private EventTypeRepository eventTypeRepository;

    @Override
    public List<EventTypeDto> getAllEventTypes() {
        List<EventType> eventTypes = eventTypeRepository.findAll();
        return eventTypes.stream().map((eventType) -> EventTypeMapper.INSTANCE.toDTO(eventType))
                .collect(Collectors.toList());

    }
}