package com.example.UserManagement.Service;

import com.example.UserManagement.Dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByid(Long id);
    List<UserDto> getAllUsers();

    UserDto updateUser(Long id,UserDto userDto);

    void deleteUser(Long id);

}
