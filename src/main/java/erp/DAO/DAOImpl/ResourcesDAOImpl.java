package erp.DAO.DAOImpl;

import erp.DAO.ResourcesDAO;
import erp.entity.Project;
import erp.entity.Resources;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ResourcesDAOImpl implements ResourcesDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public ResourcesDAOImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public void requestResource(Resources res) {
        res.setStatus(0);
        sessionFactory.getCurrentSession().save(res);
    }

    @Override
    public void addResource(Resources res) {
        res.setStatus(1);
        sessionFactory.getCurrentSession().update(res);
    }

    @Override
    public void addResource(Resources res, Date d) {
        res.setStatus(1);
        res.setAss_date(d);
        sessionFactory.getCurrentSession().update(res);
    }

    public void addResource(Resources res, String description){
        res.setStatus(1);
        res.setDescription(description);
        sessionFactory.getCurrentSession().update(res);
    }

    public void addResource(Resources res, Date d, String description){
        res.setStatus(1);
        res.setDescription(description);
        res.setAss_date(d);
        sessionFactory.getCurrentSession().update(res);
    }

    @Override
    public void declineResource(Resources res, String description){
        res.setStatus(2);
        res.setDescription(description);
        sessionFactory.getCurrentSession().update(res);
    }

    @Override
    public void closeResource(Resources res) {
        res.setStatus(3);
        sessionFactory.getCurrentSession().update(res);
    }

    @Override
    public void changeDescription(Resources res, String new_descr) {
        res.setDescription(new_descr);
        sessionFactory.getCurrentSession().update(res);
    }

    @Override
    public List<Resources> getAllResources() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Resources.class);
        return (List<Resources>)criteria.list();
    }

    @Override
    public List<Resources> getAllProjectResources(Project pr) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Resources.class);
        criteria.add(Restrictions.eq("PROJECT", pr));
        return (List<Resources>)criteria.list();
    }

    @Override
    public List<Resources> getActiveResources() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Resources.class);
        criteria.add(Restrictions.eq("STATUS", 1));
        return (List<Resources>)criteria.list();
    }

    @Override
    public List<Resources> getFinishedResources() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Resources.class);
        criteria.add(Restrictions.eq("STATUS", 3));
        return (List<Resources>)criteria.list();
    }
}
