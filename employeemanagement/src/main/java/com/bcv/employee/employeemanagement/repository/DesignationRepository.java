package com.bcv.employee.employeemanagement.repository;

import com.bcv.employee.employeemanagement.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designation,Integer> {
}
