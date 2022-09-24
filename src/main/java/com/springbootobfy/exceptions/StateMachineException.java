/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootobfy.exceptions;

import java.io.PrintStream;
import org.apache.http.HttpException;

/**
 *
 * @author Andrés
 */
public class StateMachineException extends HttpException {

    private String msg;

    public StateMachineException(String null_employee_sendt) {
        
        msg = null_employee_sendt;
    }

    public StateMachineException() {
        super();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        if (msg == null) {
            s.println("Invalid Status change, valid status changes are ->- ADDED\n"
                    + "- IN-CHECK\n"
                    + "- APPROVED\n"
                    + "- ACTIVE");
            super.printStackTrace(s);
        } else {
            s.print(msg);
            super.printStackTrace();
        }

    }

}
