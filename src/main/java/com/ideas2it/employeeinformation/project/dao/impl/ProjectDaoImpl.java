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

import com.ideas2it.employeeinformation.HibernateDao;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.logger.Logger;
import com.ideas2it.employeeinformation.project.dao.ProjectDao;
import com.ideas2it.employeeinformation.project.model.Project;

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

public class ProjectDaoImpl extends HibernateDao implements ProjectDao {

    public ProjectDaoImpl() {
    }

   /**
     * {@inheritDoc}
     */
    public boolean insertProject(final Project project)
            throws ApplicationException {

        Session session = getSession();
        project.setIsActive(Boolean.TRUE);
        Transaction transaction = null;
        boolean isInserted = Boolean.FALSE;
        try {
            transaction = session.beginTransaction();
            session.save(project); 
            transaction.commit();
            isInserted = Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                PROJECT_ADD_FAIL, project.getName()), e);
        } finally {
            close(session);
        }
        return isInserted;
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateProject(Project project) throws ApplicationException {

        Session session = getSession();
        Transaction transaction = null;
        boolean isUpdated = Boolean.TRUE;
        try {
            transaction = session.beginTransaction();
            session.clear(); 
            session.merge(project); 
            transaction.commit();
            isUpdated = Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
               transaction.rollback();
            }
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                PROJECT_MODIFY_FAILED, project.getId()), e);
         } finally {
            close(session);
         }
        return isUpdated;
    }

    /**
     * {@inheritDoc}
     */
    public boolean inActivateProject(final Project project)
            throws ApplicationException {
        project.setIsActive(Boolean.FALSE);
        return updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean activateProjectById(final Integer projectId)
            throws ApplicationException {

        Project project = selectProjectById(projectId);
        project.setIsActive(Boolean.TRUE);
        return updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public Project selectProjectById(int projectId)
            throws ApplicationException {

        Session session = getSession();
        Project project = null;
        try {
            project = session.get(Project.class, projectId);
        } catch (HibernateException e) {
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                PROJECT_SEARCH_FAIL, projectId), e);
        } finally {
            close(session);
        }
        return project;
    }

    /**
     * {@inheritDoc}
     */
    public List<Project> getAllProjects() throws ApplicationException {

        Session session = getSession();
        List<Project> projects = new ArrayList<Project>();
        try {
            projects = session.createQuery(Constants.PROJECT_DB).list();
        } catch (HibernateException e) {
            Logger.error(e);
            throw new ApplicationException(Constants.PROJECT_NOT_DISPLAYED, e);
        } finally {
            close(session);
        }
        return projects;
    }
}
