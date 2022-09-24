/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootobfy.dao;

import com.springbootobfy.dto.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author andyb
 */
@Service
public class EmployeeDao {

    public Employee saveEmployee(Employee empl) {
       return empl;
    }

  

    public List<Employee> getAllEmployees() {

        return new ArrayList<>();
    }

}
