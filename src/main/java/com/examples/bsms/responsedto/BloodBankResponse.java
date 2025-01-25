package com.examples.bsms.responsedto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankResponse {
    private int bankId;
    private String bankName;
    private int emergencyUnitCount;
}
