package com.ideas2it.employeeinformation.project.service.impl;

import java.util.ArrayList;
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
    private static EmployeeService employeeService;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * {@inheritDoc}
     */
    public boolean addProject(final Project project)
            throws ApplicationException {
        return projectDao.insertProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyProject(final Project project)
            throws ApplicationException {
        Project oldProject = projectDao.selectProjectById(project.
            getId());
        project.setEmployees(oldProject.getEmployees());
        return projectDao.updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean assignEmployeeToProject(Integer projectId, String[] ids)
            throws ApplicationException  {

        Project project = projectDao.selectProjectById(projectId);
        project.getEmployees().clear();                
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        if (null != ids) {
            for (String id : ids) {
                employee = getEmployeeById(Integer.parseInt(id));
                employees.add(employee);
            }
            project.setEmployees(employees);
        }
        return projectDao.updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeEmployeeFromProject(Integer projectId, String[] ids)
            throws ApplicationException  {

        Project project = projectDao.selectProjectById(projectId);
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        if (null != ids) {
            for (String id : ids) {
                employee = getEmployeeById(Integer.parseInt(
                    id));
                employees.add(employee);
            }
        }
        project.getEmployees().removeAll(employees);
        return projectDao.updateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean deleteProject(Integer projectId) throws ApplicationException {
        Project project = projectDao.selectProjectById(projectId);
        project.getEmployees().clear();
        return projectDao.inActivateProject(project);
    }

    /**
     * {@inheritDoc}
     */
    public boolean activateProject(final Integer projectId)
            throws ApplicationException {
        return projectDao.activateProjectById(projectId);
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
        return employeeService.getEmployeeById(employeeId);
    }

   /**
     * {@inheritDoc}
     */
    public List<Employee> getEmployees() throws ApplicationException {
        return employeeService.getEmployees();
    }
}
