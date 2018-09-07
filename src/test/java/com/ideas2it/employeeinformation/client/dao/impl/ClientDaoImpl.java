package com.ideas2it.employeeinformation.client.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria; 
import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ideas2it.employeeinformation.client.dao.ClientDao;
import com.ideas2it.employeeinformation.client.model.Client;
import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.utils.DateUtil;
import com.ideas2it.employeeinformation.utils.HibernateUtil;

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
public class ClientDaoImpl implements ClientDao {

    public ClientDaoImpl() {
    }

    /**
     * {@inheritDoc}
     */
    public Integer insertClient(final Client client)
            throws ApplicationException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer clientId;
        try {
            transaction = session.beginTransaction();
            client.setIsActive(Boolean.TRUE);
            clientId = (Integer)session.save(client); 
            transaction.commit();
        } catch (HibernateException e) {
            if (null != transaction) {
                transaction.rollback();
            }
            throw new ApplicationException(Constants.CLIENT_INSERT_FAILED+
                    client.getName(), e);
        } finally {
            HibernateUtil.close(session);
        }
      return clientId;
    }

    /**
     * {@inheritDoc}
     */
    public boolean updateClient(final Client client)
            throws ApplicationException {

        Session session = HibernateUtil.getSessionFactory().openSession();
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
            throw new ApplicationException(Constants.CLIENT_UPDATE_FAILED+
                    client.getId(), e);
         } finally {
            HibernateUtil.close(session);
         }
        return isUpdated;
    }

    /**
     * {@inheritDoc}
     */
    public Client selectClientById(final Integer clientId)
            throws ApplicationException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;
        try {
            Criteria criteria = session.createCriteria(Client.class).
                    add(Restrictions.eq(Constants.CLIENT_ID_COLUMN,
                    clientId)).
                    add(Restrictions.eq(Constants.IS_ACTIVE,Boolean.TRUE));
            client = (Client) criteria.uniqueResult(); 
        } catch (HibernateException e) {
            throw new ApplicationException(Constants.CLIENT_SELECT_FAILED+
                    clientId, e);
        } finally {
            HibernateUtil.close(session);
        }
        return client;
    }

    /**
     * {@inheritDoc}
     */
    public List<Client> getAllClients()
            throws ApplicationException{

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Client> clients = new ArrayList<Client>();
        try {
            Criteria criteria = session.createCriteria(Client.class).
                    add(Restrictions.eq(Constants.IS_ACTIVE,Boolean.TRUE));
            clients = criteria.list();
        } catch (HibernateException e) {
            throw new ApplicationException(Constants.CLIENT_CANNOT_DISPLAYED,e);
        } finally {
            HibernateUtil.close(session);
        }
        return clients;
    }
}
