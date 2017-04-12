package erp.DAO.DAOImpl;

import erp.DAO.RoleDAO;
import erp.entity.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDAOImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public void addRole(Role r) {
        sessionFactory.getCurrentSession().save(r);
    }

    @Override
    public void deleteRole(Role r) {
        sessionFactory.getCurrentSession().delete(r);
    }

    @Override
    public void changeRoleName(Role r, String new_name) {
        r.setName(new_name);
        sessionFactory.getCurrentSession().update(r);
    }

    @Override
    public List<Role> getListOfRoles() {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(Role.class);
        return (List<Role>)criteria.list();
    }

    @Override
    public Role getRoleByName(String name) {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(Role.class);
        criteria.add(Restrictions.eq("NAME", name));
        return (Role)criteria.uniqueResult();
    }

    @Override
    public Role getRole(int id) {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(Role.class);
        criteria.add(Restrictions.eq("ID", id));
        return (Role)criteria.uniqueResult();
    }
}
