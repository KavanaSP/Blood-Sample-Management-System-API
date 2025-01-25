package com.examples.bsms.service;

import com.examples.bsms.entity.User;
import com.examples.bsms.requestdto.UserRequest;
import com.examples.bsms.responsedto.AdminResponse;
import com.examples.bsms.responsedto.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest userRequest);

    UserResponse findUserById(int userId);


    UserResponse updateUserById(UserRequest userRequest, int userId);

    UserResponse promoteUserToAdmin(int userId);

    AdminResponse promoteUserAsAdmin(UserRequest userRequest, int userId);
}
