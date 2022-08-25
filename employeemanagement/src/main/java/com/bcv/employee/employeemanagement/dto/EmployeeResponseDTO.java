package com.bcv.employee.employeemanagement.dto;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//@JsonIgnoreProperties({"bankName","passportNumber","accountNumber"})
//@JsonFilter("EmployeeResponse")
public class EmployeeResponseDTO {
    private LocalDate hireDate;
    private String hireManager;
    private String departmentName;
    private String designation;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String bankName;
    private String passportNumber;
    private BigInteger mobileNumber;
    private Integer accountNumber;
    private AddressDTO addressDTO;

}
