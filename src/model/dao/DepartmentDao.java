package model.dao;

import java.util.List;
import model.entities.Department;

public interface DepartmentDao {

    static void insert(Department obj);

    static void update(Department obj);

    static void deleteById(int id);

    Department findById(int id);

    List<Department> findAll();

}
