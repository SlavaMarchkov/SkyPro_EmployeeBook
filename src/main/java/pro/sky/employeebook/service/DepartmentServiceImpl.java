package pro.sky.employeebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employeebook.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        final Optional<Employee> employee = employeeService.getEmployees()
                .stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary));

        return employee.orElseThrow(() -> new RuntimeException("Employee with max salary in department " + departmentId + " not found"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        final Optional<Employee> employee = employeeService.getEmployees()
                .stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary));

        return employee.orElseThrow(() -> new RuntimeException("Employee with min salary in department " + departmentId + " not found"));
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartment(int departmentId) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
