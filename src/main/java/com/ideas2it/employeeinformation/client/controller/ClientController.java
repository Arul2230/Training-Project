package com.ideas2it.employeeinformation.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import com.ideas2it.employeeinformation.address.model.Address;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.client.service.ClientService;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.logger.Logger;
import com.ideas2it.employeeinformation.project.model.Project;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.ui.Model; 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClientController is the class which is used for executing the data
 * manipulation operations on the Client Details.
 * <p>
 * The Operations that can be done using this application are Adding a
 * Client Details, Modifying the Client Details, Removing the Client
 * Details, Searching for a Client details and Displaying the Client
 * Details.
 * </p>
 * The Client Controller class is mapped with Controller Annotation of Spring
 * Framework by which the Class is mapped to the Spring MVC.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
@Controller
public class ClientController extends HttpServlet {

    private ClientService clientService;

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * <p>
     * This method is called when the request value is createClient and this is 
     * the Get method, which is used to redirect to the Create Client page.This
     * method returns the value as ModelAndView Class Object contains the Model
     * having the Client object with List as Address Object.
     * </p>
     * @param model Model Object for which the Client object is added. 
     * @return ModelAndView Object which redirects to the Create Client Page.
     */
    @RequestMapping(value = Constants.CREATE_CLIENT, method = RequestMethod.GET)
    public ModelAndView getClientDetailsFromUser(Model model) {

        Address presentAddress = new Address();
        Address permanentAddress = new Address();
        presentAddress.setAddressType(Constants.PRESENT);
        permanentAddress.setAddressType(Constants.PERMANENT);
        Client client = new Client();
        client.getAddresses().add(presentAddress);
        client.getAddresses().add(permanentAddress);
        model.addAttribute(Constants.CLIENT, client);
        return new ModelAndView(Constants.CREATE_CLIENT_JSP, Constants.COMMAND,
            model);
    }

