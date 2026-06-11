package com.example.UserManagement.Mapper;

import com.example.UserManagement.Dto.UserDto;
import com.example.UserManagement.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUserDto(User userEntity){
        return new UserDto(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail()
        );
    }
    public User toUserEntity(UserDto userDto){
        return new User(
                userDto.id(),
                userDto.firstName(),
                userDto.lastName(),
                userDto.email()
        );
    }
}
