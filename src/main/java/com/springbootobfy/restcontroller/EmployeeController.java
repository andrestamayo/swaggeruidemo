package com.springbootobfy.restcontroller;

import com.springbootobfy.dto.Employee;
import com.springbootobfy.exceptions.StateMachineException;
import com.springbootobfy.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
        } catch (StateMachineException ex) {
            return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/checkIn")
    public ResponseEntity<Employee> checkIn(@RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(employeeService.checkIn(employee), HttpStatus.OK);
        } catch (StateMachineException ex) {
            return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/aproove")
    public ResponseEntity<Employee> aproove(@RequestBody Employee employee) throws StateMachineException {
        try {
            return new ResponseEntity<>(employeeService.aproove(employee), HttpStatus.OK);
        } catch (StateMachineException ex) {
            return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/activate")
    public ResponseEntity<Employee> activate(@RequestBody Employee employee) {

        try {
            return new ResponseEntity<>(employeeService.active(employee), HttpStatus.OK);
        } catch (StateMachineException ex) {
            return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/all")
    public List<Employee> all() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

}
