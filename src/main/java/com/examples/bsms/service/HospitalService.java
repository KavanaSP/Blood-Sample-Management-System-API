package com.examples.bsms.service;

import com.examples.bsms.requestdto.HospitalRequest;
import com.examples.bsms.responsedto.HospitalResponse;

public interface HospitalService {

    HospitalResponse registerHospital(HospitalRequest hospitalRequest);

    HospitalResponse findHospitalById(int hospitalId);


    HospitalResponse updateHospital(HospitalRequest hospitalRequest, int hospitalId);
}
