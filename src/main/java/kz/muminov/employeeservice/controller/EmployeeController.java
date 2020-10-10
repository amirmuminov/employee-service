package kz.muminov.employeeservice.controller;

import kz.muminov.employeeservice.model.dto.EmployeeDTO;
import kz.muminov.employeeservice.model.entity.Employee;
import kz.muminov.employeeservice.repository.EmployeeRepository;
import kz.muminov.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    private static final String EMPLOYEE = "/employee";
    private static final String GET_EMPLOYEE = EMPLOYEE + "/{id}";
    private static final String GET_EMPLOYEES = EMPLOYEE + "/list";

    @GetMapping(GET_EMPLOYEE)
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping(GET_EMPLOYEES)
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(EMPLOYEE)
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.addEmployee(employeeDTO), HttpStatus.CREATED);
    }

}
