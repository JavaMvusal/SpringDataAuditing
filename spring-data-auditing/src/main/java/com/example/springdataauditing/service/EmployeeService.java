package com.example.springdataauditing.service;

import com.example.springdataauditing.dto.InputRequest;
import com.example.springdataauditing.model.Employee;
import com.example.springdataauditing.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(InputRequest<Employee> request){
        String currentUser = request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());

        Employee employee = request.getEmployee();
        employee.setCreatedBy(currentUser);
        employeeRepository.save(employee);
        return "Employee Saved Successfully";
    }

    public String updateEmployee(int id,double salary,InputRequest<Employee> request){
    Employee employee = employeeRepository.findById(id).get();
    if(employee!=null){
        employee.setSalary(salary);
        employee.setModifiedBy(request.getLoggedInUser());
        employeeRepository.save(employee);
    }else{
        throw new RuntimeException("Employee not found with id");
    }
    return "Employee updated successfully";
    }

}
