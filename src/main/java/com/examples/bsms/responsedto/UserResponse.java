package com.examples.bsms.responsedto;

import com.examples.bsms.entity.User;
import com.examples.bsms.enums.BloodGroup;
import com.examples.bsms.enums.Gender;
import com.examples.bsms.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private int userId;
    private String username;
    private UserRole role;
    private BloodGroup bloodGroup;
    private Gender gender;
    private int age;
    private String availableCity;
    private LocalDate lastDonateAt;
    private boolean verified;

}
