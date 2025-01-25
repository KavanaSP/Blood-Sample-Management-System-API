package com.examples.bsms.security;

import com.examples.bsms.entity.User;
import com.examples.bsms.exception.UserNotFoundByIdException;
import com.examples.bsms.repository.UserRepository;
import com.examples.bsms.requestdto.UserRequest;
import com.examples.bsms.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ConnectionBuilder;
import java.util.Optional;

@Builder
@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByEmail(username);
        if (optional.isEmpty())
            throw new UsernameNotFoundException("Failed to User Found");

        User user = optional.get();
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}


