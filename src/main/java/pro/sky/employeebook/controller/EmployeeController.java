package pro.sky.employeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeebook.model.Employee;
import pro.sky.employeebook.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String printEmployees() {
        return service.printEmployees();
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName
    ) {
        return service.addEmployee(firstName, lastName);
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
}
