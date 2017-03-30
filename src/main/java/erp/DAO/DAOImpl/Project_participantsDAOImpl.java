package erp.DAO.DAOImpl;


import erp.DAO.Project_participantsDAO;
import erp.entities.Project;
import erp.entities.Project_participants;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class Project_participantsDAOImpl implements Project_participantsDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public  Project_participantsDAOImpl(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public void addNewParticipant(Project_participants p) {
        sessionFactory.getCurrentSession().save(p);
    }

    @Override
    public void removeParticipant(Project_participants p) {
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public void changeRoleOfParticipant(Project_participants p, String role) {
        p.setP_role(role);
        sessionFactory.getCurrentSession().update(p);
    }

    @Override
    public List<Project_participants> getAllParticipants() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project_participants.class);
        return (List<Project_participants>) criteria.list();
    }

    @Override
    public List<Project_participants> getAllParticipantsOfProject(Project pr) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project_participants.class);
        criteria.add(Restrictions.eq("PROJECT", pr));
        return (List<Project_participants>) criteria.uniqueResult();
    }

    @Override
    public void deleteError(Project_participants p) {
        sessionFactory.getCurrentSession().delete(p);
    }
}
