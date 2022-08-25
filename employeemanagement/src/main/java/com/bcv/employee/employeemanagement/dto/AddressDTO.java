package com.bcv.employee.employeemanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
    private String line1;
    private String line2;
    private String city;
    private Integer zipCode;
}
