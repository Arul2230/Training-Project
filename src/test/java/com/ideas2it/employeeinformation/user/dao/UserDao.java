package com.ideas2it.employeeinformation.user.dao;

import com.ideas2it.employeeinformation.user.model.User;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * UserDao is the DAO interface program which is having the methods
 * that is processing the data access operations of the User Details.
 * <p>
 * It is having the implementation clasess, which performs the Add,Modify,
 * Remove,Search and Display the User details.
 * </p>
 * This interface has a method to gather details of all the Users that are
 * stored in the Database.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public interface UserDao {


    /**
     * <p>
     * This Method is used when a user wants to Add a User Object in the
     * Database.This method gets the User object which contains the User
     * Details that needs to be added in the database.
     * </p>
     *
     * @param user User object type contains the User details in it.
     * @return boolean returns true when User object is added successfully.
     */
    public Boolean insertUser(final User user) 
            throws ApplicationException;
    /**
     * <p>
     * Method to search the User Id in the database.This method is using
     * the UserId to search the User and is searched in the database.
     * </p>
     *
     * @param   userEmailId  a String datatype which contains the User
     *                       Emailid that needs to be searched.
     * @return  user    returns User object when id is found
     *                      and null when not found.
     */
    public User selectUserByEmailId(final String userEmailId)
            throws ApplicationException;
}
