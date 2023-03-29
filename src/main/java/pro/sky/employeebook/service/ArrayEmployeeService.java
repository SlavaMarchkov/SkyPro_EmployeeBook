package pro.sky.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employeebook.model.Employee;
import pro.sky.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.employeebook.exception.EmployeeNotFoundException;
import pro.sky.employeebook.exception.EmployeeStorageIsFullException;

import java.util.Arrays;

@Service
public class ArrayEmployeeService implements EmployeeService {
    private static final int SIZE = 3;
    private final Employee[] employees;
    private int count = 0;

    public ArrayEmployeeService() {
        this.employees = new Employee[SIZE];
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (count >= employees.length) {
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firstName, lastName);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            if (employees[i] == null) {
                employees[i] = employee;
                count++;
                return employee;
            }
        }

        return null;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employee)) {
                employees[i] = null;
                count--;
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee != null && employee.equals(emp)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public String printEmployees() {
        return Arrays.toString(employees);
    }
}
