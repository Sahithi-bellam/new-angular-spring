package com.bcv.employee.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeRequestDTO {
    private LocalDate hireDate;
    private int hireManagerId;
    private int departmentId;
    private int designationId;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private LocalDate validFrom;
    private LocalDate validTo;
    private BigInteger mobileNumber;
    private Integer accountNumber;
    private String bankName;
    private String bankCode;
    private AddressDTO addressDTO;
}
