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
     * @return boolean  returns true when the Project object is added and
     *                  false if add operation is failed.
     */
    public boolean insertProject(final Project project)
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
     * Method to inactivate the Existing Project Object in the Database. The
     * Project Object is fetched from ProjectId and the Project Object is
     * inactivated the Old Project Details.
     * </p>
     *
     * @param  project   Project object contains the Project Details that
     *                  needs to be Inactivated.
     * @return boolean  returns true when the Project object is inactivated and
     *                  false if deactivation operation is failed.
     * @throws ApplicationException when failure occurs while deactivating a
     *                  Project Details.
     */
    public boolean inActivateProject(final Project project)
            throws ApplicationException;

    /**
     * <p>
     * Method to activate the Inactive Project Details.The Project Object is 
     * fetched from the given Project Id and the Project Details is activated.
     * </p>
     *
     * @param  projectId  an integer object which contains the Project
     *                   Id that needs to be activated.
     * @return boolean  returns true when the Project object is activated and
     *                  false if activated operation is failed.
     * @throws ApplicationException when failure occurs while Activating a
     *                  Project Details.
     */
    public boolean activateProjectById(final Integer projectId)
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
