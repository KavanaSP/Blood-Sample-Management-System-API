package com.examples.bsms.controller;

import com.examples.bsms.entity.User;
import com.examples.bsms.requestdto.UserRequest;
import com.examples.bsms.responsedto.AdminResponse;
import com.examples.bsms.responsedto.UserResponse;
import com.examples.bsms.service.UserService;
import com.examples.bsms.util.ResponseStructure;
import com.examples.bsms.util.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Validated UserRequest userRequest){
        UserResponse user = userService.registerUser(userRequest);
        return responseBuilder.success(HttpStatus.CREATED, "User Created", user);
    }

    @GetMapping("/users/{userId}")
    public  ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId){
        UserResponse userResponse = userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.FOUND, "User found successfully", userResponse);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest, @PathVariable int userId ) {
        UserResponse response = userService.updateUser( userRequest,userId);
        return responseBuilder.success(HttpStatus.FOUND, "User", response);
    }

    @GetMapping("/{userId}/promote")
    public ResponseEntity<ResponseStructure<UserResponse>> promoteUserToAdmin(@RequestParam int userId) {
        UserResponse userResponse = userService.promteUserToAdmin(userId);
        return responseBuilder.success(HttpStatus.FOUND, "User promated admin sucessfully ", userResponse);
    }

    @PostMapping("/admins")
    public  ResponseEntity<ResponseStructure<AdminResponse>> registerUserAsAdmin(@RequestParam UserRequest userRequest, @PathVariable int userId) {
        AdminResponse adminResponse = userService.promteUserAsAdmin(userRequest,userId);
        return responseBuilder.success(HttpStatus.FOUND,"User Found", adminResponse);
    }
}
