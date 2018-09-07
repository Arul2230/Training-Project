package com.ideas2it.employeeinformation.project.service.impl;

import java.util.List;

import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.employee.service.EmployeeService;
import com.ideas2it.employeeinformation.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.project.dao.ProjectDao;
import com.ideas2it.employeeinformation.project.dao.impl.ProjectDaoImpl;
import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.project.service.ProjectService;

/**
 * ProjectServiceImpl is the Service class implementing the ProjectService
 * interface and this class implements all the methods of the interface.
 * <p>
 * This class processes all the business logic operations of the ProjectDetails
 * and this method calls the Dao classes to do the data access operations of the
 * Project Details.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class ProjectServiceImpl implements ProjectService{

    private static ProjectDao projectDao;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    /**
     * {@inheritDoc}
     */
    public Integer addProject(final Project project)
            throws ApplicationException {
        project.setIsActive(Boolean.TRUE);
        return projectDao.insertProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyProject(final Project project)
            throws ApplicationException {
        project.setIsActive(Boolean.TRUE);
        return projectDao.updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean assignEmployeeToProject(final Project project, 
            final List<Employee> employees) throws ApplicationException  {
        project.setIsActive(Boolean.TRUE);
        project.getEmployees().addAll(employees);
        return projectDao.updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeEmployeeFromProject(Project project,List<Employee> 
            employees) throws ApplicationException {
        project.setIsActive(Boolean.TRUE);
        project.getEmployees().removeAll(employees);
        return projectDao.updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteProject(Integer projectId) throws ApplicationException {
        Project project = projectDao.selectProjectById(projectId);
        project.setIsActive(Boolean.FALSE);
        return projectDao.updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public Project searchProjectById(int projectId)
            throws ApplicationException {

        return projectDao.selectProjectById(projectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Project> getProjects() throws ApplicationException {

        return projectDao.getAllProjects();
    }

   /**
     * {@inheritDoc}
     */
    public Employee getEmployeeById(final Integer employeeId)
            throws ApplicationException {
        EmployeeService employeeService = new EmployeeServiceImpl();
        return employeeService.getEmployeeById(employeeId);
    }

   /**
     * {@inheritDoc}
     */
    public List<Employee> getEmployees() throws ApplicationException {

        EmployeeService employeeService = new EmployeeServiceImpl();
        return employeeService.getEmployees();
    }
}
