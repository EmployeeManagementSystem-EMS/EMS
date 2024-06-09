package com.EmployeeManagementSystem.ems.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
// entities are columns in the model/table
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column(name = "dob")
    private Date DOB;

    @Column(name = "join_date")
    private Date joinDate;

    public Employee() {
    }

    public Employee(String FirstName, String LastName, String Email, String Phone, String Position, String Department, Date DOB, Date JoinDate) {
        super();
        this.firstName = FirstName;
        this.lastName = LastName;
        this.email = Email;
        this.phone = Phone;
        this.position = Position;
        this.department = Department;
        this.DOB = DOB;
        this.joinDate = JoinDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long EmployeeID) {
        this.id = EmployeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String EmployeeFirstName) {
        this.firstName = EmployeeFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String EmployeeLastName) {
        this.lastName = EmployeeLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String EmployeeEmail) {
        this.email = EmployeeEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String EmployeePhone) {
        this.phone = EmployeePhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String EmployeePosition) {
        this.position = EmployeePosition;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String EmployeeDepartment) {
        this.department = EmployeeDepartment;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date EmployeeDOB) {
        this.DOB = EmployeeDOB;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date EmployeeJoinDate) {
        this.joinDate = EmployeeJoinDate;
    }

}


