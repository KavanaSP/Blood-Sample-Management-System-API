package com.examples.bsms.controller;

import com.examples.bsms.requestdto.BloodBankRequest;
import com.examples.bsms.requestdto.HospitalRequest;
import com.examples.bsms.responsedto.BloodBankResponse;
import com.examples.bsms.responsedto.HospitalResponse;
import com.examples.bsms.service.BloodBankService;
import com.examples.bsms.util.ResponseStructure;
import com.examples.bsms.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BloodBankController {

    private  final BloodBankService bloodBankService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register-bloodbank")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> registerBlood(@RequestBody  BloodBankRequest bloodBankRequest) {
        BloodBankResponse bloodBankResponse = bloodBankService.registerBloodBank(bloodBankRequest);
        return responseBuilder.success(HttpStatus.CREATED, "BloodBank Created", bloodBankResponse);
    }

    @GetMapping("/banks/{bankId}")
    public  ResponseEntity<ResponseStructure<BloodBankResponse>>  findBloodById(@PathVariable int bankId) {
        BloodBankResponse bloodBankResponse = bloodBankService.findBloodById(bankId);
        return responseBuilder.success(HttpStatus.FOUND, "BloodBank found successfully", bloodBankResponse);
    }

    @PutMapping("/banks/{bankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> updateBloodBank(@RequestBody BloodBankRequest bloodBankRequest, @PathVariable int bankId) {
        BloodBankResponse bloodBankResponse = bloodBankService.updateBloodBank(bloodBankRequest, bankId);
        return responseBuilder.success(HttpStatus.FOUND, "BloodBank", bloodBankResponse);
    }
//    @GetMapping("/blood-banks")
//    public ResponseEntity<ResponseStructure<List<BloodBankResponse>>> findAllBloodBank() {
//        List<BloodBankResponse> bloodBankResponses = bloodBankService.findAll();
//        return responseBuilder.success(HttpStatus.FOUND, "Blood bank fetched", bloodBankResponses);
//    }

}
