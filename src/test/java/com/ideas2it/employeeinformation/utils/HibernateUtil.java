package com.ideas2it.employeeinformation.utils;

import org.hibernate.HibernateException; 
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.exception.ApplicationException;

/**
 * HibernateUtil is the utility class used to create a hibernate
 * connection for java application to access the MySql Database.
 * This class will give access connection to the Employee database in Mysql.
 *
 * @author   ArulMurugan
 * @version  1.0
 */
public class HibernateUtil {

    private static SessionFactory factory;

    /**
     * This Method is used to get the SessionFactory for the Database .It checks
     * whether the session factory is null or it is closed and if it is closed 
     * or null new factory is created otherwise old factory is returned.
     *
     * @return factory SessionFactory object used to connect to the Database
     */
    public static SessionFactory getSessionFactory() 
            throws ApplicationException {

        try {
            if ((null == factory) || (factory.isClosed())) {

                factory = new Configuration().configure(Constants.
                    HIBERNATE_CONFIG_FILE).buildSessionFactory();
            }
        } catch (HibernateException e) {
            throw new ApplicationException(e);
        }
        return factory;
    }

    /**
     * <p>
     * This Method is used to close the session created by other methods
     * this method is called after everytime the user opens a session.
     * </p>
     * @param session Session opened by the other methods.
     */
    public static void close(final Session session)
            throws ApplicationException{

        try {
            if (null != session) {
                session.close();
            }
        } catch (HibernateException e) {
            throw new ApplicationException(e);
        }
    }
}
