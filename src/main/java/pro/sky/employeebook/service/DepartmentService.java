package pro.sky.employeebook.service;

import pro.sky.employeebook.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Number getMaxSalary(int departmentId);

    Number getMinSalary(int departmentId);

    Collection<Employee> getAllEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> getAllEmployees();

    Number calcTotalSalaryByDepartment(int departmentId);

}
