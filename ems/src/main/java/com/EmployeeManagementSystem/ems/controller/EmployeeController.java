package com.EmployeeManagementSystem.ems.controller;

import com.EmployeeManagementSystem.ems.exception.ResourceNotFoundException;
import com.EmployeeManagementSystem.ems.model.Employee;
import com.EmployeeManagementSystem.ems.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")  // Add this line to enable CORS for this controller
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    // get all employees
    @GetMapping("/employees")
    // the "/employees" is an url endpoint and this REST API will get called when a client enters http://localhost:8080/api/v1/employees
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // create employee REST API
    @PostMapping("/employees") // this method will handle POST request at this endpoint
    public Employee createEmployee(@RequestBody Employee employee) {
        // RequestBody annotation is used to bind the request body to a method parameter
        return employeeRepo.save(employee);
    }

    // get employee by id REST API
    @GetMapping("/employees/{id}")
    // the "/employees/{id}" is an url endpoint and this REST API will get called when a client enters http://localhost:8080/api/v1/employees/{id}
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        // PathVariable annotation is used to map the id value from the URL to the method parameter
        return ResponseEntity.ok(employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id)));
        // orElseThrow() method is used to throw a custom exception when the record does not exist in the database
        // ResponseEntity is used to return the response with the status code and .ok is used to return the response with the status code 200
    }

    // update employee REST API
    @PutMapping("/employees/{id}")
    // this method will handle PUT request at this endpoint
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        // PathVariable annotation is used to map the id value from the URL to the method parameter
        // RequestBody annotation is used to bind the request body to a method parameter
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        // orElseThrow() method is used to throw a custom exception when the record does not exist in the database
        employee.setId(employeeDetails.getId());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhone(employeeDetails.getPhone());
        employee.setPosition(employeeDetails.getPosition());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setDOB(employeeDetails.getDOB());
        employee.setJoinDate(employeeDetails.getJoinDate());
        // set the updated values to the employee object
        Employee updatedEmployee = employeeRepo.save(employee);
        return ResponseEntity.ok(updatedEmployee);
        // ResponseEntity is used to return the response with the status code and .ok is used to return the response with the status code 200
    }


    // delete employee REST API
    @DeleteMapping("/employees/{id}")
    // this method will handle DELETE request at this endpoint
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id){
        // PathVariable annotation is used to map the id value from the URL to the method parameter
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        // orElseThrow() method is used to throw a custom exception when the record does not exist in the database
        employeeRepo.delete(employee);
        return ResponseEntity.ok(Boolean.TRUE);
        // ResponseEntity is used to return the response with the status code and .ok is used to return the response with the status code 200
    }

}
