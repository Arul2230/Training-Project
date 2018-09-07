package com.ideas2it.employeeinformation.client.dao;

import java.util.List;

import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * ClientDao is the DAO interface program which is having the methods
 * that is processing the data access operations of the Client Details.
 * <p>
 * It is having the implementation clasess, which performs the Add,Modify,
 * Remove,Search and Display the Client details.
 * </p>
 * This interface has a method to gather details of all the Clients that are
 * stored in the Database.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public interface ClientDao {

    /**
     * <p>
     * This Method is used when a user wants to Add a Client Object in the
     * Database.This method gets the Client object which contains the Client
     * Details that needs to be added in the database.
     * </p>
     *
     * @param client Client object type contains the client details in it.
     * @return boolean returns true when Client object added successfully and
     *                  returns false when Object not added.
     * @throws ApplicationException when failure occurs in adding a Client.
     */
    public boolean insertClient(final Client client) 
            throws ApplicationException;

    /**
     * <p>
     * Method to modify the Existing Client Object in the Database.The
     * new Client Details contains the Client Details which is modified in
     * the Old Client Details.
     * </p>
     *
     * @param  client  Client object contains the Client details that
     *                   needs to be modified.
     * @return boolean  returns true when the Client object is modified and
     *                  false if modification operation is failed.
     * @throws ApplicationException when failure occurs in modifying a Client.
     */
    public boolean updateClient(final Client client)
            throws ApplicationException;

    /**
     * <p>
     * Method to inactivate the Existing Client Object in the Database. The
     * Client Object is fetched from ClientId and the Client Object is
     * inactivated the Old Client Details.
     * </p>
     *
     * @param  client   Client object contains the Client Details that
     *                  needs to be Inactivated.
     * @return boolean  returns true when the Client object is modified and
     *                  false if modification operation is failed.
     * @throws ApplicationException when failure occurs while deactivating a
     *                  Client Details.
     */
    public boolean inActivateClient(final Client client)
            throws ApplicationException;

    /**
     * <p>
     * Method to activate the Inactive Client Details.The Client Object is 
     * fetched from the given Client Id and the Client Details is activated.
     * </p>
     *
     * @param  clientId  an integer object which contains the Client
     *                   Id that needs to be activated.
     * @return boolean  returns true when the Client object is activated and
     *                  false if activated operation is failed.
     * @throws ApplicationException when failure occurs while Activating a
     *                  Client Details.
     */
    public boolean activateClientById(final Integer clientId)
            throws ApplicationException;

    /**
     * <p>
     * Method to search the Client Id in the database.This method is using
     * the ClientId to search the Client and is searched in the database.
     * </p>
     *
     * @param   clientId  a int datatype which contains the Client
     *                      id that needs to be searched.
     * @return  client    returns Client object when id is found
     *                      and null when not found.
     * @throws ApplicationException when failure occurs while serching for an
     *                  Client Details.
     */
    public Client selectClientById(final Integer clientId)
            throws ApplicationException;

    /**
     * <p>
     * This Method is used to get all the Client Details that were stored
     * in the Database. It gives the Client details as an List.
     * </p>
     * @return  clients  List with Client datatype containing
     *                     Client details.
     * @throws ApplicationException when failure occurs while getting all the
     *                  Client Details.
     */
    public List<Client> getAllClients()
            throws ApplicationException;
}
