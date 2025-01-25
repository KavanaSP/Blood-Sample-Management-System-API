package com.examples.bsms.repository;

import com.examples.bsms.entity.Admin;
import com.examples.bsms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, User> {
}
