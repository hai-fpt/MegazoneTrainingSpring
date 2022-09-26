package com.example.megazoneTraining2.Repository;

import com.example.megazoneTraining2.Models.ERole;
import com.example.megazoneTraining2.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
