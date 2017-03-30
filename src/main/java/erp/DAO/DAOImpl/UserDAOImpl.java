package erp.DAO.DAOImpl;

import erp.DAO.UserDAO;
import erp.entities.Department;
import erp.entities.Role;
import erp.entities.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public void addUser(User u) {
        sessionFactory.getCurrentSession().save(u);
    }

    @Override
    public String getFullName(int id) {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(User.class);
        criteria.add(Restrictions.eq("ID", id));
        User u = (User)criteria.uniqueResult();
        return u.getFirst_name() + u.getLast_name();
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
