package com.examples.bsms.serviceimpl;

import com.examples.bsms.entity.BloodBank;
import com.examples.bsms.exception.UserNotFoundByIdException;
import com.examples.bsms.repository.BloodBankRepository;
import com.examples.bsms.requestdto.BloodBankRequest;
import com.examples.bsms.responsedto.BloodBankResponse;
import com.examples.bsms.service.BloodBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BloodBankServiceImpl implements BloodBankService {

    private final BloodBankRepository bloodBankRepository;

    @Override
    public BloodBankResponse registerBloodBank(BloodBankRequest bloodBankRequest) {
        BloodBank bloodBank = this.maptoBloodBank(bloodBankRequest, new  BloodBank());
        bloodBank = bloodBankRepository.save(bloodBank);
        return  this.mapToBloodBankResponse(bloodBank);
    }

    private BloodBank maptoBloodBank(BloodBankRequest bloodBankRequest, BloodBank bloodBank) {
        bloodBank.setBankName(bloodBankRequest.getBankName());
        bloodBank.setEmergencyUnitCount(bloodBankRequest.getEmergencyUnitCount());
        return bloodBank;
    }

    private BloodBankResponse mapToBloodBankResponse(BloodBank bloodBank) {
        return BloodBankResponse.builder()
                .bankId(bloodBank.getBankId())
                .bankName(bloodBank.getBankName())
                .emergencyUnitCount(bloodBank.getEmergencyUnitCount())
                .build();
    }

    @Override
    public BloodBankResponse findBloodById(int bankId) {
        return bloodBankRepository.findById(bankId).map(this::mapToBloodBankResponse).orElseThrow();
    }

    @Override
    public BloodBankResponse updateBloodBank(BloodBankRequest bloodBankRequest, int bankId){
        Optional<BloodBank> optional = bloodBankRepository.findById(bankId);
        if (optional.isEmpty())
            throw new UserNotFoundByIdException(("Fail to updated to user" +bankId));
        BloodBank bloodBank = this.maptoBloodBank(bloodBankRequest, optional.get());
        bloodBankRepository.save(bloodBank);
        return this.mapToBloodBankResponse(bloodBank);
    }

//    @Override
//    public List<BloodBankResponse> findAll() {
//        return List.of();
//    }

}
