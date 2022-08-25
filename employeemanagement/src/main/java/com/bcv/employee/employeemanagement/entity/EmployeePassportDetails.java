package com.bcv.employee.employeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePassportDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="employee_id")
    private Employee employeePassportDetails;
    @Column
    private String passportNumber;
    @Column
    private LocalDate validFrom;
    @Column
    private LocalDate validTo;

}
