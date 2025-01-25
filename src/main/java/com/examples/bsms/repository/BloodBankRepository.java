package com.examples.bsms.repository;

import com.examples.bsms.entity.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodBankRepository extends JpaRepository<BloodBank, Integer> {
}
