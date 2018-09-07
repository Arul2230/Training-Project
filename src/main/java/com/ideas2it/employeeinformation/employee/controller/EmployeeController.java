package com.ideas2it.employeeinformation.employee.controller;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employeeinformation.address.model.Address;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.employee.service.EmployeeService;
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
 * EmployeeController is the controller class for the Employee, which allows
 * the application to execute the data manipulation operations of the
 * Employee Details.
 * <p>
 * The Operations that can be done using this application are Adding a
 * Employee Details, Modifying the Employee Details, Removing the Employee
 * Details, Searching for a Employee details and Displaying the Employee
 * Details.
 * </p>
 * The Employee Controller class is mapped with Controller Annotation of Spring
 * Framework by which the Class is mapped to the Spring MVC.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
@Controller
public class EmployeeController {

    private static EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * <p>
     * This method is called when the request value is employee and this is the
     * Get method, which is used to redirect to the Employee Main menu page.This
     * method returns the value as ModelAndView Class Object.
     * </p>
     *
     * @return ModelAndView Object which redirects to the Employee MainMenu Page.
     */
    @RequestMapping(value = Constants.EMPLOYEE_URI, method = RequestMethod.GET)
    public ModelAndView getEmployeeToDisplay() {
        return new ModelAndView(Constants.EMPLOYEE_JSP);
    }

    /**
     * <p>
     * This method is called when the request value is createEmployee and this
     * is the Get method, which is used to redirect to the Create Employee page.
     * This method returns the value as ModelAndView Class Object contains the
     * Model having the Employee object with List as Address Object.
     * </p>
     * @param model Model Object for which the Employee object is added. 
     * @return ModelAndView Object which redirects to the Create Employee Page.
     */
    @RequestMapping(value = Constants.CREATE_EMPLOYEE, method = RequestMethod.GET)
    public ModelAndView getEmployeeDetailsFromUser(Model model) {

        Address presentAddress = new Address();
        Address permanentAddress = new Address();
        presentAddress.setAddressType(Constants.PRESENT);
        permanentAddress.setAddressType(Constants.PERMANENT);
        Employee employee = new Employee();
        employee.getAddresses().add(presentAddress);
        employee.getAddresses().add(permanentAddress);
        model.addAttribute(Constants.EMPLOYE, employee);
        return new ModelAndView(Constants.CREATE_EMPLOYEE_JSP, Constants.COMMAND
            , model);
    }

