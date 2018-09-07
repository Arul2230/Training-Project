package com.ideas2it.employeeinformation.commons.constants;

/**
 * Constants is an interface program which is used to define the constant
 * String functions that is used in many other Programs.
 * <p>
 * Using Constant class as an public interface such that all the variable
 * defined inside the public interface is public final.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public final class Constants {

    private Constants() {
    }

    public static final String PROJECT_ID = "projectId";
    public static final String EMPLOYEE_ID = "employeeId";
    public static final String NAME = "name";
    public static final String NUMBER_OF_RESOURCES = "numberOfResource";
    public static final String PROJECT_CODE = "projectCode";
    public static final String PROJECT_ROLE = "projectRole";
    public static final String EMP_NAME = "Name";
    public static final String ID = "Id";
    public static final String SALARY = "salary";
    public static final String EMAILID = "emailid";
    public static final String ROLE = "role";
    public static final String  BIRTH_DATE = "birthdate";
    public static final String JOIN_DATE = "joindate";
    public static final String ALPHABET_VALIDATOR = "^[a-zA-Z]{1,20}$";
    public static final String DASH_LINE = "---------------------";
    public static final String VALID_DATE = "Enter a valid date";
    public static final String TAB_SPACE = "\t\t";
    public static final String LINE_SPACE = "\n";
    public static final String DATABASE_NAME = "Employee";
    public static final String EMPLOYEE_ADDED = 
        "Employee is Added Successfully and Employee Id is:";
    public static final String EMPLOYEE_NOT_ADDED = 
        "Employee Insertion failed";
    public static final String EMPLOYEE_MODIFIED = 
        "Employee is modified Successfully";
    public static final String EMPLOYEE_NOT_MODIFIED = 
        "Employee Modification failed";
    public static final String EMPLOYEE_NOT_REMOVED = 
        "Employee Deletion is failed";
    public static final String EMAILID_TAKEN = 
        "Email Id is already registered to other Employee";
    public static final String PROJECT_CODE_TAKEN = 
        "Project Code is already registered to other Project";
    public static final String LOG_PROPERTY_FILE = "log4j.xml";
    public static final String NOT_DISPLAYED =
        "The Employee Details cannot be displayed.\nServer Error";
    public static final String NOT_REMOVED =
        "The Employee %s NOT Removed.\nServer Error";
    public static final String MODIFY_FAILED =
        "The Employee %s Not Modified.\nServer Error";
    public static final String NOT_ADDED =
        "The Employee %s NOT Added.\nServer Error";
    public static final String SEARCH_FAILED =
        "The Employee %s cannot be Searched.\nServer Error";
    public static final String PROJECT_ADD_FAIL =
        "The Project %s NOT Added.\nServer Error";
    public static final String PROJECT_SEARCH_FAIL =
        "The Project %s cannot be Searched.\nServer Error";
    public static final String PROJECT_NOT_REMOVED =
        "The Project %s NOT Removed.\nServer Error";
    public static final String PROJECT_NOT_DISPLAYED =
        "The Project Details cannot be displayed.\nServer Error";
    public static final String PROJECT_MODIFY_FAILED =
        "The Project %s Not Modified.\nServer Error";
    public static final String SERVER_ERROR = "SERVER ERROR..TRY AGAIN";
    public static final String EMPLOYEE_ADD_FAIL =
        "The Employee %s NOT Added to Project %s.\nServer Error";
    public static final String EMPLOYEE_ADD_FAIL_EMAILID =
        "The Employee NOT Added Emailid ? Already taken by other user";
    public static final String EMPLOYEE_REMOVE_FAIL =
        "The Employee %s NOT Removed from the Project %s.\nServer Error";
    public static final String HIBERNATE_CONFIG_FILE =
        "com/ideas2it/employeeinformation/xml/hibernate.cfg.xml";
    public static final String CLIENT_DETAILS_DISPLAY = "Client details";
    public static final String GET_CLIENT_NAME = "\nClient Name: ";
    public static final String GET_CLIENT_COMPANY_NAME = 
        "\nClient Company Name: ";
    public static final String GET_CLIENT_EMAILID = "\nClient EmailId: ";
    public static final String GET_CLIENT_ID = "\nEnter Client the  Id: ";
    public static final String GET_CLIENT_DETAILS = "Enter the client details";
    public static final String CLIENT_ADDED = 
        "Client is Added Successfully and the Client Id is:";
    public static final String CLIENT_NOT_ADDED = 
        "Client Insertion failed";
    public static final String NO_CLIENT_ID = "The ClientId not found";
    public static final String CLIENT_REMOVED = 
        "Client is deleted Successfully";
    public static final String CLIENT_NOT_REMOVED = 
        "Client Deletion is failed";
    public static final String CLIENT_ID_FOUND = "The ClientId found";
    public static final String EMPLOYEE_DB = "FROM Employee";
    public static final String PROJECT_DB = "FROM Project";
    public static final String IS_ACTIVE = "IsActive";
    public static final String EMPLOYEE_ID_COLUMN = "id";
    public static final String CLIENT_ID_COLUMN = "id";
    public static final String ASSIGN_PROJECT_NOW = 
        "Do you want to add Project? [1/0]";
    public static final String SELECT_PROJECT = "\nSelect Project by Id: ";
    public static final String DOOR_NUMBER = "%sDoorNumber";
    public static final String STREET_NAME = "%sStreetName";
    public static final String CITY = "%sCity";
    public static final String STATE = "%sState";
    public static final String COUNTRY = "%sCountry";
    public static final String PIN_CODE = "%sPostcode";
    public static final String PRESENT_ADDRESS = "Enter Present Address: ";
    public static final String PERMANENT_ADDRESS = "Enter Permamanent Address:";
    public static final String SAME_ADDRESS = 
        "Permanent Address same as Present Address.Press 1";
    public static final String PERMANENT = "permanent";
    public static final String PRESENT = "present";
    public static final String CLIENT_INSERT_FAILED =
        "Client %s Insertion Failed";
    public static final String CLIENT_UPDATE_FAILED = 
        "Client %s Modification Failed";
    public static final String CLIENT_DELETE_FAILED =
        "Client %s Deletion Failed";
    public static final String CLIENT_SELECT_FAILED =
        "Client %s cannot be Searched";
    public static final String USER_SELECT_FAILED =
        "User %s not found";
    public static final String CLIENT_CANNOT_DISPLAYED = 
        "Client Information cannot be Displayed";
    public static final String SERVLET_STARTED = "Servlet Started Successfully";
    public static final String SERVLET_CLOSED = "Servlet Terminated..Bubye";
    public static final String VALUE = "value";
    public static final String EMPLOYEE_JSP = "/Employee";
    public static final String DISPLAY = "display";
    public static final String DISPLAY_INACTIVE = "displayInActive";
    public static final String ACTIVE = "active";
    public static final String PASSWORD = "password";
    public static final String USER = "user";
    public static final String CREATE_CLIENT = "/createClient";
    public static final String DELETE = "delete";
    public static final String SEARCH = "search";
    public static final String MODIFY = "modify";
    public static final String UPDATE = "update";
    public static final String ASSIGN = "assign";
    public static final String ERROR = "error";
    public static final String ASSIGNEMPLOYEES = "assignEmployees";
    public static final String ASSIGNPROJECTS = "assignProjects";
    public static final String REMOVEEMPLOYEES = "removeEmployees";
    public static final String REMOVEPROJECTS = "removeProjects";
    public static final String CREATE_EMPLOYEE_JSP =
        "/CreateEmployee";
    public static final String EMPLOYE = "employee";
    public static final String EMPLOYES = "employees";
    public static final String CHECKED = "checked";
    public static final String DISPLAY_EMPLOYEE_JSP =
        "/DisplayEmployee";
    public static final String SEARCH_EMPLOYEE_JSP =
        "/SearchEmployee";
    public static final String ERROR_JSP = "/Error";
    public static final String EMPLOYEE_URL = "/employee/";
    public static final String EMPLOYEE_URI = "/employee";
    public static final String COMPANY_NAME = "companyName";
    public static final String CLIENTS = "clients";
    public static final String DISPLAY_CLIENT_JSP =
        "/DisplayClient";
    public static final String SEARCH_CLIENT_JSP =
        "/SearchClient";
    public static final String CLIENT_JSP =
        "/Client";
    public static final String CLIENT = "client";
    public static final String CLIENT_ID = "clientId";
    public static final String COMMAND = "command";
    public static final String CLIENT_URL = "/client/";
    public static final String CLIENT_URI = "/client";
    public static final String PROJECT_URI = "/project";
    public static final String USER_URL = "/user";
    public static final String CREATE_CLIENT_JSP =
        "/CreateClient";
    public static final String ID_COLUMN = "id";
    public static final String PROJECT_JSP =
        "/Project";
    public static final String PROJECT = "project";
    public static final String PROJECT_URL = "/project/";
    public static final String CREATE_PROJECT_JSP =
        "/CreateProject";
    public static final String SEARCH_PROJECT_JSP =
        "/SearchProject";
    public static final String PROJECTS = "projects";
    public static final String DISPLAY_PROJECT_JSP =
        "/DisplayProject";
    public static final String ASSIGN_EMPLOYEE_JSP =
        "/AssignEmployee";
    public static final String ASSIGN_PROJECT_JSP =
        "/AssignProjects";
    public static final String CREATE_PROJECT = "/createProject";
    public static final String ADD_PROJECT = "/addProject";
    public static final String MODIFY_PROJECT = "/modifyProject";
    public static final String UPDATE_PROJECT = "/updateProject";
    public static final String ASSIGN_EMPLOYEES = "/assignEmployees";
    public static final String ADD_EMPLOYEES_TO_PROJECT = 
        "/assignEmployeesToProject";
    public static final String REMOVE_EMPLOYEES = "/removeEmployees";
    public static final String DELETE_PROJECT = "/deleteProject";
    public static final String SEARCH_PROJECT = "/searchProject";
    public static final String DISPLAY_PROJECT = "/displayProject";
    public static final String ADD_CLIENT = "/addClient";
    public static final String MODIFY_CLIENT = "/modifyClient";
    public static final String UPDATE_CLIENT = "/updateClient";
    public static final String ASSIGN_PROJECTS = "/assignProjects";
    public static final String ADD_PROJECTS_TO_CLIENT = 
        "/assignProjectsToClient";
    public static final String REMOVE_PROJECTS = "/removeProjects";
    public static final String DELETE_CLIENT = "/deleteClient";
    public static final String SEARCH_CLIENT = "/searchClient";
    public static final String DISPLAY_CLIENT = "/displayClient";
    public static final String CREATE_EMPLOYEE = "/createEmployee";
    public static final String ADD_EMPLOYEE = "/addEmployee";
    public static final String MODIFY_EMPLOYEE = "/modifyEmployee";
    public static final String UPDATE_EMPLOYEE = "/updateEmployee";
    public static final String DELETE_EMPLOYEE = "/deleteEmployee";
    public static final String SEARCH_EMPLOYEE = "/searchEmployee";
    public static final String DISPLAY_EMPLOYEE = "/displayEmployee";
    public static final String DISPLAY_INACTIVE_EMPLOYEE = "/displayInActiveEmployee";
    public static final String ACTIVATE_EMPLOYEE = "/activateEmployee";
    public static final String LOGIN_SUCCESS_JSP = "/index";
    public static final String INDEX = "index";
    public static final String LOGINFILE = "/login";
    public static final String LOGIN_JSP = "login";
    public static final String REGISTER = "register";
    public static final String REGISTER_REQUEST = "/register";
    public static final String LOGOUT = "logout";
    public static final String WRONGUSER =
        "Either user name or password is wrong.";
    public static final String USER_EMAILID = "emailId";
    public static final String ENTER_NUMBER = "Enter only number in salary ";
    public static final String NOT_AUTHORISED =
        "You are not an Authorised User.\nStay to your Limits!!";
    public static final String HOME = "/employeeinformation/";
    public static final String WELCOME_PAGE = "login";
    public static final Integer SESSION_INTERVAL = 10*60;
    public static final Integer COOKIE_INTERVAL = 30*60;
    public static final String WRONGUSER_ATTRIBUTE = "user";
    public static final String CONTENT_TYPE = "text/html";
    public static final String BEANS = "Beans.xml";
    public static final String USER_ADD_FAIL_EMAILID =
        "User ? mailId already registered";
    public static final String USER_ADD_FAIL = "User ? addition failed.";
    public static final String PROJECT_NAME = "employeeinformation";
    public static final String CSS = "/css";
    public static final String JS = "/js";
    public static final String IMAGES = "images";
    public static final String INDEX_LOGIN = "indexLogin";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
}
