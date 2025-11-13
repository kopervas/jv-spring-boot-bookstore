package com.bookstore.mapper;

import com.bookstore.config.MapperConfig;
import com.bookstore.dto.UserDto;
import com.bookstore.dto.UserResponseDto;
import com.bookstore.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toUserResponse (User user);

    UserDto toDto (User user);
}
