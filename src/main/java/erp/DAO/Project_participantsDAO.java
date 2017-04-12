package erp.DAO;

import erp.entity.Project;
import erp.entity.Project_participants;

import java.util.List;

public interface Project_participantsDAO {
    void addNewParticipant(Project_participants p);

    //участник завершает участие
    void removeParticipant(Project_participants p);

    void changeRoleOfParticipant(Project_participants p, String role);

    List<Project_participants> getAllParticipants();

    List<Project_participants> getAllParticipantsOfProject(Project pr);

    //удаление ошибочной строки (на всякий случай)
    void deleteError(Project_participants p);
}
