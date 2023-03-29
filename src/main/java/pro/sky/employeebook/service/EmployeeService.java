package pro.sky.employeebook.service;

import pro.sky.employeebook.model.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    String printEmployees();
}
