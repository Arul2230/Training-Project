package com.ideas2it.employeeinformation.client.service;

import java.util.List;

import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * ClientService is the Service interface which is having the several data
 * manipulation methods and this class does the operations on the Client Details.
 * <p>
 * Managing Project functions in the Client Entity is done by the this class.
 * It also does the data manipulation operations in the Client.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public interface ClientService {

    /**
     * <p>
     * This Method is used if a user wants to Add Client Details.
     * It gets the Client object which contains all the information about
     * the Client that needs to be added.
     * </p>
     *
     * @param  client  Client object type contains the Client details
     *                 that needs to be added.
     * @return clientId returns the added Client object's Id.
     * @throws ApplicationException when failure occurs in adding a Client.
     */
    public boolean addClient(final Client client)
            throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing Client Details with new details.The
     * Client Id is searched by using searchClientById method and
     * the details are modified.
     * </p>
     *
     * @param  client  Client object contains the New Client details that
     *                   that is modified in old ClientId.
     * @return client  returns true when the Client object is modified and
     *                  false if modification operation is failed.
     * @throws ApplicationException when failure occurs in modifying a Client.
     */
    public boolean modifyClient(final Client client)
            throws ApplicationException;

    /**
     * <p>
     * Method to assign the Projects to the Existing Client.This method gets
     * the Projects and is assigned to the existing Client by the Client Entity.
     * </p>
     *
     * @param  clientId Integer value from which client object is obtained.
     * @param  ids      String array contains the projects that needs to be
     *                  assigned to an Client.
     * @return boolean  returns true when the Project assigned to Client and
     *                  false if Project is not assigned to Client.
     * @throws ApplicationException when failure occurs in assiging Projects
     *                  to an Client Object.
     */
    public boolean assignProjectsToClient(final Integer clientId, String[] ids)
            throws ApplicationException;

    /**
     * <p>
     * Method to Remove the Projects from the existing Client.This method gets
     * the project Ids that needs to be removed from the Client and the
     * Project ID is used that specific Client and removes those projects.
     * </p>
     *
     * @param  clientId Integer value from which client object is obtained.
     * @param  ids      String array contains the projects that needs to be
     *                  assigned to an Client.
     * @return boolean  returns true when the Project is removed from Client
     *                  and false if Project is not removed from Client.
     * @throws ApplicationException when failure occurs in assigning Projects.
     */
    public boolean removeProjectsFromClient(final Integer clientId, String[] 
            ids) throws ApplicationException;

    /**
     * <p>
     * Method to remove the Existing Client Details.The Client object
     * contains ClientId is searched using searchClientbyId method
     * and the details is removed.
     * </p>
     *
     * @param  clientId Integer value from which client object is obtained.
     * @return boolean  returns true when the Client object is deleted and
     *                  false if deletion operation is failed.
     * @throws ApplicationException when failure occurs in inactivate the Client
     *                  Object
     */
    public boolean removeClient(final Integer client)
            throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing Client Id.This method is using the
     * ClientId to search and returns the searched Client Object.
     * </p>
     *
     * @param  clientId  a int datatype which contains the Client
     *                   id that needs to be searched.
     * @return returns Client object when id is found and null
     *                 when not found.
     * @throws ApplicationException when failure occurs in searching an Client
     *                 Object.
     */
    public Client getClientById(final Integer clientId)
        throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Client Details that were
     * stored. It gives the Client details as an List.
     * </p>
     *
     * @return List with Client datatype containing Client details.
     * @throws ApplicationException when failure occurs in getting all the 
     *                   Client Object Details.
     */
    public List<Client> getClients() throws ApplicationException;

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
     * @throws ApplicationException when failure occurs in searching an Project
     *                 Object.
     */
    public Project getProjectById(final Integer projectId)
            throws ApplicationException;
    /**
     * <p>
     * This Method is used to get all the Project Details that were
     * stored. It gives the Project details as an List.
     * </p>
     *
     * @return  List with Project datatype containing Project details.
     * @throws ApplicationException when failure occurs in getting all the 
     *                   Project Object Details.
     */
    public List<Project> getProjects() throws ApplicationException;

    /**
     * <p>
     * Method to activate the Inactive Client Details.The Client id is given to
     * ActivateClient method and the Client Details is activated.
     * </p>
     *
     * @param  clientId  an integer object which contains the Client
     *                   Id that needs to be activated.
     * @return boolean  returns true when the Client object is deleted and
     *                  false if deletion operation is failed.
     * @throws ApplicationException when failure occurs in activating the Client
     *                  Object details.
     */
    public boolean activateClient(final Integer clientId)
            throws ApplicationException;
}
