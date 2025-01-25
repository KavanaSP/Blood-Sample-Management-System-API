package com.examples.bsms.controller;

import com.examples.bsms.requestdto.HospitalRequest;
import com.examples.bsms.responsedto.HospitalResponse;
import com.examples.bsms.service.HospitalService;
import com.examples.bsms.util.ResponseStructure;
import com.examples.bsms.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final RestResponseBuilder restResponseBuilder;

    @PostMapping("/register-hospital")
    public ResponseEntity<ResponseStructure<HospitalResponse>> registerHospital(@RequestBody HospitalRequest hospitalRequest){
        HospitalResponse hospitalResponse=hospitalService.registerHospital(hospitalRequest);
        return restResponseBuilder.success(HttpStatus.CREATED,"Hospital Created",hospitalResponse);
    }

    @GetMapping("/hospitals/{hospitalId}")
    public  ResponseEntity<ResponseStructure<HospitalResponse>> findHospitalById(@PathVariable int hospitalId){
        HospitalResponse hospitalResponse=hospitalService.findHospitalById(hospitalId);
        return restResponseBuilder.success(HttpStatus.OK,"Hospital Found Successfully",hospitalResponse);
    }
    @PutMapping("/update/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>> updateHospital(@RequestBody HospitalRequest hospitalRequest, @PathVariable int hospitalId){
        HospitalResponse hospitalResponse=hospitalService.updateHospital(hospitalRequest,hospitalId);
        return  restResponseBuilder.success(HttpStatus.OK,"Updated Updated ",hospitalResponse);
    }
}
