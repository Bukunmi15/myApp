package com.example.myApp.Controller;

import com.example.myApp.Dto.UserDto;
import com.example.myApp.Model.Users;
import com.example.myApp.Response.UserResponse;
import com.example.myApp.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("users")
    public UserResponse addUser(@RequestBody UserDto request){
        return userService.addUser(request);
    }

    @PutMapping("update")
    public UserResponse updateUser(@RequestBody UserDto request, @RequestParam("id") Long id){
        return userService.updateUser(id, request);
    }

    @GetMapping("get")
    public List<Users> getUser(){
        return userService.getUser();
    }

    @DeleteMapping("delete")
    public String deleteUser(@RequestParam("id")Long id){
        return userService.deteleUser(id);
    }
}
