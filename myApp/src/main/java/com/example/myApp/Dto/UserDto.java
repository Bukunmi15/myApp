package com.example.myApp.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String sex;
    private int bvn;
    private int phoneNo;
    private int areaCode;
}
