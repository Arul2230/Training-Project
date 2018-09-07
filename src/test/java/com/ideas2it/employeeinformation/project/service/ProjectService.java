package com.ideas2it.employeeinformation.project.service;

import java.util.List;

import com.ideas2it.employeeinformation.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.project.model.Project;

/**
 * ProjectService is the Service interface is having several data manipulation
 * operations and the business operations will be done in this service
 * layer.
 * <p>
 * It has the Implementation class which is performing the business logic
 * operations on the Project Details.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public interface ProjectService {

    /**
     * <p>
     * This Method is called if a user wants to Add a Project Details.
     * This method gets the Project object which contains the Project Details
     * and it is added.
     * </p>
     *
     * @param  project  Project object type contains the Project details in it.
     * @return projectId returns the added Project object's Id.
     */
    public Integer addProject(Project project) throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing Project Details. The Project entity
     * contains the Project Id and the Project Details that are needed to be
     * modified on that specific Id which will be modified.
     * </p>
     *
     * @param  project  Project object contains the Project details that
     *                  needs to be modified.
     * @return boolean  returns true when the Project object is modified and
     *                  false if modification operation is failed.
     */
    public boolean modifyProject(Project project) throws ApplicationException;

    /**
     * <p>
     * Method to assign the Employees to the Existing Project.This method gets
     * the Manager and Employee and will be assigned to the existing Project
     * by the given ProjectId.
     * </p>
     *
     * @param  project  Project object contains the Project Manager, Employees
     *                  and the projectId.
     * @param  employees List contains the list of Employees.
     * @return boolean  returns true when the Employee assigned to Project and
     *                  false if Employee is not assigned to Project.
     */
    public boolean assignEmployeeToProject(Project project,List<Employee> 
            employees) throws ApplicationException;

    /**
     * <p>
     * Method to Remove the Employees from the existing Project.This method gets
     * the manager Ids and the Employee Ids that needs to be removed from the
     * Project and the Project ID is used that specific Project and removes
     * those Employees.
     * </p>
     *
     * @param  project  Project object contains the Project Id and employees
     *                  that are needed to be removed.
     * @param  employees List contains the list of Employees.
     * @return boolean  returns true when the Employee is removed from Project
     *                  and false if Employee is not removed from Project.
     */
    public boolean removeEmployeeFromProject(Project project,List<Employee> 
            employees) throws ApplicationException;

    /**
     * <p>
     * Method to remove the Existing Project in the Database.The ProjectId
     * is fetched from the Project Entity and the Project details will is
     * removed.
     * </p>
     *
     * @param  project  Project entity contains the ProjectId that iss removed.
     * @return boolean  returns true when the Project object is deleted and
     *                  false if deletion operation is failed.
     */
    public boolean deleteProject(Integer projectId)
            throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing Project.This method uses the getter
     * and fetch the ProjectId and the will be searched.
     * </p>
     * Ex: if project id is found it return the Project entity and null if it
     * is not found.
     *
     * @param   projectId  a int datatype which contains the Project
     *                     id that needs to be searched.
     * @return  returns Project object when id is found and null when not found.
     */

    public Project searchProjectById(int projectId) throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Project Details that were
     * stored. It gives the Project details as an List.
     * </p>
     *
     * @return  List with Project datatype containing Project details.
     */
    public List<Project> getProjects() throws ApplicationException;

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
     * @return  List with Employee datatype containing employee details.
     */
    public List<Employee> getEmployees() throws ApplicationException;
}
