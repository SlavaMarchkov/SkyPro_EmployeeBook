package pro.sky.employeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeebook.model.Employee;
import pro.sky.employeebook.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentsController {
    private final DepartmentService service;

    public DepartmentsController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping(path = "/max-salary")
    public Employee getEmployeeWithMaxSalaryByDepartment(@RequestParam("departmentId") int departmentId) {
        return service.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee getEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") int departmentId) {
        return service.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping(path = "/all", params = "departmentId")
    public Collection<Employee> getAllEmployeesByDepartment(@RequestParam(value = "departmentId") Integer departmentId) {
        return service.getAllEmployeesByDepartment(departmentId);
    }
}
