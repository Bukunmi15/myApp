package com.example.myApp.Response;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class EmployeeResponse {
    private String firstName;
    private String lastName;
    private String sex;
    private int branchId;
    private Date dateCreated;
}
