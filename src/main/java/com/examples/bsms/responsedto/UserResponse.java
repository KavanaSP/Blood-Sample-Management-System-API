package com.examples.bsms.response;

import com.examples.bsms.enums.BloodGroup;
import com.examples.bsms.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class UserResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private BloodGroup bloodGroup;
    private Gender gender;
    private int age;
    private String availableCity;
    private LocalDate lastDonateAt;
    private boolean verified;
}
