package com.example.megazoneTraining2.Payload;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class SignUpRequest {
    private String username;
    private String email;
    private Set<String> role;
    private String password;
}
