package DAO;

import entities.Project;
import entities.User;

import java.util.Date;
import java.util.List;

public interface ProjectDAO {
    void addNewProject(Project pr, String status, String comment, Date launch_date);

    void addNewProject(Project pr, String status, String comment);

    void requestNewProject(Project pr);

    void finishProject(Project pr);

    void changeManager(Project pr, User new_manager);

    void changeProjectName(Project pr, String new_name);

    void addComment(Project pr, String comment);

    //не уверен, что это будет использоваться где-то
    void changeStatus(Project pr, String new_status);

    Project getProjectById(int id);

    //пояснение - жёстко нигде не требуется, чтобы имена были уникальными,
    // поэтому теоретически возможно существование 2-х и более проектов с одинаковым именем
    List<Project> getProjectByName(String name);

    List<Project> getAllProject();

    List<Project> getProjectByManager(User manager);

    List<Project> getCurrentProjects();

    List<Project> getFinishedProjects();

    List<Project> getActiveProjectsAtDate(Date d);
}
