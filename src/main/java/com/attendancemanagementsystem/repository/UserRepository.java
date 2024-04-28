package com.attendancemanagementsystem.repository;

import com.attendancemanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUserEmailId(String userEmailId);

    List<User> findByUserFullNameContainingIgnoreCase(String name);

    List<User> findByUserRoleContainingIgnoreCase(String role);

    @Query("delete from User u where u.userEmailId=?1")
    boolean deleteByEmailId(String emailId);
}
