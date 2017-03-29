package DAO.DAOImpl;

import DAO.ProjectDAO;
import entities.Project;
import entities.User;
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
public class ProjectDAOImpl implements ProjectDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDAOImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public void addNewProject(Project pr, String status, String comment, Date launch_date) {
        status = status.toUpperCase();
        pr.setStatus(status);
        pr.setLaunch_date(launch_date);
        String fullComment = pr.getComment() + "; ++APPROVE COMMENT++: " + comment;
        pr.setComment(fullComment);
        sessionFactory.getCurrentSession().update(pr);
    }

    @Override
    public void addNewProject(Project pr, String status, String comment){
        status = status.toUpperCase();
        pr.setStatus(status);
        String fullComment = pr.getComment() + "; ++APPROVE COMMENT++: " + comment;
        pr.setComment(fullComment);
        sessionFactory.getCurrentSession().update(pr);
    }

    @Override
    public void requestNewProject(Project pr) {
        pr.setStatus("PENDING");
        sessionFactory.getCurrentSession().save(pr);
    }

    @Override
    public void finishProject(Project pr) {
        pr.setStatus("FINISHED");
        pr.setFinish_date(new Date());
        sessionFactory.getCurrentSession().update(pr);
    }

    @Override
    public void changeManager(Project pr, User new_manager) {
        pr.setManager(new_manager);
        sessionFactory.getCurrentSession().update(pr);
    }

    @Override
    public void changeProjectName(Project pr, String new_name) {
        pr.setName(new_name);
        sessionFactory.getCurrentSession().update(pr);
    }

    @Override
    public void addComment(Project pr, String comment) {
        String full_comment = pr.getComment() + "; " + comment;
        pr.setComment(full_comment);
        sessionFactory.getCurrentSession().update(pr);
    }

    @Override
    public void changeStatus(Project pr, String new_status) {
        new_status = new_status.toUpperCase();
        pr.setStatus(new_status);
        sessionFactory.getCurrentSession().update(pr);
    }

    @Override
    public Project getProjectById(int id) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        criteria.add(Restrictions.eq("ID", id));
        return (Project) criteria.uniqueResult();
    }

    @Override
    public List<Project> getProjectByName(String name) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        criteria.add(Restrictions.eq("NAME", name));
        return (List<Project>) criteria.list();
    }

    @Override
    public List<Project> getAllProject() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        return (List<Project>) criteria.list();
    }

    @Override
    public List<Project> getProjectByManager(User manager) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        criteria.add(Restrictions.eq("MANAGER", manager));
        return (List<Project>)criteria.list();
    }

    @Override
    public List<Project> getCurrentProjects() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        criteria.add(Restrictions.eq("STATUS", "ACTIVE"));
        return (List<Project>)criteria.list();
    }

    @Override
    public List<Project> getFinishedProjects() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        criteria.add(Restrictions.eq("STATUS", "FINISHED"));
        return (List<Project>)criteria.list();
    }

    @Override
    public List<Project> getActiveProjectsAtDate(Date d) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        criteria.add(Restrictions.and(
                        Restrictions.le("LAUNCH_DATE", d),
                        Restrictions.gt("LAUNCH_DATE", d),
                        Restrictions.eq("STATUS", "ACTIVE")));
        return (List<Project>)criteria.list();
    }
}
