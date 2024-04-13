package com.attendancemanagementsystem.repository;

import com.attendancemanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUserEmailId(String userEmailId);

    List<User> findByUserFullNameContainingIgnoreCase(String name);

    List<User> findByUserRoleContainingIgnoreCase(String role);
}
