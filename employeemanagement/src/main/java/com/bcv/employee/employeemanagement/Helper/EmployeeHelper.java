package com.bcv.employee.employeemanagement.Helper;

import com.bcv.employee.employeemanagement.controller.EmployeeDMLController;
import com.bcv.employee.employeemanagement.dto.AddressDTO;
import com.bcv.employee.employeemanagement.dto.EmployeeRequestDTO;
import com.bcv.employee.employeemanagement.dto.EmployeeResponseDTO;
import com.bcv.employee.employeemanagement.entity.*;
import com.bcv.employee.employeemanagement.service.EmployeeService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class EmployeeHelper {

    enum EmployeeStatus{Active,Retired,Left}
    public static EmployeeResponseDTO generateEmployee(Employee emp, EmployeeService employeeService) {
        EmployeeResponseDTO employeeResponseDTO=new EmployeeResponseDTO();
        AddressDTO addressDTO=new AddressDTO();
        employeeResponseDTO.setAccountNumber(emp.getEmployeePayrollDetails().getAccountNumber());
        employeeResponseDTO.setDesignation(emp.getEmployeePersonalDetails().getDesignation().getDesignationName());
        Employee hireManager=employeeService.getEmployeeRepository().findById(emp.getHireManagerID()).get();
        employeeResponseDTO.setHireManager(hireManager.getEmployeePersonalDetails().getFirstName());
        addressDTO.setLine1(emp.getEmployeeAddress().getLine1());
        addressDTO.setLine2(emp.getEmployeeAddress().getLine2());
        addressDTO.setCity(emp.getEmployeeAddress().getCity());
        addressDTO.setZipCode(emp.getEmployeeAddress().getZipCode());
        employeeResponseDTO.setAddressDTO(addressDTO);
        employeeResponseDTO.setPassportNumber(emp.getEmployeePassportDetails().getPassportNumber());
        employeeResponseDTO.setBankName(emp.getEmployeePayrollDetails().getBankName());
        employeeResponseDTO.setDepartmentName(emp.getDepartment().getDepartmentName());
        employeeResponseDTO.setEmailAddress(emp.getEmployeePersonalDetails().getEmailAddress());
        employeeResponseDTO.setFirstName(emp.getEmployeePersonalDetails().getFirstName());
        employeeResponseDTO.setLastName(emp.getEmployeePersonalDetails().getLastName());
        employeeResponseDTO.setHireDate(emp.getHireDate());
        employeeResponseDTO.setMobileNumber(emp.getEmployeePersonalDetails().getMobileNumber());
        return employeeResponseDTO;
    }

    public static List<EmployeeResponseDTO> generateListofEmployee(List<Employee> employees, EmployeeService employeeService) {
        List<EmployeeResponseDTO> response=new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            response.add(generateEmployee(employees.get(i),employeeService));
        }
//        employees.forEach(emp -> {
//           response.add(generateEmployee(emp,employeeService));
//        });
        return response;
    }

    public static Employee createNewEmployee(EmployeeRequestDTO requestDTO,EmployeeService employeeService){
        Employee employee = createEmployee(requestDTO,employeeService);
        createEmployeePersonalDetails(requestDTO, employee,employeeService);
        createEmployeePayrollDetails(requestDTO, employee);
        createEmployeePassportDetails(requestDTO, employee);
        createEmployeeAddress(requestDTO, employee);
        return employeeService.getEmployeeRepository().save(employee);
    }

    private static void createEmployeeAddress(EmployeeRequestDTO requestDTO, Employee employee) {
        EmployeeAddress employeeAddress=new EmployeeAddress();
        employeeAddress.setLine1(requestDTO.getAddressDTO().getLine1());
        employeeAddress.setLine2(requestDTO.getAddressDTO().getLine2());
        employeeAddress.setCity(requestDTO.getAddressDTO().getCity());
        employeeAddress.setZipCode(requestDTO.getAddressDTO().getZipCode());
        employeeAddress.setEmployeeAddress(employee);
        employee.setEmployeeAddress(employeeAddress);
    }

    private static void createEmployeePassportDetails(EmployeeRequestDTO requestDTO, Employee employee) {
        EmployeePassportDetails employeePassportDetails=new EmployeePassportDetails();
        employeePassportDetails.setPassportNumber(requestDTO.getPassportNumber());
        employeePassportDetails.setValidFrom(requestDTO.getValidFrom());
        employeePassportDetails.setValidTo(requestDTO.getValidTo());
        employeePassportDetails.setEmployeePassportDetails(employee);
        employee.setEmployeePassportDetails(employeePassportDetails);
    }

    private static void createEmployeePayrollDetails(EmployeeRequestDTO requestDTO, Employee employee) {
        EmployeePayrollDetails employeePayrollDetails=new EmployeePayrollDetails();
        employeePayrollDetails.setAccountNumber(requestDTO.getAccountNumber());
        employeePayrollDetails.setAccountStatus("Active");
        employeePayrollDetails.setBankName(requestDTO.getBankName());
        employeePayrollDetails.setBankCode(requestDTO.getBankCode());
        employeePayrollDetails.setEmployeePayrollDetails(employee);
        employee.setEmployeePayrollDetails(employeePayrollDetails);
    }

    private static void createEmployeePersonalDetails(EmployeeRequestDTO requestDTO, Employee employee,EmployeeService employeeService) {
        EmployeePersonalDetails employeePersonalDetails=new EmployeePersonalDetails();
        Designation designation=employeeService.getDesignationRepository().findById(requestDTO.getDesignationId()).get();
        employeePersonalDetails.setDesignation(designation);
        employeePersonalDetails.setFirstName(requestDTO.getFirstName());
        employeePersonalDetails.setLastName(requestDTO.getLastName());
        employeePersonalDetails.setEmailAddress(requestDTO.getEmailAddress());
        employeePersonalDetails.setMobileNumber(requestDTO.getMobileNumber());
        employeePersonalDetails.setEmployeePersonalDetails(employee);
        employee.setEmployeePersonalDetails(employeePersonalDetails);
    }

    private static Employee createEmployee(EmployeeRequestDTO requestDTO,EmployeeService employeeService) {
        Employee employee=new Employee();
        Department department=employeeService.getDepartmentRepository().findById(requestDTO.getDepartmentId()).get();
        employee.setDepartment(department);
        employee.setHireDate(requestDTO.getHireDate());
        employee.setHireManagerID(requestDTO.getHireManagerId());
        employee.setLastUpdated(new Timestamp(new Date().getTime()));
        employee.setStatus(EmployeeStatus.Active.toString());
        return employee;
    }

}
