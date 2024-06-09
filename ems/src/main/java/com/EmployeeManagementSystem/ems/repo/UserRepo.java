package com.EmployeeManagementSystem.ems.repo;

import com.EmployeeManagementSystem.ems.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
//    this interface is used to perform login operations on the User table in the database
}
