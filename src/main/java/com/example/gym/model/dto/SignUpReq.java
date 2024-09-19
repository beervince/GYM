package com.example.gym.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SignUpReq {
    private String lastname;
    private String firstname;
    private String email;
    private String password;
}
