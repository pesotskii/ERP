package erp.DAO;

import erp.entity.Department;

import java.util.List;

public interface DepartmentDAO {
    void addDepartment(Department dep);

    void changeDepartmentName(Department dep, String new_name);

    void deleteDepartment(Department dep);

    Department getDepartmentById(int id);

    List<Department> getAllDepartments();
}
