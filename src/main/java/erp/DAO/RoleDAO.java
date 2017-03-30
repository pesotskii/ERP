package erp.DAO;

import erp.entities.Role;

import java.util.List;

public interface RoleDAO {
    void addRole(Role r);

    void deleteRole(Role r);

    void changeRoleName(Role r, String new_name);

    List<Role> getListOfRoles();

    Role getRoleByName(String name);

    Role getRole(int id);
}
