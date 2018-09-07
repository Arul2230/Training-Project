package com.ideas2it.employeeinformation.user.service.impl;

import java.util.List;

import com.ideas2it.employeeinformation.user.dao.UserDao;
import com.ideas2it.employeeinformation.user.dao.impl.UserDaoImpl;
import com.ideas2it.employeeinformation.user.model.User;
import com.ideas2it.employeeinformation.user.service.UserService;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * UserServiceImpl is the Service class implementing the UserService
 * interface and this implements all the methods of the interface program.
 * <p>
 * It processes all the business logic operations and calls the Dao class to
 * do the data accessing operations.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class UserServiceImpl implements UserService {

    private static UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * {@inheritDoc}
     */
    public Boolean addUser(final User user) throws ApplicationException {
        return userDao.insertUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public User getUserByEmailId(final String userEmailId)
            throws ApplicationException {
        return userDao.selectUserByEmailId(userEmailId);
    }
}
