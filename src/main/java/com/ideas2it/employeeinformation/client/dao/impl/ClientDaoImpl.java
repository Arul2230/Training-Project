package com.ideas2it.employeeinformation.client.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria; 
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ideas2it.employeeinformation.HibernateDao;
import com.ideas2it.employeeinformation.client.dao.ClientDao;
import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.logger.Logger;

/**
 * ClientDaoImpl is the dao class implements the ClientDao interface and
 * it is processing all the interface methods and this class is having its own
 * method to fetch the ProjectDetails of the Client.
 * <p>
 * It is having the data manipulation methods like Add, Modify, Remove,
 * Search and Display the details in the Database implements the ClientDao
 * interface funtions.
 * </p>
 * ArrayList is used to store the values of the Client details which are
 * gathered from the Database.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class ClientDaoImpl extends HibernateDao implements ClientDao {

    public ClientDaoImpl() {
    }

    /**
     * {@inheritDoc}
     */
    public boolean insertClient(final Client client)
            throws ApplicationException {

        Session session = getSession();
        Transaction transaction = null;
        boolean isInserted = Boolean.FALSE;
        try {
            transaction = session.beginTransaction();
            client.setIsActive(Boolean.TRUE);
            session.save(client); 
            transaction.commit();
            isInserted = Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                CLIENT_INSERT_FAILED, client.getName()), e);
        } catch (PersistenceException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                CLIENT_ADD_FAIL_EMAILID, client.getEmailId()), e);
        } finally {
            close(session);
        }
      return isInserted;
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateClient(final Client client)
            throws ApplicationException {

        Session session = getSession();
        Transaction transaction = null;
        boolean isUpdated = Boolean.FALSE;
        try {
            transaction = session.beginTransaction();
            session.update(client); 
            transaction.commit();
            isUpdated = Boolean.TRUE;
        } catch (HibernateException e) {
            if (null != transaction) {
               transaction.rollback();
            }
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                CLIENT_UPDATE_FAILED, client.getId()), e);
         } finally {
            close(session);
         }
        return isUpdated;
    }

    /**
     * {@inheritDoc}
     */
    public boolean inActivateClient(final Client client)
            throws ApplicationException {
        client.setIsActive(Boolean.FALSE);
        return updateClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public boolean activateClientById(final Integer clientId)
            throws ApplicationException {

        Client client = selectClientById(clientId);
        client.setIsActive(Boolean.TRUE);
        return updateClient(client);
    }

    /**
     * {@inheritDoc}
     */
    public Client selectClientById(final Integer clientId)
            throws ApplicationException {

        Session session = getSession();
        Client client = null;
        try {
            Criteria criteria = session.createCriteria(Client.class).
                    add(Restrictions.eq(Constants.CLIENT_ID_COLUMN,
                    clientId));
            client = (Client) criteria.uniqueResult(); 
        } catch (HibernateException e) {
            Logger.error(e);
            throw new ApplicationException(String.format(Constants.
                CLIENT_SELECT_FAILED, clientId), e);
        } finally {
            close(session);
        }
        return client;
    }

    /**
     * {@inheritDoc}
     */
    public List<Client> getAllClients()
            throws ApplicationException{

        Session session = getSession();
        List<Client> clients = new ArrayList<Client>();
        try {
            Criteria criteria = session.createCriteria(Client.class);
            clients = criteria.list();
        } catch (HibernateException e) {
            Logger.error(e);
            throw new ApplicationException(Constants.CLIENT_CANNOT_DISPLAYED, e);
        } finally {
            close(session);
        }
        return clients;
    }
}
