package com.ideas2it.employeeinformation;

import org.hibernate.HibernateException; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.logger.Logger;

/**
 * HibernateDao is the dao class used to access a hibernate Session to get
 * connection for java application for accessing the Database.
 * This class will give access connection to the Employee database in Mysql.
 *
 * @author   ArulMurugan
 * @version  1.0
 */
public class HibernateDao {

    private static SessionFactory factory;

    /**
     * This Method is used to get the Session for the Database .It checks
     * whether the session factory is null or it is closed and if it is closed 
     * or null new factory is created otherwise old factory is accessed.
     * From the SessionFactory, Session is returned.
     *
     * @return Session object used to connect to the Database.
     * @throws ApplicationException when unable to return a Session Object.
     */
    protected Session getSession() throws ApplicationException {

        if ((null == factory) || (factory.isClosed())) {
            getSessionFactory();
        }
        return factory.openSession();
    }

    /**
     * This Method is used to create a SessionFactory for Employee Database.
     * It uses the Hibernate Configuration file and creates the Session Factory. 
     *
     * @throws ApplicationException when failure occured in creating a Session
     *                              Factory.
     */
    private static void getSessionFactory() throws ApplicationException {
        try {
            factory = new Configuration().configure(Constants.
                HIBERNATE_CONFIG_FILE).buildSessionFactory();
        } catch (HibernateException e) {
            Logger.error(e);
            throw new ApplicationException(Constants.SESSION_FACTORY_NOT_CREATED
                , e);
        }
    }
            

    /**
     * <p>
     * This Method is used to close the session created by other methods
     * this method is called after everytime the user opens a session.
     * </p>
     * @param session Session opened by the other methods.
     */
    protected void close(final Session session) {

        try {
            if (null != session) {
                session.close();
            }
        } catch (HibernateException e) {
            Logger.error(e);
        }
    }
}
