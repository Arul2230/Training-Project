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
    public boolean addEmployee(final Employee employee)
            throws ApplicationException {
        employee.setIsActive(Boolean.TRUE);
        return employeeDao.insertEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyEmployee(final Employee employee)
            throws ApplicationException {
        Employee oldEmployee = employeeDao.selectEmployeeById(employee.
            getId());
        employee.setProjects(oldEmployee.getProjects());
        return employeeDao.updateEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeEmployee(final Integer employeeId)
            throws ApplicationException {
        Employee employee = employeeDao.selectEmployeeById(employeeId);
        employee.getProjects().clear();
        return employeeDao.inActivateEmployee(employee);
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
    public boolean activateEmployee(final Integer employeeId)
            throws ApplicationException {
        return employeeDao.activateEmployeeById(employeeId);
    }
}
