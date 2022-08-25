package com.bcv.employee.employeemanagement.controller;

import com.bcv.employee.employeemanagement.Helper.EmployeeHelper;
import com.bcv.employee.employeemanagement.dto.AddressDTO;
import com.bcv.employee.employeemanagement.dto.EmployeeResponseDTO;
import com.bcv.employee.employeemanagement.entity.Department;
import com.bcv.employee.employeemanagement.entity.Employee;
import com.bcv.employee.employeemanagement.exception.EmployeeNotFound;
import com.bcv.employee.employeemanagement.service.EmployeeService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value="${application.baseUrl}/fetch")
public class EmployeeFetchController {
    @Autowired
    private EmployeeService employeeService;

    @PersistenceContext
    EntityManager em;

    @GetMapping("/hello-api")
    public String sayHi(){
        return "Welcome";
    }

    @GetMapping("/get-all")
    public List<Employee> getAllEmployee(){
        return employeeService.getEmployeeRepository().findAll();
    }

    @GetMapping("/get-all/query")
    public List<Employee> getAllEmployeebyQuery(){
        String jpql="select e from Employee e";
        //Query query=em.createQuery(jpql);
        TypedQuery<Employee> tquery=em.createQuery(jpql, Employee.class);
        return tquery.getResultList();
    }
    @GetMapping("/employee-by-id/{id}")
    public EmployeeResponseDTO getEmployeebyId(@PathVariable(name="id") int employeeId) throws Exception {
        Optional<Employee> e=employeeService.getEmployeeRepository().findById(employeeId);
        //EmployeeResponseDTO employeeResponseDTO = EmployeeHelper.generateEmployee(e,employeeService);
        if(e.isPresent())
            return EmployeeHelper.generateEmployee(e.get(),employeeService);

        throw new EmployeeNotFound("No Employee found...");
       // return EmployeeHelper.generateEmployee(e.get(),employeeService);
    }

    @GetMapping("/employee-by-dept/{deptName}")
    public List<EmployeeResponseDTO> getEmployeebydeptName(@PathVariable(name="deptName") String departmentName){
       Department dept=employeeService.getDepartmentRepository().getDepartment(departmentName);
        List<Employee> employees=employeeService.getEmployeeRepository().getEmployeesByDepartment(dept.getId());
        return EmployeeHelper.generateListofEmployee(employees,employeeService);
    }

    @GetMapping("/employee-by-hiremanager/{managerid}")
    public List<EmployeeResponseDTO> getEmployeesByManager(@PathVariable(name="managerid") int id){
        List<Employee> employees=employeeService.getEmployeeRepository().getEmployeesByHireManager(id);
        return EmployeeHelper.generateListofEmployee(employees,employeeService);
    }

    @GetMapping("/passpoprt-expired-employees")
    public List<EmployeeResponseDTO> passportExpiredEmployess(){
        List<Employee> employees=employeeService.getEmployeeRepository().getEmployeesnotExpired();
        return EmployeeHelper.generateListofEmployee(employees,employeeService);
    }

    @GetMapping("/filter/employee")
    public MappingJacksonValue employeeFilter(){
        List<EmployeeResponseDTO> employees=EmployeeHelper.generateListofEmployee(employeeService.getEmployeeRepository().findAll(),employeeService);
        Set<String> filter = Stream.of("departmentName","hireDate","designation","firstName","lastName","emailAddress","mobileNumber").collect(Collectors.toSet());
        SimpleBeanPropertyFilter empFilter=SimpleBeanPropertyFilter.filterOutAllExcept(filter);
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().addFilter("EmployeeResponse",empFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employees);
        mappingJacksonValue.setFilters(simpleFilterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/filter/manager")
    public MappingJacksonValue managerFilter(){
        List<EmployeeResponseDTO> employees=EmployeeHelper.generateListofEmployee(employeeService.getEmployeeRepository().findAll(),employeeService);
        Set<String> filter = Stream.of("departmentName","hireDate","designation","firstName","lastName","emailAddress","mobileNumber","bankName","passportNumber","accountNumber").collect(Collectors.toSet());
        SimpleBeanPropertyFilter empFilter=SimpleBeanPropertyFilter.filterOutAllExcept(filter);
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().addFilter("EmployeeResponse",empFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employees);
        mappingJacksonValue.setFilters(simpleFilterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/find-area/{pinnumber}")
    public ResponseEntity<Object> findArea(@PathVariable(name="pinnumber") int pin){
        String baseUrl="https://api.postalpincode.in/pincode/"+pin;
        RestTemplate restTemplate=new RestTemplate();
        Object response=restTemplate.getForObject(baseUrl, Object.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
