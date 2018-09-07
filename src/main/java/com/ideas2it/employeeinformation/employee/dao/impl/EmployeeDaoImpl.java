package com.ideas2it.employeeinformation.employee.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria; 
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ideas2it.employeeinformation.HibernateDao;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.employee.dao.EmployeeDao;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.logger.Logger;

/**
 * EmployeeDaoImpl is the dao class implements the EmployeeDao interface and
 * it is processing all the interface methods and this class is having its own
 * method to fetch the ProjectDetails of the Employee.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove,
 * Search and Display the details in the Database implements the EmployeeDao
 * interface funtions.
 * </p>
 * ArrayList is used to store the values of the employee details which are
 * gathered from the Database.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class EmployeeDaoImpl extends HibernateDao implements EmployeeDao {

    public EmployeeDaoImpl() {
    }

    /**
     * {@inheritDoc}
     */
    public boolean insertEmployee(final Employee employee)
            throws ApplicationException {

        Session session = null;
        boolean isInserted = Boolean.FALSE;
        Transaction transaction = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            employee.setIsActive(Boolean.TRUE);
            session.save(employee);
            transaction.commit();
            isInserted = Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                EMPLOYEE_ADD_FAIL,employee.getName()), e);
        } catch (PersistenceException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                EMPLOYEE_ADD_FAIL_EMAILID, employee.getEmailId()), e);
        } finally {
            close(session);
        }
      return isInserted;
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateEmployee(final Employee employee)
            throws ApplicationException {

        Session session = null;
        Transaction transaction = null;
        boolean isUpdated = Boolean.FALSE;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.update(employee); 
            transaction.commit();
            isUpdated = Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
               transaction.rollback();
            }
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                MODIFY_FAILED, employee.getId()), e);
         } finally {
            close(session);
         }
        return isUpdated;
    }

    /**
     * {@inheritDoc}
     */
    public boolean inActivateEmployee(final Employee employee)
            throws ApplicationException {
        employee.setIsActive(Boolean.FALSE);
        return updateEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public boolean activateEmployeeById(final Integer employeeId)
            throws ApplicationException {
        Employee employee = selectEmployeeById(employeeId);
        employee.setIsActive(Boolean.TRUE);
        return updateEmployee(employee);
    }

    /**
     * {@inheritDoc}
     */
    public Employee selectEmployeeById(final Integer employeeId)
            throws ApplicationException {

        Session session = null;
        Employee employee = null;
        try {
            session = getSession();
            Criteria criteria = session.createCriteria(Employee.class).
                    add(Restrictions.eq(Constants.EMPLOYEE_ID_COLUMN,
                    employeeId));
            employee = (Employee) criteria.uniqueResult(); 
        } catch (HibernateException e) {
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                SEARCH_FAILED, employeeId), e);
        } finally {
            close(session);
        }
        return employee;
    }

    /**
     * {@inheritDoc}
     */
    public List<Employee> getAllEmployees()
            throws ApplicationException{

        Session session = null;
        List<Employee> employees = new ArrayList<Employee>();
        try {
            session = getSession();
            Criteria criteria = session.createCriteria(Employee.class);
            employees = criteria.list(); 
        } catch (HibernateException e) {
            Logger.error(e);
            throw new ApplicationException(Constants.NOT_DISPLAYED, e);
        } finally {
            close(session);
        }
        return employees;
    }
}
