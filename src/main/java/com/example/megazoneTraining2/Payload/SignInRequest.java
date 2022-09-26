package com.example.megazoneTraining2.Payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignInRequest {
    private String username;
    private String password;
}
