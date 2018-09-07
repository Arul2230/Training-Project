package com.ideas2it.employeeinformation.client.service.impl;

import java.util.List;

import com.ideas2it.employeeinformation.client.dao.ClientDao;
import com.ideas2it.employeeinformation.client.dao.impl.ClientDaoImpl;
import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.client.service.ClientService;
import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.project.service.ProjectService;
import com.ideas2it.employeeinformation.project.service.impl.ProjectServiceImpl;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * ClientServiceImpl is the Service class implementing the ClientService
 * interface and this implements all the methods of the interface program.
 * <p>
 * It processes all the business logic operations and calls the Dao class to
 * do the data accessing operations.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class ClientServiceImpl implements ClientService {

    private static ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * {@inheritDoc}
     */
    public Integer addClient(final Client client)
            throws ApplicationException {
        client.setIsActive(Boolean.TRUE);
        return clientDao.insertClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyClient(final Client client)
            throws ApplicationException {
        client.setIsActive(Boolean.TRUE);
        return clientDao.updateClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public boolean assignProjectToClient(final Client client,List<Project> 
            projects) throws ApplicationException {
        client.setIsActive(Boolean.TRUE);
        client.getProjects().addAll(projects);
        return clientDao.updateClient(client);
    }
    /**
     * {@inheritDoc}
     */
    public boolean getProjectToRemoveFromClient(final Client client, 
            List<Project> projects) throws ApplicationException {
        client.setIsActive(Boolean.TRUE);
        client.getProjects().addAll(projects);
        return clientDao.updateClient(client);
    }
    /**
     * {@inheritDoc}
     */
    public boolean removeClient(final Integer clientId)
            throws ApplicationException {
        Client client = clientDao.selectClientById(clientId);
        client.setIsActive(Boolean.FALSE);
        return clientDao.updateClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public Client getClientById(final Integer clientId)
            throws ApplicationException {
        return clientDao.selectClientById(clientId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Client> getClients()
            throws ApplicationException {
        return clientDao.getAllClients();
    }

    /**
     * {@inheritDoc}
     */
    public Project getProjectById(Integer projectId)
            throws ApplicationException {
        ProjectService projectService = new ProjectServiceImpl();
        return projectService.searchProjectById(projectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Project> getProjects() throws ApplicationException {
        ProjectService projectService = new ProjectServiceImpl();
        return projectService.getProjects();
    }
}
