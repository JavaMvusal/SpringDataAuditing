package com.example.springdataauditing.controller;

import com.example.springdataauditing.dto.InputRequest;
import com.example.springdataauditing.model.Employee;
import com.example.springdataauditing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmp")
    public String saveEmployee(@RequestBody InputRequest<Employee> request) {
        return employeeService.saveEmployee(request);
    }
    @PutMapping("/updateEmp/{id}/{salary}")
    public String updateEmployeeSalary(@PathVariable int id, @PathVariable double salary, @RequestBody InputRequest<Employee> request){
        return employeeService.updateEmployee(id, salary, request);
    }
}
