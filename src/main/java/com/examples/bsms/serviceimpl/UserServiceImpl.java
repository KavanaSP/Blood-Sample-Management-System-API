package com.examples.bsms.serviceimpl;

import com.examples.bsms.entity.Admin;
import com.examples.bsms.entity.Hospital;
import com.examples.bsms.entity.User;
import com.examples.bsms.enums.UserRole;
import com.examples.bsms.exception.UserNotFoundByIdException;
import com.examples.bsms.repository.AdminRepository;
import com.examples.bsms.repository.HospitalRepository;
import com.examples.bsms.repository.UserRepository;
import com.examples.bsms.requestdto.UserRequest;
import com.examples.bsms.responsedto.AdminResponse;
import com.examples.bsms.responsedto.UserResponse;
import com.examples.bsms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HospitalRepository hospitalRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        User user = this.maptoUser(userRequest, new User());
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return this.mapToUserResponse(user);

    }

    private  User maptoUser(UserRequest userRequest,User user) {
                user.setUsername(userRequest.getUsername());
                user.setEmail(userRequest.getEmail());
                user.setPassword(userRequest.getPassword());
                user.setAge(userRequest.getAge());
                user.setGender(userRequest.getGender());
                user.setBloodGroup(userRequest.getBloodGroup());
                user.setPhoneNumber(userRequest.getPhoneNumber());
                user.setAvailableCity(userRequest.getAvailableCity());
        return user;
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .role(user.getRole())
                .age(user.getAge())
                .availableCity(user.getAvailableCity())
                .bloodGroup(user.getBloodGroup())
                .gender(user.getGender())
                .verified(user.isVerified())
                .lastDonateAt(user.getLastDonateAt())
                .build();
    }

    @Override
    public UserResponse findUserById(int userId) {

        return userRepository.findById(userId).map(this::mapToUserResponse).orElseThrow();

//        Optional<User> optional = userRepository.findById(userId);
//        if (optional.isEmpty()) {
//            throw new UserNotFoundByIdException("Failed to find User with ID: " + userId);
//        }
//        User user = optional.get();
//        return getUserResponse(user);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, int userId) {
        Optional<User> optional =  userRepository.findById(userId);
        if(optional.isEmpty())
            throw new UserNotFoundByIdException("Failed to updated to user");

        User user = this.maptoUser(userRequest,optional.get());
        userRepository.save(user);
        return this.mapToUserResponse(user);
    }

    @Override
    public UserResponse promteUserToAdmin(int userId) {
        return null;
    }

    @Override
    public String promteUserToAdmin(int userId, int hospitalId) {
       User user = userRepository.findById(userId)
               .orElseThrow();

        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow();

       if (user.getRole() == UserRole.ADMIN) {
           Admin admin = adminRepository.findById(user).orElseThrow();
           adminRepository.save(admin);

           return  "admin details updated successfully";
       }

       user.setRole(UserRole.ADMIN);
       userRepository.save(user);

        Admin admin = Admin.builder()
                .user(user)
                .build();
        adminRepository.save(admin);

        return "User promoted to admin successfully";
    }

    @Override
    public AdminResponse promteUserAsAdmin(UserRequest userRequest, int userId) {
        User user = new User();
        user.setRole(UserRole.ADMIN);
        user = this.maptoUser(userRequest,user);

        user = userRepository.save(user);
        UserResponse userResponse = this.mapToUserResponse(user);
        Admin admin = new Admin();
        adminRepository.save(admin);
        return AdminResponse.builder()
                .userResponse(userResponse)
                .adminType(admin.getAdminType())
                .adminId(admin.getAdminId())
                .build();
    }


}
