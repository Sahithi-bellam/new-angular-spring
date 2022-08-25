package com.bcv.employee.employeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="employee_id")
    private Employee employeeAddress;
    @Column
    private String city;
    @Column
    private String line1;
    @Column
    private String line2;
    @Column
    private int zipCode;
}
