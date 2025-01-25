package com.examples.bsms.controller;

import com.examples.bsms.requestdto.BloodBankRequest;
import com.examples.bsms.responsedto.BloodBankResponse;
import com.examples.bsms.service.BloodBankService;
import com.examples.bsms.util.ResponseStructure;
import com.examples.bsms.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BloodBankController {

    private  final BloodBankService bloodBankService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/register-bloodbank")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> registerUser(@RequestBody BloodBankRequest bloodBankRequest){
        BloodBankResponse bloodBankResponse=bloodBankService.registerBloodBank(bloodBankRequest);
        return restResponseBuilder.success(HttpStatus.CREATED,"user Created",bloodBankResponse);
    }
    @GetMapping("/bloodbanks/{bloodbankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> findBloodBankById(@PathVariable int bloodbankId){
        BloodBankResponse bloodBankResponse=bloodBankService.findBloodById(bloodbankId);
        return restResponseBuilder.success(HttpStatus.OK,"User found Successfully",bloodBankResponse);
    }
    @PutMapping("/update/{bloodbankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> updateUser(@RequestBody BloodBankRequest bloodBankRequest, @PathVariable int bloodbankId){
        BloodBankResponse bloodBankResponse=bloodBankService.updateBloodBank(bloodBankRequest,bloodbankId);
        return  restResponseBuilder.success(HttpStatus.OK,"User Updated ",bloodBankResponse);
    }

}
