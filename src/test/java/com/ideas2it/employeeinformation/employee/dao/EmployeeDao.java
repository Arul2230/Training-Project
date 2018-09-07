package com.ideas2it.employeeinformation.employee.dao;

import java.util.List;

import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * EmployeeDao is the DAO interface program which is having the methods
 * that is processing the data access operations of the Employee Details.
 * <p>
 * It is having the implementation clasess, which performs the Add,Modify,
 * Remove,Search and Display the Employee details.
 * </p>
 * This interface has a method to gather details of all the Employees that are
 * stored in the Database.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public interface EmployeeDao {

    /**
     * <p>
     * This Method is used when a user wants to Add a Employee Object in the
     * Database.This method gets the Employee object which contains the Employee
     * Details that needs to be added in the database.
     * </p>
     *
     * @param employee Employee object type contains the employee details in it.
     * @return employeeId  returns the added Employee object's Id.
     */
    public Integer insertEmployee(final Employee employee) 
            throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing Employee Object in the Database.The
     * new Employee Details contains the Employee Details which is modified in
     * the Old Employee Details.
     * </p>
     *
     * @param  employee  Employee object contains the Employee details that
     *                   needs to be modified.
     * @return boolean  returns true when the Employee object is modified and
     *                  false if modification operation is failed.
     */
    public boolean updateEmployee(final Employee employee)
            throws ApplicationException;

    /**
     * <p>
     * Method to search the Employee Id in the database.This method is using
     * the EmployeeId to search the Employee and is searched in the database.
     * </p>
     *
     * @param   EmployeeId  a int datatype which contains the Employee
     *                      id that needs to be searched.
     * @return  employee    returns Employee object when id is found
     *                      and null when not found.
     */
    public Employee selectEmployeeById(final Integer employeeId)
            throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Employee Details that were stored
     * in the Database. It gives the Employee details as an List.
     * </p>
     * @return  employees  List with Employee datatype containing
     *                     employee details.
     */
    public List<Employee> getAllEmployees()
            throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the inactive Employee Details that were 
     * stored in the Database. It gives the Employee details as an List.
     * </p>
     * @return  employees  List with Employee datatype containing
     *                     employee details.
     */
    public List<Employee> getAllInActiveEmployees()
            throws ApplicationException;
}
