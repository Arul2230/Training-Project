package com.ideas2it.employeeinformation.project.dao.impl;

import java.lang.StringBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.project.dao.ProjectDao;
import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.utils.HibernateUtil;

/**
 * ProjectDaoImpl is the dao class implements the ProjectDao interface and
 * it is processing all the interface methods and this class is having its own
 * method to fetch the EmployeeDetails of an Project.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove, Search
 * and Display the details in the Database.
 * </p>
 * ProjectList is used to store the values of the Project details which are
 * gathered from the database.
 *
 * @author    Arul Murugan
 * @version   1.0
 */

public class ProjectDaoImpl implements ProjectDao {

    public ProjectDaoImpl() {
    }

   /**
     * {@inheritDoc}
     */
    public Integer insertProject(final Project project)
            throws ApplicationException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer projectId = null;
        try {
            transaction = session.beginTransaction();
            projectId = (Integer)session.save(project); 
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new ApplicationException(Constants.PROJECT_ADD_FAIL+
                    project.getName(), e);
        } finally {
            HibernateUtil.close(session);
        }
        return projectId;
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateProject(Project project) throws ApplicationException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean isUpdated = Boolean.TRUE;
        try {
            transaction = session.beginTransaction();
            session.clear(); 
            session.merge(project); 
            transaction.commit();
            isUpdated = Boolean.TRUE;
        } catch (HibernateException e) {
            e.printStackTrace();
            if (null != transaction) {
               transaction.rollback();
            }
            throw new ApplicationException(Constants.PROJECT_MODIFY_FAILED+
                    project.getId(), e);
         } finally {
            HibernateUtil.close(session);
         }
        return isUpdated;
    }

    /**
     * {@inheritDoc}
     */
    public Project selectProjectById(int projectId)
            throws ApplicationException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Project project = null;
        try {
            project = session.get(Project.class, projectId);
        } catch (HibernateException e) {
            throw new ApplicationException(Constants.PROJECT_SEARCH_FAIL+
                    projectId, e);
        } finally {
            HibernateUtil.close(session);
        }
        return project;
    }

    /**
     * {@inheritDoc}
     */
    public List<Project> getAllProjects() throws ApplicationException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Project> projects = new ArrayList<Project>();
        try {
            projects = session.createQuery(Constants.PROJECT_DB).list();
        } catch (HibernateException e) {
            throw new ApplicationException(Constants.PROJECT_NOT_DISPLAYED, e);
        } finally {
            HibernateUtil.close(session);
        }
        return projects;
    }
}
