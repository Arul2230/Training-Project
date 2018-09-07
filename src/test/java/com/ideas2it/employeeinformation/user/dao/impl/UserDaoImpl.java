package com.ideas2it.employeeinformation.user.dao.impl;

import org.hibernate.Criteria; 
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.PersistenceException;

import com.ideas2it.employeeinformation.user.dao.UserDao;
import com.ideas2it.employeeinformation.user.model.User;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.utils.HibernateUtil;

/**
 * UserDaoImpl is the dao class implements the UserDao interface and
 * it is processing all the interface methods and this class is having its own
 * method to fetch the ProjectDetails of the User.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove,
 * Search and Display the details in the Database implements the UserDao
 * interface funtions.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    /**
     * {@inheritDoc}
     */
    public Boolean insertUser(final User user) throws ApplicationException {

        Session session = null;
        boolean isInserted = Boolean.FALSE;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            isInserted = Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new ApplicationException(Constants.USER_ADD_FAIL+
                    user.getEmailId(), e);
        } catch (PersistenceException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new ApplicationException(String.format(Constants.
                USER_ADD_FAIL_EMAILID, user.getEmailId()), e);
        } finally {
            HibernateUtil.close(session);
        }
      return isInserted;
    }

    /**
     * {@inheritDoc}
     */
    public User selectUserByEmailId(final String userEmailId)
            throws ApplicationException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
            Criteria criteria = session.createCriteria(User.class).
                    add(Restrictions.eq(Constants.USER_EMAILID,userEmailId));
            user = (User) criteria.uniqueResult(); 
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ApplicationException(Constants.USER_SELECT_FAILED+
                    userEmailId, e);
        } finally {
            HibernateUtil.close(session);
        }
        return user;
    }
}
