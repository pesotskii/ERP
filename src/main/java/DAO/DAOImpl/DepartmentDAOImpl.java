package DAO.DAOImpl;

import DAO.DepartmentDAO;
import entities.Department;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public DepartmentDAOImpl(SessionFactory sessionFactory){ this.sessionFactory = sessionFactory; }

    @Override
    public void addDepartment(Department dep) {
        sessionFactory.getCurrentSession().save(dep);
    }

    @Override
    public void changeDepartmentName(Department dep, String new_name) {
        dep.setName(new_name);
        sessionFactory.getCurrentSession().update(dep);
    }

    @Override
    public void deleteDepartment(Department dep) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(dep);
        session.flush();
    }

    @Override
    public Department getDepartmentById(int id) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Department.class);
        criteria.add(Restrictions.eq("ID", id));
        return (Department) criteria.uniqueResult();
    }

    @Override
    public List<Department> getAllDepartments() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Department.class);
        return (List<Department>) criteria.list();
    }
}
