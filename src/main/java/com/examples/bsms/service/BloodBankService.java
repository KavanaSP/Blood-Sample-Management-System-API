package com.examples.bsms.service;

import com.examples.bsms.requestdto.BloodBankRequest;
import com.examples.bsms.responsedto.BloodBankResponse;

import java.util.List;

public interface BloodBankService {

    BloodBankResponse registerBloodBank(BloodBankRequest bloodBankRequest);

    BloodBankResponse findBloodById(int bankId);

    BloodBankResponse updateBloodBank(BloodBankRequest bloodBankRequest, int bankId);


//    List<BloodBankResponse> findAll();
}
