package pro.sky.employeebook.service;

import pro.sky.employeebook.model.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(int departmentId);

    Employee getEmployeeWithMinSalary(int departmentId);

    Collection<Employee> getAllEmployeesByDepartment(int departmentId);

    Collection<Employee> getAllEmployees();
}
