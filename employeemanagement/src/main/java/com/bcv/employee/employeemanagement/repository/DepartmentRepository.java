package com.bcv.employee.employeemanagement.repository;

import com.bcv.employee.employeemanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>  {
    @Query(value="select d from Department d where d.departmentName=:department")
    public Department getDepartment(@Param("department") String departmentname);
}
