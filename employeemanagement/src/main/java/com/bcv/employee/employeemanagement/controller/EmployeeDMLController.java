package com.bcv.employee.employeemanagement.controller;

import com.bcv.employee.employeemanagement.Helper.EmployeeHelper;
import com.bcv.employee.employeemanagement.dto.EmployeeRequestDTO;
import com.bcv.employee.employeemanagement.dto.EmployeeResponseDTO;
import com.bcv.employee.employeemanagement.entity.*;
import com.bcv.employee.employeemanagement.exception.EmployeeNotFound;
import com.bcv.employee.employeemanagement.repository.EmployeeRepository;
import com.bcv.employee.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(value="${application.baseUrl}/update")
public class EmployeeDMLController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/save-employee")
    public EmployeeResponseDTO saveEmployee(@RequestBody EmployeeRequestDTO requestDTO){

       // employeeService.getEmployeeRepository().save(employee);
        //return EmployeeHelper.generateEmployee(employee,employeeService);
        //return EmployeeHelper.generateEmployee(employeeService.getEmployeeRepository().save(employee),employeeService);
        Employee emp=EmployeeHelper.createNewEmployee(requestDTO,employeeService);
        return EmployeeHelper.generateEmployee(emp,employeeService);
    }

    @PutMapping("/update-designation/{empid}/{designationid}")
    public EmployeeResponseDTO updateDesignation(@PathVariable(name="empid") int employeeId,@PathVariable(name="designationid") int designationId){
        Optional<Employee> e=employeeService.getEmployeeRepository().findById(employeeId);
        if(e.isPresent()){
            EmployeePersonalDetails employeePersonalDetails = e.get().getEmployeePersonalDetails();
            Designation designation = employeeService.getDesignationRepository().findById(designationId).get();
            employeePersonalDetails.setDesignation(designation);
            employeeService.getEmployeePersonalDetailsRepository().save(employeePersonalDetails);
            return EmployeeHelper.generateEmployee(e.get(),employeeService);
            //to update the details to the employee also
//            Employee e1=e.get();
//            e1.setEmployeePersonalDetails(employeePersonalDetails);
//            employeeService.getEmployeeRepository().save(e1);
        }
        throw new EmployeeNotFound("Employee doesnot exist...");
    }

    @DeleteMapping("/delete-employee/{id}")
    public EmployeeResponseDTO deleteEmployee(@PathVariable(name="id") int employeeId){
        Optional<Employee> e=employeeService.getEmployeeRepository().findById(employeeId);
        if(e.isPresent()){
            Employee employee=e.get();
            employeeService.getEmployeeRepository().delete(employee);
            return EmployeeHelper.generateEmployee(employee,employeeService);
        }
        throw new EmployeeNotFound("Employee doesnot exist...");
    }

}
