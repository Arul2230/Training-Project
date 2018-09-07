package com.ideas2it.employeeinformation.employee.service.impl;

import java.util.List;

import com.ideas2it.employeeinformation.employee.dao.EmployeeDao;
import com.ideas2it.employeeinformation.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.employee.service.EmployeeService;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * EmployeeServiceImpl is the Service class implementing the EmployeeService
 * interface and this implements all the methods of the interface program.
 * <p>
 * It processes all the business logic operations and calls the Dao class to
 * do the data accessing operations.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeDao employeeDao ;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * {@inheritDoc}
     */
    public Integer addEmployee(final Employee employee)
            throws ApplicationException {
        employee.setIsActive(Boolean.TRUE);
        return employeeDao.insertEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyEmployee(final Employee employee)
            throws ApplicationException {
        employee.setIsActive(Boolean.TRUE);
        return employeeDao.updateEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeEmployee(final Integer employeeId)
            throws ApplicationException {
        Employee employee = employeeDao.selectEmployeeById(employeeId);
        employee.setIsActive(Boolean.FALSE);
        return employeeDao.updateEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public Employee getEmployeeById(final Integer employeeId)
            throws ApplicationException {
        return employeeDao.selectEmployeeById(employeeId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Employee> getEmployees()
            throws ApplicationException {
        return employeeDao.getAllEmployees();
    }

    /**
     * {@inheritDoc}
     */
    public List<Employee> getInActiveEmployees()
            throws ApplicationException {
        return employeeDao.getAllInActiveEmployees();
    }
}
