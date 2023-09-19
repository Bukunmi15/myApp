package com.example.myApp.Service;

import com.example.myApp.Dto.UserDto;
import com.example.myApp.Model.Users;
import com.example.myApp.Repository.UserRepo;
import com.example.myApp.Response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public  UserResponse addUser(UserDto request){
        Users users = new Users();
        users.setBvn(request.getBvn());
        users.setPhoneNo(request.getPhoneNo());
        users.setAreaCode(request.getAreaCode());
        users.setSex(request.getSex());
        users.setLastName(request.getLastName());
        users.setFirstName(request.getFirstName());
        users.setDateCreated(new Date());
        userRepo.save(users);
        return modelMapper.map(users, UserResponse.class);
    }


    public UserResponse updateUser(Long id, UserDto request){
        Optional<Users> usersOptional = userRepo.findById(id);
        if(usersOptional.isEmpty()){
            throw new RuntimeException("Users not found");
        }else{
            Users users = usersOptional.get();
            users.setBvn(request.getBvn());
            users.setPhoneNo(request.getPhoneNo());
            users.setAreaCode(request.getAreaCode());
            users.setSex(request.getSex());
            users.setLastName(request.getLastName());
            users.setFirstName(request.getFirstName());
            users.setDateCreated(new Date());
            userRepo.save(users);
            return modelMapper.map(users, UserResponse.class);
        }
    }


    public List<Users> getUser(){
        List<Users> usersList = userRepo.findAll();
        return usersList;
    }


    public String deteleUser(Long id){
        Optional<Users> optionalUsers = userRepo.findById(id);
        if(optionalUsers.isEmpty()){
            return "Users nor found";
        }else {
            Users users = optionalUsers.get();
            userRepo.delete(users);
            return "Successfully deleted";
        }
    }
}
