package pro.sky.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employeebook.model.Employee;
import pro.sky.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.employeebook.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName,
                                String lastName,
                                int salary,
                                int departmentId
    ) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee " + firstName + " " + lastName + " Has Already Been Added");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Employee " + firstName + " " + lastName + " Not Found");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Employee " + firstName + " " + lastName + " Not Found");
    }

    public Collection<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return getEmployeeWithMaxSalary(employees);
    }

    private Employee getEmployeeWithMaxSalary(List<Employee> employees) {
        final Optional<Employee> employee = employees
                .stream()
                .max(Comparator.comparingInt(emp -> emp.getSalary()));

        return employee.orElseThrow(() -> new RuntimeException("Employee with max salary not found"));
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return getEmployeeWithMinSalary(employees);
    }

    private Employee getEmployeeWithMinSalary(List<Employee> employees) {
        final Optional<Employee> employee = employees
                .stream()
                .min(Comparator.comparingInt(emp -> emp.getSalary()));

        return employee.orElseThrow(() -> new RuntimeException("Employee with min salary not found"));
    }
}
