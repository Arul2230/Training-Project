package com.ideas2it.employeeinformation.client.service;

import java.util.List;

import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * ClientService is the Service interface which is having the several data
 * manipulation methods and this class does the business logic operations
 * on the Client Details.
 * <p>
 * It has the Implementation class which is performing the business logic
 * operations on the Client Details.
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
     */
    public Integer addClient(final Client client)
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
     */
    public boolean modifyClient(final Client client)
            throws ApplicationException;

    /**
     * <p>
     * Method to assign the Projects to the Existing Client.This method gets
     * the Projects and is assigned to the existing Client by the Client Entity.
     * </p>
     *
     * @param  client  client object contains the client Details
     * @param  projects List contains the list of projects.
     * @return boolean  returns true when the Project assigned to Client and
     *                  false if Project is not assigned to Client.
     */
    public boolean assignProjectToClient(final Client client,List<Project> 
            projects) throws ApplicationException;

    /**
     * <p>
     * Method to Remove the Projects from the existing Client.This method gets
     * the project Ids that needs to be removed from the Client and the
     * Project ID is used that specific Client and removes those projects.
     * </p>
     *
     * @param  client  client object contains the client Details
     * @param  projects List contains the list of projects.
     * @return boolean  returns true when the Project is removed from Client
     *                  and false if Project is not removed from Client.
     */
    public boolean getProjectToRemoveFromClient(final Client client, 
            List<Project> projects) throws ApplicationException;

    /**
     * <p>
     * Method to remove the Existing Client Details.The Client object
     * contains ClientId is searched using searchClientbyId method
     * and the details is removed.
     * </p>
     *
     * @param  client  an Client object which contains the Client
     *                   Details that needs to be removed.
     * @return boolean  returns true when the Client object is deleted and
     *                  false if deletion operation is failed.
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
     *                     id that needs to be searched.
     * @return returns Client object when id is found and null
     *         when not found.
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
     */
    public List<Project> getProjects() throws ApplicationException;
}
