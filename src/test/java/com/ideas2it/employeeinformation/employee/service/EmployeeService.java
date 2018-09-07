package com.ideas2it.employeeinformation.employee.service;

import java.util.List;

import com.ideas2it.employeeinformation.employee.dao.EmployeeDao;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * EmployeeService is the Service interface which is having the several data
 * manipulation methods and this class does the business logic operations
 * on the Employee Details.
 * <p>
 * It has the Implementation class which is performing the business logic
 * operations on the Employee Details.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public interface EmployeeService {

    /**
     * <p>
     * This Method is used if a user wants to Add Employee Details.
     * It gets the Employee object which contains all the information about
     * the employee that needs to be added.
     * </p>
     *
     * @param  employee Employee object type contains the Employee details
     *                  that needs to be added.
     * @return employeeId  returns the added Employee object's Id.
     * @exception throws Application Exception when the Employee Object is not
     *            inserted due to any connection error, same Employee EmailId 
     *            or same EmployeeId.
     */
    public Integer addEmployee(final Employee employee)
            throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing Employee Details with new details.The
     * Employee Id is searched by using searchEmployeeById method and
     * the details are modified.
     * </p>
     *
     * @param  employee  Employee object contains the New Employee details that
     *                   that is modified in old EmployeeId.
     * @return boolean  returns true when the Employee object is modified and
     *                  false if modification operation is failed.
     * @exception throws Application Exception when the Employee Object is not
     *            updated due to any connection error or Employee Id not found.
     */
    public boolean modifyEmployee(final Employee employee)
            throws ApplicationException;

    /**
     * <p>
     * Method to remove the Existing Employee Details.The employee object
     * contains employeeId is searched using searchEmployeebyId method
     * and the details is removed.
     * </p>
     *
     * @param  employee  an Employee object which contains the Employee
     *                   Details that needs to be removed.
     * @return boolean  returns true when the Employee object is deleted and
     *                  false if deletion operation is failed.
     * @exception throws Application Exception when the Employee Object is not
     *            deleted due to any connection error or EmployeeId not found.
     */
    public boolean removeEmployee(final Integer employeeId)
            throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing Employee Id.This method is using the
     * EmployeeId to search and returns the searched Employee Object.
     * </p>
     *
     * @param  EmployeeId  a int datatype which contains the Employee
     *                     id that needs to be searched.
     * @return returns Employee object when id is found and null
     *         when not found.
     * @exception throws Application Exception when the Employee Object is not
     *            searched due to any connection error or EmployeeId not found.
     */
    public Employee getEmployeeById(final Integer employeeId)
            throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Employee Details that were
     * stored. It gives the Employee details as an List.
     * </p>
     *
     * @return List with Employee datatype containing employee details.
     * @exception throws Application Exception when the Employee details cannot
     *            be retrieved due to any connection error or Employee not found.
     */
    public List<Employee> getEmployees() throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Inactive Employee Details that were
     * stored. It gives the Employee details as an List.
     * </p>
     *
     * @return List with Employee datatype containing employee details.
     * @exception throws Application Exception when the Employee details cannot
     *            be retrieved due to any connection error or Employee not found.
     */
    public List<Employee> getInActiveEmployees() throws ApplicationException;
}
