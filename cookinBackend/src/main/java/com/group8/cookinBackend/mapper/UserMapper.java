package com.group8.cookinBackend.mapper;

import com.group8.cookinBackend.dto.UserDto;
import com.group8.cookinBackend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDTO(User user);
    User toEntity(UserDto userDTO);
}



