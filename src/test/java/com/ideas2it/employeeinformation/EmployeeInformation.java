package com.ideas2it.employeeinformation;

import com.ideas2it.employeeinformation.address.model.Address;
import com.ideas2it.employeeinformation.client.controller.ClientController;
import com.ideas2it.employeeinformation.client.dao.ClientDao;
import com.ideas2it.employeeinformation.client.dao.impl.ClientDaoImpl;
import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.client.service.ClientService;
import com.ideas2it.employeeinformation.client.service.impl.ClientServiceImpl;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.employee.controller.EmployeeController;
import com.ideas2it.employeeinformation.employee.dao.EmployeeDao;
import com.ideas2it.employeeinformation.employee.dao.impl.EmployeeDaoImpl;
import com.ideas2it.employeeinformation.employee.model.Employee;
import com.ideas2it.employeeinformation.employee.service.EmployeeService;
import com.ideas2it.employeeinformation.employee.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.filters.AuthenticationFilter;
import com.ideas2it.employeeinformation.filters.RequestLoggingFilter;
import com.ideas2it.employeeinformation.logger.Logger;
import com.ideas2it.employeeinformation.project.controller.ProjectController;
import com.ideas2it.employeeinformation.project.dao.ProjectDao;
import com.ideas2it.employeeinformation.project.dao.impl.ProjectDaoImpl;
import com.ideas2it.employeeinformation.project.model.Project;
import com.ideas2it.employeeinformation.project.service.ProjectService;
import com.ideas2it.employeeinformation.project.service.impl.ProjectServiceImpl;
import com.ideas2it.employeeinformation.user.controller.UserController;
import com.ideas2it.employeeinformation.user.dao.UserDao;
import com.ideas2it.employeeinformation.user.dao.impl.UserDaoImpl;
import com.ideas2it.employeeinformation.user.model.User;
import com.ideas2it.employeeinformation.user.service.UserService;
import com.ideas2it.employeeinformation.user.service.impl.UserServiceImpl;
import com.ideas2it.employeeinformation.utils.DateUtil;
import com.ideas2it.employeeinformation.utils.StringUtil;

/**
 * <p>
 * EmployeeInformation is the main class program for the EmployeeController
 * ClientController and ProjectController classes. This class has main method 
 * from which all the operations on Employee, Client and Project is Executed.
 * </p>
 * <p>
 * From this class, the Project Details and the Employee Deatils can be accessed
 * and the data manipulation operations can be done on both classes.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
class EmployeeInformation {

    public static void main(String args[]) {

    }
}
