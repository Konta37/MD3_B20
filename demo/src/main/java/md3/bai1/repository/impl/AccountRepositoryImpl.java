package md3.bai1.repository.impl;

import md3.bai1.model.entity.Account;
import md3.bai1.repository.AccountRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Account> findAll() {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from Account").list();
            return list;
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(Account account) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Account findById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Account.class, id);
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from Account where username = :username and password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (Account) query.uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
