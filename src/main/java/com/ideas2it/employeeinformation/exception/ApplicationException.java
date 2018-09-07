package com.ideas2it.employeeinformation.exception;

/**
 * ApplicationException is the Exception class is having the custom Exception
 * are used to handle the checked Exception occurs in the Application.This class
 * extends Exception and handles the exception, provides the normal flow of the
 * program Execution.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class ApplicationException extends Throwable {

    public ApplicationException(String message) {

        super(message);
    }

    public ApplicationException(Throwable message) {

        super(message);
    }

    public ApplicationException(String message, Throwable cause) {

        super(message,cause);
    }
}
