package com.examples.bsms.requestdto;

import com.examples.bsms.enums.BloodGroup;
import com.examples.bsms.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

//    @NotNull(message = "username cannot be null")
//    @NotBlank(message = "username cannot be blank")
//    @Pattern(regexp = "^[A-Z][a-zA-Z0-9_]{2,15}$\\n", message = "First character should be uppercase amd contains only _ as special character")
    private String username;

//    @NotNull(message = "email cannot be null")
//    @NotBlank(message = "email cannot be blank")
//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$\\n", message = "example123@gmail.com")
    private String email;

//    @NotNull(message = "password cannot be null")
//    @NotBlank(message = "password cannot be blank")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n",
//    message = "Password must be least 8 characters long and contain at least one uppercase letter, one lowercase, one special character, numbers")
    private String password;

//    @NotNull(message = "phoneNumber cannot be null")
//    @NotBlank(message = "phoneNumber cannot be blank")
//    @Pattern(regexp = "^[6-9][0-9]{9}$\\n", message = "Please enter 10 digits number")
    private String phoneNumber;

//    @Min(1)
//    @Max(100)
    private int age;

    private String availableCity;
    private BloodGroup bloodGroup;
    private Gender gender;



}
