package pro.sky.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employeebook.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final List<Employee> employees;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employees = employeeService.getEmployees();
    }


    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        final Optional<Employee> employee = employees
                .stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(emp -> emp.getSalary()));

        return employee.orElseThrow(() -> new RuntimeException("Employee with max salary in department " + departmentId + " not found"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        final Optional<Employee> employee = employees
                .stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(emp -> emp.getSalary()));

        return employee.orElseThrow(() -> new RuntimeException("Employee with min salary in department " + departmentId + " not found"));
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartment(int departmentId) {
        return employees
                .stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Collection<Employee> getAllEmployees() {
        return employees
                .stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }
}
