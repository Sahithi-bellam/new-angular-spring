package com.bcv.employee.employeemanagement.repository;

import com.bcv.employee.employeemanagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value="select e from Employee e where e.department.id=:id")
    List<Employee> getEmployeesByDepartment(@Param("id") int id);

    @Query(value="select e from Employee e where e.hireManagerID=:managerID")
    List<Employee> getEmployeesByHireManager(@Param("managerID") int id);

    @Query(value="select e from Employee e where now() not between e.employeePassportDetails.validFrom and e.employeePassportDetails.validTo")
    List<Employee> getEmployeesnotExpired();
}
