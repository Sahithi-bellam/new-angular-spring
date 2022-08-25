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
public class EmployeePayrollDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="employee_id")
    private Employee employeePayrollDetails;
    @Column
    private String bankName;
    @Column
    private Integer accountNumber;
    @Column
    private String bankCode;
    @Column
    private String accountStatus;
}