    /**
     * <p>
     * This method is called when the request value is addEmployee and this is 
     * the Post method which contains the EmployeeObject Details is added to the 
     * Database. It redirects to the SearchEmployee page to display the Employee
     * when object is successfully added or redirects to the Error page if any 
     * failure in adding the Employee Object to Database.This method returns the 
     * value as ModelAndView Class Object.
     * </p>
     * @param employee Employee Object which is added to the Database. 
     * @return ModelAndView Object which redirects to the Create Employee Page
     *         or Error Page.
     */
    @RequestMapping(value = Constants.ADD_EMPLOYEE, method = {RequestMethod.POST
        ,RequestMethod.GET})
    private ModelAndView createEmployee(@ModelAttribute(Constants.EMPLOYE) 
            Employee employee) {

        try {
            employeeService.addEmployee(employee);
            return new ModelAndView(Constants.SEARCH_EMPLOYEE_JSP);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.EMPLOYEE_ADD_FAILED);
        }
    }

    /**
     * <p>
     * This method is called when the request value is modifyEmployee and this 
     * is the Get method which gets the Employee Object Details which is needed 
     * to modify. It gets the Employee Object from the Id given by the User and
     * the respective Employee Object is redirects to the Create Employee page.
     * This method returns the value as ModelAndView Class Object.
     * </p>
     * @param employeeId Integer with EmployeeId value from which the Employee
     *                   Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Create Employee Page
     *                      with the EmployeeObject or to the Error Page.
     */
    @RequestMapping(value = Constants.MODIFY_EMPLOYEE, method = {RequestMethod.POST
        ,RequestMethod.GET})
    public ModelAndView getEmployeeToModify(@RequestParam(Constants.ID_COLUMN)
            Integer employeeId) {

        try {
            Employee employee = employeeService.getEmployeeById(employeeId);
            return new ModelAndView(Constants.CREATE_EMPLOYEE_JSP, Constants.
                EMPLOYE, employee);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.EMPLOYEE_SEARCH_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is updateEmployee and this
     * is the Post method which contains the Employee Object Details that needs
     * to be updated in the Database. It redirects to the Search Employee page 
     * to display the Updated Employee Object when successfully Updated or
     * redirects to the Error Page when any failure in Modifing the Employee
     * Object to Database.This method returns the value as ModelAndView Object.
     * </p>
     * @param employee Employee Object which is added to the Database. 
     * @return ModelAndView Object which redirects to the Search EmployeePage or
     *         to the Error Page.
     */
    @RequestMapping(value = Constants.UPDATE_EMPLOYEE, method = {RequestMethod.POST
        ,RequestMethod.GET})
    private ModelAndView updateEmployee(@ModelAttribute(Constants.EMPLOYE) 
            Employee employee) {

        try {
            employeeService.modifyEmployee(employee);
            return new ModelAndView(Constants.SEARCH_EMPLOYEE_JSP);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.EMPLOYEE_UPDATE_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is deleteEmployee and this
     * is the Get method which gets the Employee Object Details which is needed
     * to modify. It gets the Employee Object from the Id given by the User and 
     * the respective Employee Object Status is set to False which is Inactive
     * in the database and redirects to the Display Employee page if
     * successfully done or it redirects to the Error page. This method returns
     * the value as ModelAndView Class Object.
     * </p>
     * @param employeeId Integer with employeeId value from which the Employee
     *                   Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Display Employee Page
     *                      with the Employee Object or to the Error Page.
     */
    @RequestMapping(value = Constants.DELETE_EMPLOYEE, method = {RequestMethod.POST
        ,RequestMethod.GET})
    public ModelAndView removeEmployee(@RequestParam(Constants.ID_COLUMN)
            Integer employeeId) {

        try {
            employeeService.removeEmployee(employeeId);
            List<Employee> employees = employeeService.getEmployees();
            return new ModelAndView(Constants.DISPLAY_EMPLOYEE_JSP, Constants.
                EMPLOYES, employees);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.EMPLOYEE_DELETE_FAIL);
        }        
    }

    /**
     * <p>
     * This method is called when the request value is searchEmployee and this
     * is the Get method which gets the Employee Object Details which is needed
     * to searched. It gets the Employee Object from the Id given by the User
     * and the respective Employee Object is redirects to the Search Employee
     * page to display the Details of the respective Employee Object or
     * redirects to Error page if any error occurs. This method returns the
     * value as ModelAndView Class Object.
     * </p>
     * @param employeeId Integer with employeeId value from which the Employee
     *                   Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the Search Employee Page
     *                      with the Employee Object or to the Error Page.
     */
    @RequestMapping(value = Constants.SEARCH_EMPLOYEE, method = {RequestMethod.POST
        ,RequestMethod.GET})
    public ModelAndView searchEmployee(@RequestParam(Constants.ID_COLUMN)
            Integer employeeId) {

        try {
            Employee employee = employeeService.getEmployeeById(employeeId);
            return new ModelAndView(Constants.SEARCH_EMPLOYEE_JSP, Constants.
                EMPLOYE, employee);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.EMPLOYEE_SEARCH_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is displayEmployee and this  
     * is the Get method which gets all the Employee Object Details and is
     * displayed to the user. It is redirected to the Display Employee page or
     * to the Error page if any error occurs.This method returns the value as 
     * ModelAndView Class Object.
     * </p>
     *
     * @return ModelAndView Object which redirects to the DisplayEmployee Page
     *                      with the EmployeeObject List or to the Error Page.
     */
    @RequestMapping(value = Constants.DISPLAY_EMPLOYEE, method = RequestMethod.GET)
    private ModelAndView displayAllEmployees() {
        try {
            List<Employee> employees = employeeService.getEmployees();
            return new ModelAndView(Constants.DISPLAY_EMPLOYEE_JSP, Constants.
                EMPLOYES, employees);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.EMPLOYEE_DISPLAY_FAIL);
        }
    }

    /**
     * <p>
     * This method is called when the request value is activateEmployee and this 
     * is the Get method which gets the Employee Object Details which needs to 
     * activate. It gets the Employee Object from the Id given by the User and
     * the respective Employee Object is Activated.It redirects to the Search
     * Employee page or redirect to Error page if any error occurs.This method 
     * returns the value as ModelAndView Class Object.
     * </p>
     * @param employeeId Integer with EmployeeId value from which the Employee
     *                   Object is obtained from the Database. 
     * @return ModelAndView Object which redirects to the SearchEmployee Page
     *                      with the EmployeeObject or to the Error Page.
     */
    @RequestMapping(value=Constants.ACTIVATE_EMPLOYEE, method = {RequestMethod.POST
        ,RequestMethod.GET})
    private ModelAndView activateEmployee(@RequestParam(Constants.ID_COLUMN)
            Integer employeeId) {
        try {
            employeeService.activateEmployee(employeeId);
            List<Employee> employees = employeeService.getEmployees();
            return new ModelAndView(Constants.DISPLAY_EMPLOYEE_JSP, Constants.
                EMPLOYES, employees);
        } catch (ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP, Constants.ERROR,
                Constants.EMPLOYEE_ACTIVATE_FAIL);
        }
    }
}
