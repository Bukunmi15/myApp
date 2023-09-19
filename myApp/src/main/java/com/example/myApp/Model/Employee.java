package com.example.myApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emp_id", nullable = false)
    private Long empId;

    @Basic
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Basic
    @Column(name = "sex", nullable = false)
    private String sex;

    @Basic
    @Column(name = "branch_id", nullable = false)
    private int branchId;

    @Basic
    @Column(name = "date_created" , nullable = false)
    private Date dateCreated;
}
