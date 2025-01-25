package com.examples.bsms.controller;

import com.examples.bsms.repository.UserRepository;
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
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private  final UserService userService;
    private final RestResponseBuilder restResponseBuilder;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid UserRequest userRequest){
        UserResponse userResponse=userService.registerUser(userRequest);
        return restResponseBuilder.success(HttpStatus.CREATED,"user Created",userResponse);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId){
        UserResponse userResponse=userService.findUserById(userId);
        return restResponseBuilder.success(HttpStatus.OK,"User found Successfully",userResponse);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest, @PathVariable int userId){
        UserResponse userResponse=userService.updateUserById(userRequest,userId);
        return  restResponseBuilder.success(HttpStatus.OK,"User Updated ",userResponse);
    }

    @GetMapping("/promote/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> promoteUserToAdmin(@RequestParam int userId){
        UserResponse userResponse=userService.promoteUserToAdmin(userId);
        return restResponseBuilder.success(HttpStatus.FOUND,"User promoted Admin successfully",userResponse);
    }

    @PostMapping("/admins")
    public ResponseEntity<ResponseStructure<AdminResponse>> registerUserAsAdmin(@RequestBody UserRequest userRequest,@PathVariable int userId){
        AdminResponse adminResponse=userService.promoteUserAsAdmin(userRequest,userId);
        return restResponseBuilder.success(HttpStatus.FOUND,"User Found",adminResponse);
    }


}
