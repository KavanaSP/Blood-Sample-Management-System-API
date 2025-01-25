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
    private String email;
    private String password;
    private String phoneNumber;
    private UserRole role;
    private BloodGroup bloodGroup;
    private Gender gender;
    private int age;
    private String availableCity;
    private LocalDate lastDonateAt;
    private boolean verified;

    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER)
    private Admin admin;

}
