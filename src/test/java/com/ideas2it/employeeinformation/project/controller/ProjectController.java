package com.ideas2it.employeeinformation.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.logger.Logger;
import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.project.service.ProjectService;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.ui.Model; 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ProjectController is the controller class for the Project, which allows
 * the application to execute the data manipulation operations of the
 * Project Details.
 * <p>
 * The Operations that can be done using this application are Adding a
 * Project Details, Modifying the Project Details, Removing the Project
 * Details, Searching for a Project details and Displaying the Project
 * Details.
 * </p>
 * The Project Controller class is mapped with Controller Annotation of Spring
 * Framework by which the Class is mapped to the Spring MVC.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
@Controller
public class ProjectController {

    private ProjectService projectService;

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * <p>
     * This method is called when the request value is project and this is the
     * Get method, which is used to redirect to the Project Main menu page.This
     * method returns the value as ModelAndView Class Object.
     * </p>
     *
     * @return ModelAndView Object which redirects to the Project MainMenu Page.
     */
    @RequestMapping(value = Constants.PROJECT_URI, method = RequestMethod.GET)
    public ModelAndView getProjectToDisplay() {

        return new ModelAndView(Constants.PROJECT_JSP);
    }

    /**
     * <p>
     * This method is called when the request value is createProject and this
     * is the Get method, which is used to redirect to the Create Project page.
     * This method returns the value as ModelAndView Class Object contains the
     * Model having the Project object with List as Address Object.
     * </p>
     * @param model Model Object for which the Project object is added. 
     * @return ModelAndView Object which redirects to the CreateProject Page.
     */
    @RequestMapping(value = Constants.CREATE_PROJECT, method = RequestMethod.GET)
    public ModelAndView getProjectDetailsFromUser(Model model) {

        model.addAttribute(Constants.PROJECT, new Project());
        return new ModelAndView(Constants.CREATE_PROJECT_JSP,Constants.COMMAND,
            model);
    }

