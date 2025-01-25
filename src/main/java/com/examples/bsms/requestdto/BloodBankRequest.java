package com.examples.bsms.requestdto;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankRequest {

    private String bankName;
    private int emergencyUnitCount;

}
