package com.example.myApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

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
    @Column(name = "bvn", nullable = false)
    private int bvn;

    @Basic
    @Column(name = "phone_no", nullable = false)
    private int phoneNo;

    @Basic
    @Column(name = "area_code", nullable = false)
    private int areaCode;

    @Basic
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

}