    /**
     * <p>
     * This method is called when the request value is addClient and this is 
     * the Post method which contains the Client Object Details is added to the 
     * Database. It redirects to the Search Client page to display the Client
     * when object is successfully added or redirects to the Error page if any 
     * failure in adding the Client Object to Database.This method returns the 
     * value as ModelAndView Class Object.
     * </p>
     * @param client Client Object which is added to the Database. 
     * @return ModelAndView Object which redirects to the Create Client Page or
     *         Error Page.
     */
    @RequestMapping(value=Constants.ADD_CLIENT, method = RequestMethod.POST)
    private ModelAndView createClient(@ModelAttribute(Constants.CLIENT) Client 
            client) {

        try {
            clientService.addClient(client);
            return new ModelAndView(Constants.SEARCH_CLIENT_JSP);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_ADD_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is modifyClient and this is 
     * the Get method which gets the Client Object Details which is needed to 
     * modify. It gets the Client Object from the Id given by the User and the 
     * respective Client Object is redirects to the Create Client page.This 
     * method returns the value as ModelAndView Class Object.
     * </p>
     * @param clientId Integer with ClientId value from which the Client Object
     *                 is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Create Client Page
     *                      with the Client Object or to the Error Page.
     */
    @RequestMapping(value = Constants.MODIFY_CLIENT, method = RequestMethod.POST)
    public ModelAndView getClientToModify(@RequestParam(Constants.CLIENT_ID) 
            Integer clientId) {
        try {
            Client client = clientService.getClientById(clientId);
            return new ModelAndView(Constants.CREATE_CLIENT_JSP, Constants.
                CLIENT, client);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_DETAILS_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is updateClient and this is 
     * the Post method which contains the Client Object Details that needs to be 
     * updated in the Database. It redirects to the Search Client page to 
     * display the Updated Client Object when successfully Updated or redirects  
     * to the Error Page when any failure in Modifing the Client Object to 
     * Database.This method returns the value as ModelAndView Class Object.
     * </p>
     * @param client Client Object which is added to the Database. 
     * @return ModelAndView Object which redirects to the Search Client Page or
     *         to the Error Page.
     */
    @RequestMapping(value = Constants.UPDATE_CLIENT, method = RequestMethod.POST)
    private ModelAndView updateClient(@ModelAttribute(Constants.CLIENT) Client 
            client) {

        try {
            clientService.modifyClient(client);
            return new ModelAndView(Constants.SEARCH_CLIENT_JSP);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_UPDATE_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is assignProjects and this 
     * is the Get method which get the Client Object from the ClientId for which 
     * Projects needs to be assigned.It redirects to the Assign Project page to 
     * from where Employees is assigned to the Client object. This method also
     * gets the List of Projects and set it to the Model attribute.
     * This method returns the value as ModelAndView Class Object.
     * </p>
     * @param clientId Integer with ClientId value from which the Client Object
     *                 is obtained from the Database.
     * @param model Model Object for which the Client object and the Client 
     *              Projects and the List of Projects. 
     * @return ModelAndView Object which redirects to the Search Client Page or
     *         to the Error Page.
     */
    @RequestMapping(value=Constants.ASSIGN_PROJECTS, method = RequestMethod.POST)
    public ModelAndView getProjects(Model model, @RequestParam(Constants.
            CLIENT_ID) Integer clientId) {

        try {
            Client client = clientService.getClientById(clientId);
            List<Project> projects = clientService.getProjects();
            projects.removeAll(client.getProjects());
            model.addAttribute(Constants.CLIENT,client);
            model.addAttribute(Constants.PROJECTS, projects);
            model.addAttribute(Constants.CHECKED, client.getProjects());
            return new ModelAndView(Constants.ASSIGN_PROJECT_JSP);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.GET_PROJECTS_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is assignProjectsToClient
     * and is a Post method which get the Client Object from the ClientId for  
     * which Projects needs to be assigned. It gets the Client Object details
     * and list of projects to be assigned and stores it in the Client Object.
     * It redirects to the Search Project page to display the Client Details and
     * the assigned Project details when the Client is successfully updated or
     * redirects to the Error Page if any Error occurs. This method returns the 
     * value as ModelAndView Class Object.
     * </p>
     *
     * @param clientId Integer with ClientId value from which the Client Object
     *                 is obtained from the Database.
     * @param ids String Array contains the list of Projects that needs to be
     *            assigned.
     * @return ModelAndView Object which redirects to the Search Client Page or
     *         to the Error Page.
     */
    @RequestMapping(value=Constants.ADD_PROJECTS_TO_CLIENT, method = 
        RequestMethod.POST)
    public ModelAndView assignProjects(@RequestParam(value=Constants.PROJECT,
            required=false) String[] ids, @RequestParam(Constants.CLIENT_ID)
            Integer clientId) {

        try {
            clientService.assignProjectsToClient(clientId, ids);
            Client client = clientService.getClientById(clientId);
            return new ModelAndView(Constants.SEARCH_CLIENT_JSP, Constants.
                CLIENT, client);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_UPDATE_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is removeProjects and is a
     * Post method which get the Client Object from the ClientId for which the 
     * list of Projects needs to be removed. It gets the Client Object details
     * and list of projects to be removed and stores it in the Client Object.
     * It redirects to the Search Project page to display the Client Details and
     * the assigned Project details when the Client is successfully updated or
     * redirects to the Error Page if any Error occurs. This method returns the 
     * value as ModelAndView Class Object.
     * </p>
     *
     * @param clientId Integer with ClientId value from which the Client Object
     *                 is obtained from the Database.
     * @param ids String Array contains the list of Projects that needs to be
     *            removed.
     * @return ModelAndView Object which redirects to the Search Client Page or
     *         to the Error Page.
     */
    @RequestMapping(value=Constants.REMOVE_PROJECTS, method = RequestMethod.POST)
    public ModelAndView removeProjectFromClient(@RequestParam(Constants.
            CLIENT_ID) Integer clientId, @RequestParam(value=Constants.PROJECT,
            required=false) String[] ids) {

        try {
            clientService.removeProjectsFromClient(clientId, ids);
            Client client = clientService.getClientById(clientId);
            return new ModelAndView(Constants.SEARCH_CLIENT_JSP, Constants.
                CLIENT, client);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_UPDATE_FAIL);
        } 
    }

    /**
     * <p>
     * This method is called when the request value is deleteClient and this is 
     * the Get method which gets the Client Object Details which is needed to 
     * modify. It gets the Client Object from the Id given by the User and the 
     * respective Client Object Status is set to False which is Inactive in the 
     * database and redirects to the Display Client page if successfully done or 
     * it redirects to the Error page. This method returns the value as 
     * ModelAndView Class Object.
     * </p>
     * @param clientId Integer with ClientId value from which the Client Object
     *                 is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Display Client Page
     *                      with the Client Object or to the Error Page.
     */
    @RequestMapping(value=Constants.DELETE_CLIENT, method = RequestMethod.POST)
    public ModelAndView removeClient(@RequestParam(Constants.CLIENT_ID)
            Integer clientId) {

        try {
            clientService.removeClient(clientId);
            List<Client> clients = clientService.getClients();
            return new ModelAndView(Constants.DISPLAY_CLIENT_JSP, Constants.
                CLIENTS, clients);        
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_DELETE_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is searchClient and this is 
     * the Post method which gets the Client Object Details which is needed to 
     * searched. It gets the Client Object from the Id given by the User and the 
     * respective Client Object is redirects to the Search Client page to 
     * display the Details of the respective Client Object or redirects to Error
     * page if any error occurs. This method returns the value as ModelAndView 
     * Class Object.
     * </p>
     * @param clientId Integer with ClientId value from which the Client Object
     *                 is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Search Client Page
     *                      with the Client Object or to the Error Page.
     */
    @RequestMapping(value=Constants.SEARCH_CLIENT, method = RequestMethod.POST)
    public ModelAndView searchClient(@RequestParam(Constants.ID_COLUMN) Integer 
            clientId) {

        try {
            Client client = clientService.getClientById(clientId);
            return new ModelAndView(Constants.SEARCH_CLIENT_JSP, Constants.
                CLIENT, client);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_DETAILS_FAIL);
        } 
    }

    /**
     * <p>
     * This method is called when the request value is displayClient and this is 
     * the Get method which gets all the Client Object Details and is displayed
     * to the user. It is redirected to the Display Client page or to the Error
     * page if any error occurs.This method returns the value as ModelAndView 
     * Class Object.
     * </p>
     *
     * @return ModelAndView Object which redirects to the DisplayClient Page
     *                      with the ClientObject List or to the Error Page.
     */
    @RequestMapping(value=Constants.DISPLAY_CLIENT, method = RequestMethod.GET)
    public ModelAndView displayAllClient() {

        try {
            List<Client> clients = clientService.getClients();
            return new ModelAndView(Constants.DISPLAY_CLIENT_JSP, Constants.
                CLIENTS, clients);
        } catch(ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_DISPLAY_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is activateClient and this 
     * is the Get method which gets the Client Object Details which needs to 
     * activate. It gets the Client Object from the Id given by the User and
     * the respective Client Object is Activated.It redirects to the Search
     * Client page or redirect to Error page if any error occurs.This method 
     * returns the value as ModelAndView Class Object.
     * </p>
     * @param clientId Integer with ClientId value from which the Client
     *                   Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the DisplayClient Page
     *                      with the Client Object or to the Error Page.
     */
    @RequestMapping(value=Constants.ACTIVATE_CLIENT, method = RequestMethod.POST)
    private ModelAndView activateClient(@RequestParam(Constants.ID_COLUMN)
            Integer clientId) {
        try {
            clientService.activateClient(clientId);
            List<Client> clients = clientService.getClients();
            return new ModelAndView(Constants.DISPLAY_CLIENT_JSP, Constants.
                CLIENTS, clients);
        } catch(ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.CLIENT_ACTIVATE_FAIL);
        }
    }
}
