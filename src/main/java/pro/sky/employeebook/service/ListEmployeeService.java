package pro.sky.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employeebook.model.Employee;
import pro.sky.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.employeebook.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ListEmployeeService implements EmployeeService {
    private final List<Employee> employeeList;

    public ListEmployeeService() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee " + firstName + " " + lastName + " Has Already Been Added");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Employee " + firstName + " " + lastName + " Not Found");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Employee " + firstName + " " + lastName + " Not Found");
    }

    public Collection<Employee> printEmployees() {
//        return new ArrayList<>(employeeList);
        return Collections.unmodifiableList(employeeList);
    }
}
