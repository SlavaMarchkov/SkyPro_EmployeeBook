package pro.sky.employeebook.services;

import pro.sky.employeebook.domain.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    String printEmployees();
}
