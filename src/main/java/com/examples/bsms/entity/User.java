package com.examples.bsms.entity;

import com.examples.bsms.enums.BloodGroup;
import com.examples.bsms.enums.Gender;
import com.examples.bsms.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String  email;
    private  String password;
    private String phoneNumber;
    private BloodGroup bloodGroup;
    private LocalDate lastDonatedAt;
    private int age;
    private Gender gender;
    private String availableCity;
    private UserRole role;
    private  boolean verified;

    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER)
    private  Admin admin;
}
