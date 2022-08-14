package com.dpw.nexteducation.mapper;

import com.dpw.nexteducation.dto.UserDto;
import com.dpw.nexteducation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserDto entityToDto(User user);
    User dtoToEntity(UserDto userDto);

}
