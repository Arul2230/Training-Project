package com.ideas2it.employeeinformation.user.service;

import java.util.List;

import com.ideas2it.employeeinformation.user.model.User;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * UserService is the Service interface which is having the several data
 * manipulation methods and this class does the business logic operations
 * on the User Details.
 * <p>
 * It has the Implementation class which is performing the business logic
 * operations on the User Details.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public interface UserService {

    /**
     * <p>
     * This Method is used if a user wants to Add User Details.
     * It gets the User object which contains all the information about
     * the User that needs to be added.
     * </p>
     *
     * @param  user User object type contains the User details
     *                  that needs to be added.
     * @return boolean returns true when User object added successfully.
     * @exception throws Application Exception when the User Object is not
     *            inserted due to any connection error, same User EmailId 
     *            or same UserId.
     */
    public Boolean addUser(final User user) throws ApplicationException;

    /**
     * <p>
     * Method to search the Existing User.This method is using the User
     * EmailId to search and returns the searched User Object.
     * </p>
     *
     * @param  userEmailId  a String datatype which contains the User
     *                      emailid that needs to be searched.
     * @return returns User object when id is found and null
     *         when not found.
     */
    public User getUserByEmailId(final String userEmailId)
        throws ApplicationException;
}
