package pro.sky.employeebook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeebook.domain.Employee;
import pro.sky.employeebook.services.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String printEmployees() {
        return employeeService.printEmployees();
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName
    ) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName
    ) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName
    ) {

        return employeeService.findEmployee(firstName, lastName);
    }
}
