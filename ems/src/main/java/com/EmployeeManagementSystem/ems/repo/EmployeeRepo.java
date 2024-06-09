package com.EmployeeManagementSystem.ems.repo;

import com.EmployeeManagementSystem.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
//    this interface is used to perform CRUD operations on the Employee entity in the database

}
