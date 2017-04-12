package erp.DAO;

import erp.entity.Department;
import erp.entity.Role;
import erp.entity.User;

import java.util.List;

public interface UserDAO {
    void addUser(User u);

    String getFullName(int id);

    void changeRole(User u, Role new_role);

    User getManager(int id);

    List<User> getUserIdByName(String first_name, String last_name);

    void changeStatus(User u, String new_status);

    Department getDepartment(int id);

    //увольнение
    void fireUser(User u);

    //наём
    void hireUser(User u);

    //устранение ошибочной записи
    void deleteError(User u);
}
