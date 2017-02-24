package DAO;

import entities.Department;

import java.util.List;

public interface DepartmentDAO {
    void addDepartment(Department dep);

    void chanhgeDepartmentName(Department dep);

    void deleteDepartment(Department dep);

    Department getDerparmentById(int id);

    List<Department> getAllDepartments();
}
