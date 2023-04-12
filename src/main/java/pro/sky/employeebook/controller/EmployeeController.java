package pro.sky.employeebook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.employeebook.exception.EmployeeNotFoundException;
import pro.sky.employeebook.model.Employee;
import pro.sky.employeebook.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Employee> printEmployees() {
        return service.printEmployees();
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") int salary,
                                @RequestParam("departmentId") int departmentId
    ) {
        return service.addEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName
    ) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName
    ) {

        return service.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/max-salary")
    public Employee getEmployeeWithMaxSalary() {
        return service.getEmployeeWithMaxSalary();
    }

    @GetMapping(path = "/min-salary")
    public Employee getEmployeeWithMinSalary() {
        return service.getEmployeeWithMinSalary();
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleNotFoundException(EmployeeNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public String handleAlreadyAddedException(EmployeeAlreadyAddedException e) {
        return e.getMessage();
    }
}