    /**
     * <p>
     * This method is called when the request value is addProject and this is 
     * the Post method which contains the Project Object Details is added to the 
     * Database. It redirects to the Search Project page to display the Project
     * when object is successfully added or redirects to the Error page if any 
     * failure in adding the Project Object to Database.This method returns the 
     * value as ModelAndView Class Object.
     * </p>
     * @param project Project Object which is added to the Database. 
     * @return ModelAndView Object which redirects to the Create Project Page or
     *         Error Page.
     */
    @RequestMapping(value = Constants.ADD_PROJECT, method = RequestMethod.POST)
    private ModelAndView createProject(@ModelAttribute(Constants.PROJECT)
           Project project) { 

        try {
            Integer projectId = projectService.addProject(project);
            return new ModelAndView(Constants.SEARCH_PROJECT_JSP);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is called when the request value is modifyProject and this is 
     * the Get method which gets the Project Object Details which is needed to 
     * modify. It gets the Project Object from the Id given by the User and the 
     * respective Project Object is redirects to the Create Project page.This 
     * method returns the value as ModelAndView Class Object.
     * </p>
     * @param projectId Integer with ProjectId value from which the Project
     *                  Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Create Project Page
     *                      with the Project Object or to the Error Page.
     */
    @RequestMapping(value = Constants.MODIFY_PROJECT, method = RequestMethod.GET)
    public ModelAndView getProjectToModify(@RequestParam(Constants.ID_COLUMN)
            Integer projectId) {

        try {
            Project project = projectService.searchProjectById(projectId);
            return new ModelAndView(Constants.CREATE_PROJECT_JSP, Constants.
                PROJECT, project);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is called when the request value is updateProject and this is 
     * the Post method which contains the Project Object Details that needs to be 
     * updated in the Database. It redirects to the Search Project page to 
     * display the Updated Project Object when successfully Updated or redirects  
     * to the Error Page when any failure in Modifing the Project Object to 
     * Database.This method returns the value as ModelAndView Class Object.
     * </p>
     * @param project Project Object which is added to the Database. 
     * @return ModelAndView Object which redirects to the Search Project Page or
     *         to the Error Page.
     */
    @RequestMapping(value = Constants.UPDATE_PROJECT, method = RequestMethod.POST)
    private ModelAndView updateProject(@ModelAttribute(Constants.PROJECT)
            Project project) {
        try {
            projectService.modifyProject(project);
            return new ModelAndView(Constants.SEARCH_PROJECT_JSP);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is called when the request value is assignEmployees and this 
     * is the Get method which get the Project Object from the ProjectId for
     * which Employees needs to be assigned.It redirects to the Assign Project
     * page to from where Employees is assigned to the Project object. This method
     * also gets the List of Employees and set it to the Model attribute.
     * This method returns the value as ModelAndView Class Object.
     * </p>
     * @param projectId Integer with ProjectId value from which the Project 
     *                  Object is obtained from the Database.
     * @param model Model Object for which the Project object and the Project 
     *              Projects and the List of Employees. 
     * @return ModelAndView Object which redirects to the Search Project Page or
     *         to the Error Page.
     */
    @RequestMapping(value=Constants.ASSIGN_EMPLOYEES, method = RequestMethod.POST)
    public ModelAndView getEmployees(Model model, @RequestParam(Constants.
            ID_COLUMN) Integer projectId) {

        try {
            Project project = projectService.searchProjectById(projectId);
            List<Employee> employees = projectService.getEmployees();
            employees.removeAll(project.getEmployees());
            model.addAttribute(Constants.PROJECT,project);
            model.addAttribute(Constants.EMPLOYES, employees);
            model.addAttribute(Constants.CHECKED, project.getEmployees());
            return new ModelAndView(Constants.ASSIGN_EMPLOYEE_JSP);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is called when the request value is assignEmployeesToProject
     * and is a Post method which get the Project Object from the ProjectId for  
     * which Employees needs to be assigned. It gets the Project Object details
     * and list of Employees to be assigned and stores it in the Project Object.
     * It redirects to the Search Project page to display the Project Details
     * and the assigned Employee details when the Project is successfully updated 
     * or redirects to the Error Page if any Error occurs. This method returns
     * the value as ModelAndView Class Object.
     * </p>
     *
     * @param projectId Integer with ProjectId value from which the Project Object
     *                 is obtained from the Database.
     * @param ids String Array contains the list of Employees that needs to be
     *            assigned.
     * @return ModelAndView Object which redirects to the Search Project Page or
     *         to the Error Page.
     */
    @RequestMapping(value=Constants.ADD_EMPLOYEES_TO_PROJECT, method = RequestMethod.POST)
    public ModelAndView assignEmployees(Model model,@RequestParam(Constants.
            EMPLOYE) String[] ids, @RequestParam(Constants.ID_COLUMN) Integer 
            projectId) {

        try {
            Project project = projectService.searchProjectById(projectId);
            List<Employee> employees = new ArrayList<>();
            Employee employee = null;
            if (null != ids) {
                for (String id : ids) {
                    employee = projectService.getEmployeeById(Integer.parseInt(
                        id));
                    employees.add(employee);
                }
            }
            for(Employee addEmployee : employees) {
                if (!project.getEmployees().contains(addEmployee)) {
                    project.getEmployees().add(addEmployee);
                }
            }
            projectService.modifyProject(project);
            return new ModelAndView(Constants.SEARCH_PROJECT_JSP, Constants.
                PROJECT, project);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is called when the request value is removeEmployees and is a
     * Post method which get the Project Object from the projectId for which the 
     * list of Employees needs to be removed. It gets the Project Object details
     * and list of Employees to be removed and stores it in the Project Object.
     * It redirects to the Search Project page to display the Project Details and
     * the assigned Employee details when the Project is successfully updated or
     * redirects to the Error Page if any Error occurs. This method returns the 
     * value as ModelAndView Class Object.
     * </p>
     *
     * @param projectId Integer with projectId value from which the Project Object
     *                 is obtained from the Database.
     * @param ids String Array contains the list of Employees that needs to be
     *            removed.
     * @return ModelAndView Object which redirects to the Search Project Page or
     *         to the Error Page.
     */
    @RequestMapping(value=Constants.REMOVE_EMPLOYEES, method = RequestMethod.POST)
    public ModelAndView removeEmployeeFromProject(Model model, @RequestParam(
            Constants.ID_COLUMN) Integer projectId, @RequestParam(Constants.
            EMPLOYE) String[] ids) {

        try {
            Project project = projectService.searchProjectById(projectId);
            List<Employee> employees = new ArrayList<>();
            Employee employee = null;
            if (null != ids) {
                for (String id : ids) {
                    employee = projectService.getEmployeeById(Integer.parseInt(
                        id));
                    employees.add(employee);
                }
            }
            project.getEmployees().removeAll(employees);
            projectService.modifyProject(project);
            return new ModelAndView(Constants.SEARCH_PROJECT_JSP, Constants.
                PROJECT, project);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is called when the request value is deleteProject and this is 
     * the Post method which gets the Project Object Details which is needed to 
     * modify. It gets the Project Object from the projectId given by the User
     * and the respective Project Object Status is set to False which is Inactive
     * in the database and redirects to the Display Project page if successfully 
     * done or it redirects to the Error page. This method returns the value as 
     * ModelAndView Class Object.
     * </p>
     * @param projectId Integer with projectId value from which the Project
     *                  Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Display Project Page
     *                      with the Client Object or to the Error Page.
     */
    @RequestMapping(value=Constants.DELETE_PROJECT, method = RequestMethod.POST)
    public ModelAndView removeClient(@RequestParam(Constants.ID_COLUMN) Integer
            projectId) {

        try {
            projectService.deleteProject(projectId);
            List<Project> projects = projectService.getProjects();
            return new ModelAndView(Constants.DISPLAY_PROJECT_JSP, Constants.
                PROJECTS, projects);        
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is called when the request value is searchProject and this is 
     * the Post method which gets the Project Object Details which is needed to 
     * searched. It gets the Project Object from the Id given by the User and the 
     * respective Project Object is redirects to the Search Project page to 
     * display the Details of the respective Project Object or redirects to Error
     * page if any error occurs. This method returns the value as ModelAndView 
     * Class Object.
     * </p>
     * @param projectId Integer with projectId value from which the Project
     *                  Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Search Project Page
     *                      with the Client Object or to the Error Page.
     */
    @RequestMapping(value=Constants.SEARCH_PROJECT, method = RequestMethod.POST)
    public ModelAndView searchProject(@RequestParam(Constants.ID_COLUMN) Integer
            projectId) {

        try {
            Project project = projectService.searchProjectById(projectId);
            return new ModelAndView(Constants.SEARCH_PROJECT_JSP, Constants.
                PROJECT, project);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is called when the request value is displayProject and this is 
     * the Get method which gets all the Project Object Details and is displayed
     * to the user. It is redirected to the Display Project page or to the Error
     * page if any error occurs.This method returns the value as ModelAndView 
     * Class Object.
     * </p>
     *
     * @return ModelAndView Object which redirects to the DisplayProject Page
     *                      with the Project Object List or to the Error Page.
     */
    @RequestMapping(value=Constants.DISPLAY_PROJECT, method = RequestMethod.GET)
    public ModelAndView displayProject() {

        try {
            List<Project> projects = projectService.getProjects();
            return new ModelAndView(Constants.DISPLAY_PROJECT_JSP, Constants.
                PROJECTS, projects);
        } catch(ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }
}
