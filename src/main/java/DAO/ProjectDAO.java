package DAO;

import entities.Project;

import java.util.Date;
import java.util.List;

public interface ProjectDAO {
    void addNewProject(Project pr);

    void requestNewProject(Project pr);

    void finishProject(Project pr);

    void changeManager(Project pr);

    void changeProjectName(Project pr);

    void addComment(Project pr);

    //не уверен, что это будет использоваться где-то
    void changeStatus(Project pr);

    Project getProjectById(int id);

    //пояснение - жёстко нигде не требуется, чтобы имена были уникальными,
    // поэтому теоретически возможно существование 2-х и более проектов с одинаковым именем
    List<Project> getProjectByName(String name);

    List<Project> getAllProject();

    List<Project> getProjectByManager(int manager);

    List<Project> getCurrentProjects();

    List<Project> getFinishedProjects();

    List<Project> getActiveProjectsAtDate(Date d);
}
