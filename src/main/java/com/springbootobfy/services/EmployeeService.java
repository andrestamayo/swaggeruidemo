/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootobfy.services;

import com.google.api.gax.rpc.InvalidArgumentException;

import com.springbootobfy.dao.EmployeeDao;
import com.springbootobfy.dto.Employee;
import com.springbootobfy.enums.State;
import com.springbootobfy.exceptions.StateMachineException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andyb
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee addEmployee(Employee employee) throws StateMachineException {
        State state = State.ADDED;
        State prevState = null;       
        return checkStateAndUpdate(employee, state, prevState);
    }

    public Employee checkIn(Employee employee) throws StateMachineException {
        State state = State.INCHECK;
        State prevState = State.ADDED;

        return checkStateAndUpdate(employee, state, prevState);
    }

    public Employee aproove(Employee employee) throws StateMachineException {
        State state = State.APPROVED;
        State prevState = State.INCHECK;
        return checkStateAndUpdate(employee, state, prevState);
    }

    public Employee active(Employee employee) throws StateMachineException {
        State state = State.ACTIVE;
        State prevState = State.APPROVED;
        return checkStateAndUpdate(employee, state, prevState);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    private Employee checkStateAndUpdate(Employee employee, State state, State prevState) throws StateMachineException {
        Employee updatedEmployee = null;
        if (employee != null) {
            if (employee.getState() != null && !employee.getState().equals(prevState) 
                    && !employee.getState().equals(State.ADDED)) {
                throw new StateMachineException();
            }else if (prevState == null || prevState.equals(employee.getState())) {
                employee.setState(state);
                updatedEmployee = employeeDao.saveEmployee(employee);
            } else {
                throw new StateMachineException();
            }
        } else {
            throw new StateMachineException("Null employee sendt");
        }
        return updatedEmployee;
    }

}
