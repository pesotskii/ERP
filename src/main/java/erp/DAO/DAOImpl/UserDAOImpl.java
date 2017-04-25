package erp.DAO.DAOImpl;

import erp.DAO.UserDAO;
import erp.config.HibernateUtil;
import erp.entity.Department;
import erp.entity.Role;
import erp.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    // for dev
    public UserDAOImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    // for tests
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User u) {
        Transaction tx = null;
       Session session = sessionFactory.openSession();
       tx = session.beginTransaction();
       session.save(u);
       tx.commit();
    }

    @Override
    public String getFullName(int id) {
        Session session = sessionFactory.openSession();
            User user = session.get(User.class,id);
        return user.getFirst_name() + user.getLast_name();
    }

    @Override
    public void changeRole(User u, Role new_role) {
        u.setRole(new_role);
        sessionFactory.getCurrentSession().update(u);
    }

    @Override
    public User getManager(int id) {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(User.class);
        criteria.add(Restrictions.eq("ID", id));
        User u = (User)criteria.uniqueResult();
        return u.getManager();
    }

    @Override
    public List<User> getUserIdByName(String first_name, String last_name) {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(User.class);
        criteria.add(Restrictions.and(
                Restrictions.eq("FIRST_NAME", first_name),
                Restrictions.eq("LAST_NAME", last_name)));
        return (List<User>)criteria.list();
    }

    @Override
    public void changeStatus(User u, String new_status) {
        new_status = new_status.toUpperCase();
        u.setStatus(new_status);
        sessionFactory.getCurrentSession().update(u);
    }

    @Override
    public Department getDepartment(int id) {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(User.class);
        criteria.add(Restrictions.eq("ID", id));
        return (Department)criteria.uniqueResult();
    }

    @Override
    public void fireUser(User u) {
        u.setStatus("FIRED");
        u.setFire_date(new Date());
        sessionFactory.getCurrentSession().update(u);
    }

    @Override
    public void hireUser(User u) {
        u.setStatus("ACTIVE");
        u.setHire_date(new Date());
        sessionFactory.getCurrentSession().update(u);
    }

    @Override
    public void deleteError(User u) {
        sessionFactory.getCurrentSession().delete(u);
    }
}
