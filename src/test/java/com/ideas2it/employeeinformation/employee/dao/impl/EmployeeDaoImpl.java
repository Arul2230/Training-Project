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

import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.employee.dao.EmployeeDao;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.logger.Logger;
import com.ideas2it.employeeinformation.utils.DateUtil;
import com.ideas2it.employeeinformation.utils.HibernateUtil;

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
public class EmployeeDaoImpl implements EmployeeDao {

    public EmployeeDaoImpl() {
    }

    /**
     * {@inheritDoc}
     */
    public Integer insertEmployee(final Employee employee)
            throws ApplicationException {

        Session session = null;
        Integer employeeId;
        boolean isInserted = Boolean.TRUE;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            employee.setIsActive(Boolean.TRUE);
            employeeId = (Integer)session.save(employee);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (null != transaction) {
                transaction.rollback();
            }
            throw new ApplicationException(Constants.EMPLOYEE_ADD_FAIL+
                    employee.getName(), e);
        } catch (PersistenceException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new ApplicationException(String.format(Constants.
                EMPLOYEE_ADD_FAIL_EMAILID, employee.getEmailId()), e);
        } finally {
            HibernateUtil.close(session);
        }
      return employeeId;
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
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(employee); 
            transaction.commit();
            isUpdated = Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
               transaction.rollback();
            }
            throw new ApplicationException( Constants.MODIFY_FAILED+
                    employee.getId(), e);
         } finally {
            HibernateUtil.close(session);
         }
        return isUpdated;
    }

    /**
     * {@inheritDoc}
     */
    public Employee selectEmployeeById(final Integer employeeId)
            throws ApplicationException {

        Session session = null;
        Employee employee = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Employee.class).
                    add(Restrictions.eq(Constants.EMPLOYEE_ID_COLUMN,
                    employeeId));
            employee = (Employee) criteria.uniqueResult(); 
        } catch (HibernateException e) {
            throw new ApplicationException(Constants.SEARCH_FAILED+ 
                    employeeId, e);
        } finally {
            HibernateUtil.close(session);
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
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Employee.class).
                    add(Restrictions.eq(Constants.IS_ACTIVE,Boolean.TRUE));
            employees = criteria.list(); 
        } catch (HibernateException e) {
            throw new ApplicationException(Constants.NOT_DISPLAYED, e);
        } finally {
            HibernateUtil.close(session);
        }
        return employees;
    }

    /**
     * {@inheritDoc}
     */
    public List<Employee> getAllInActiveEmployees()
            throws ApplicationException{

        Session session = null;
        List<Employee> employees = new ArrayList<Employee>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Employee.class).
                    add(Restrictions.eq(Constants.IS_ACTIVE,Boolean.FALSE));
            employees = criteria.list(); 
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ApplicationException(Constants.NOT_DISPLAYED, e);
        } finally {
            HibernateUtil.close(session);
        }
        return employees;
    }
}
