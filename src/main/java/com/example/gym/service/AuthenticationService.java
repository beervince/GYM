package com.example.gym.service;


import com.example.gym.model.dto.LoginReq;
import com.example.gym.model.dto.SignUpReq;
import com.example.gym.model.user.UserEntity;
import com.example.gym.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;



    public UserEntity signup(SignUpReq input) {
        var user = UserEntity.builder()
                .lastname(input.getLastname())
                .firstname(input.getFirstname())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword())).build();

        return userRepository.save(user);
    }

    public UserEntity authenticate(LoginReq input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}

