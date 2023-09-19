package com.example.myApp.Dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String sex;
    private int branchId;
}
