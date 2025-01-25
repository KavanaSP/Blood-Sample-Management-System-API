package com.examples.bsms.serviceimpl;

import com.examples.bsms.entity.Hospital;
import com.examples.bsms.exception.UserNotFoundByIdException;
import com.examples.bsms.repository.HospitalRepository;
import com.examples.bsms.requestdto.HospitalRequest;
import com.examples.bsms.responsedto.HospitalResponse;
import com.examples.bsms.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HospitalServiceImpl  implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public HospitalResponse registerHospital(HospitalRequest hospitalRequest) {
        Hospital hospital = this.mapToHospital(hospitalRequest, new Hospital());
        hospital = hospitalRepository.save(hospital);
        return this.mapToHospitalResponse(hospital);
    }


    private Hospital mapToHospital(HospitalRequest hospitalRequest, Hospital hospital) {
        hospital.setHospitalName(hospitalRequest.getHospitalName());
        return hospital;
    }

    private HospitalResponse mapToHospitalResponse(Hospital hospital) {
        return HospitalResponse.builder()
                .hospitalId(hospital.getHospitalId())
                .hospitalName(hospital.getHospitalName())
                .build();
    }

    @Override
    public HospitalResponse findHospitalById(int hospitalId) {
        return hospitalRepository.findById(hospitalId).map(this::mapToHospitalResponse).orElseThrow();
    }

    @Override
    public HospitalResponse updateHospital(HospitalRequest hospitalRequest, int hospitalId){
        Optional<Hospital> optional = hospitalRepository.findById(hospitalId);
        if (optional.isEmpty())
            throw new UserNotFoundByIdException(("Fail to updated to user" +hospitalId));

        Hospital hospital = this.mapToHospital(hospitalRequest,optional.get());
        hospitalRepository.save(hospital);
        return this.mapToHospitalResponse(hospital);
    }
}
