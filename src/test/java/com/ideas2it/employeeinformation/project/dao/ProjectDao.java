package com.ideas2it.employeeinformation.project.dao;

import java.util.List;

import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.project.model.Project;

/**
 * ProjectDao is the DAO interface program contains various data access
 * methods.
 * <p>
 * It is having the ProjectDaoImpl implementation class,which is
 * performing Add,Modify,Remove,Search and Display the details in the
 * Database.
 * </p>
 * ProjectDetails and EmployeeDetails is gathered and store the values of
 * the Project details and Employee Details in a separate list.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public interface ProjectDao {

    /**
     * <p>
     * This Method is used when a user wants to Add a Project Object in the
     * Database.This method gets the Project object which contains the Project
     * Details that needs to be added in the database.
     * </p>
     *
     * @param project Project object type contains the project details in it.
     * @return projectId returns the Id of the added Project Entity.
     */
    public Integer insertProject(final Project project)
            throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing Project Object in the Database.The
     * new Project Details contains the Project Details which is modified in
     * the Old Project Details.
     * </p>
     *
     * @param  project  Project object contains the Project details that
     *                   needs to be updated.
     * @return boolean  returns true when the Project object is updated and
     *                  false if update operation is failed.
     */
    public boolean updateProject(final Project project)
            throws ApplicationException;

    /**
     * <p>
     * Method to search the project Id in the database.This method is using
     * the projectId to search the project and is searched in the database.
     * </p>
     *
     * @param   projectId  a int datatype which contains the project
     *                      id that needs to be searched.
     * @return  project    returns project object when id is found
     *                      and null when not found.
     */
    public Project selectProjectById(final int projectId)
            throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Project Details that were
     * stored in the daabase. It gives the Project details as an List.
     * </p>
     *
     * @return  List with Project datatype containing Project details.
     */
    public List<Project> getAllProjects() throws ApplicationException ;
}
