package com.bcv.employee.employeemanagement.service;

import com.bcv.employee.employeemanagement.entity.EmployeePersonalDetails;
import com.bcv.employee.employeemanagement.repository.DepartmentRepository;
import com.bcv.employee.employeemanagement.repository.DesignationRepository;
import com.bcv.employee.employeemanagement.repository.EmployeePersonalDetailsRepository;
import com.bcv.employee.employeemanagement.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DesignationRepository designationRepository;
    @Autowired
    private EmployeePersonalDetailsRepository employeePersonalDetailsRepository;
}
