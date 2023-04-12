package pro.sky.employeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeebook.model.Employee;
import pro.sky.employeebook.service.DepartmentService;
import pro.sky.employeebook.service.EmployeeService;

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
}
