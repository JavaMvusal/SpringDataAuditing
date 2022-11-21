package com.example.springdataauditing.repository;

import com.example.springdataauditing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
