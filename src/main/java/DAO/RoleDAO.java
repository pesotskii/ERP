package DAO;

import entities.Role;

import java.util.List;

public interface RoleDAO {
    void addRole(Role r);

    void deleteRole(Role r);

    void changeRoleName(Role r);

    List<Role> getListOfRoles();

    int getRoleId(String name);

    String getRoleName(int id);
}
