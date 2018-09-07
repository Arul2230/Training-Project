package com.ideas2it.employeeinformation.client.service.impl;

import java.util.ArrayList;
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
 * It processes the Assigning Projects to an Client and Removing Projects from
 * the Client is Done.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class ClientServiceImpl implements ClientService {

    private static ClientDao clientDao;
    private static ProjectService projectService;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * {@inheritDoc}
     */
    public boolean addClient(final Client client)
            throws ApplicationException {
        client.setIsActive(Boolean.TRUE);
        return clientDao.insertClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public boolean modifyClient(final Client client)
            throws ApplicationException {
        Client oldClient = clientDao.selectClientById(client.getId());
        client.setProjects(oldClient.getProjects());
        return clientDao.updateClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public boolean assignProjectsToClient(final Integer clientId, String[] ids) 
            throws ApplicationException {

        Client client = clientDao.selectClientById(clientId);
        client.getProjects().clear();
        List<Project> projects = new ArrayList<>();
        Project project = null;
        if (null != ids) {
            for (String id : ids) {
                project = getProjectById(Integer.parseInt(id));
                projects.add(project);
            }
            client.setProjects(projects);
        }
        return clientDao.updateClient(client);
    }
    /**
     * {@inheritDoc}
     */
    public boolean removeProjectsFromClient(final Integer clientId, String[] 
            ids) throws ApplicationException {

        Client client = clientDao.selectClientById(clientId);
        List<Project> projects = new ArrayList<>();
        Project project = null;
        if (null != ids) {
            for (String id : ids) {
                project = getProjectById(Integer.parseInt(id));
                projects.add(project);
            }
        }
        client.getProjects().removeAll(projects);
        return clientDao.updateClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeClient(final Integer clientId)
            throws ApplicationException {
        Client client = clientDao.selectClientById(clientId);
        client.getProjects().clear();
        return clientDao.inActivateClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public boolean activateClient(final Integer clientId)
            throws ApplicationException {
        return clientDao.activateClientById(clientId);
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
        return projectService.searchProjectById(projectId);
    }

    /**
     * {@inheritDoc}
     */
    public List<Project> getProjects() throws ApplicationException {
        return projectService.getProjects();
    }
}
