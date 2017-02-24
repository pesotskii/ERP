package DAO;

import entities.Department;
import entities.User;

import java.util.List;

public interface UserDAO {
    void addUser(User u);

    String getFullName(int id);

    void changeRole(User u);

    int getManager(int id);

    List<User> getUserIdByName(String first_name, String last_name);

    void cahngeStatus(User u);

    Department getDepartment(int id);

    //увольнение
    void retireUser(User u);

    //устранение ошибочной записи
    void deleteError(User r);
}
