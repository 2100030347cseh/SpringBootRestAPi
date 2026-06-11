package com.example.UserManagement.ServiceImpl;

import com.example.UserManagement.Dto.UserDto;
import com.example.UserManagement.Entity.User;
import com.example.UserManagement.Exception.ResourceNotFound;
import com.example.UserManagement.Mapper.UserMapper;
import com.example.UserManagement.Repository.UserRepository;
import com.example.UserManagement.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=userMapper.toUserEntity(userDto);
        User savedUser=userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public UserDto getUserByid(Long id) {
           User user= userRepository.findById(id).orElseThrow(()-> new ResourceNotFound("The id your searching is not found: "+id));
        return userMapper.toUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> userList= userRepository.findAll();
        return userList.stream().map(userMapper::toUserDto).toList();
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {

        User user= userRepository.findById(id).orElseThrow(()-> new ResourceNotFound("The id your searching is not found: "+id));
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        User updatedUser=userRepository.save(user);
        return userMapper.toUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user= userRepository.findById(id).orElseThrow(()-> new ResourceNotFound("The id your searching is not found: "+id));
       userRepository.delete(user);
    }
}
