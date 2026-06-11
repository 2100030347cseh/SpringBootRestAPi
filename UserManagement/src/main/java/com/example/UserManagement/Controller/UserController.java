package com.example.UserManagement.Controller;

import com.example.UserManagement.Dto.UserDto;
import com.example.UserManagement.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
   private final UserService userService;

   @PostMapping("createUser")
   public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
       UserDto savedUser=userService.createUser(userDto);
       return ResponseEntity.ok(savedUser);
   }

   @GetMapping("/{id}")
   public ResponseEntity<UserDto>getUserByid(@PathVariable Long id){
          UserDto saved =userService.getUserByid(id);
       return ResponseEntity.ok(saved);
   }
   @GetMapping("/Allusers")
   public ResponseEntity<List<UserDto>>getAllUsers(){
       List<UserDto> allUsers=userService.getAllUsers();
       return ResponseEntity.ok(allUsers);
   }
   @PutMapping("/{id}")
   public ResponseEntity<UserDto>updateUser(@PathVariable Long id,@RequestBody UserDto userDto){
       UserDto updateduser=userService.updateUser(id, userDto);
       return ResponseEntity.ok(updateduser);
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteUser(@PathVariable Long id){
       userService.deleteUser(id);
       return ResponseEntity.ok("User deleted successfully");
   }
}
