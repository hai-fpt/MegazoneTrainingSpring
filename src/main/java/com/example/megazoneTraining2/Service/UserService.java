package com.example.megazoneTraining2.Service;

import com.example.megazoneTraining2.Models.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
}
