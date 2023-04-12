package pro.sky.employeebook.service;

import pro.sky.employeebook.model.Employee;

public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(int departmentId);
}
