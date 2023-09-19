package com.example.myApp.Response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {
    private String firstName;
    private String lastName;
    private String sex;
    private int bvn;
    private int phoneNo;
    private int areaCode;
    private Date dateCreated;
}
