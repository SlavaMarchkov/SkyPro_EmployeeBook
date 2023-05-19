package pro.sky.employeebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pro.sky.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.employeebook.exception.EmployeeNotFoundException;
import pro.sky.employeebook.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.employeebook.constants.EmployeeConstants.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class EmployeeServiceImplTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();

        employeeService.addEmployee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT);
        employeeService.addEmployee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT);
        employeeService.addEmployee(FIRST_NAME_3, LAST_NAME_3, SALARY_3, DEPARTMENT);
    }

    @Test
    void Should_return_not_null_when_employee_added() {
        assertNotNull(employeeService.addEmployee(NEW_PERSON_NAME, NEW_PERSON_LAST_NAME, SALARY_2, DEPARTMENT));
    }

    @Test
    void Should_throw_exception_when_added_employee_exists() {
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT));
    }

    @Test
    void Should_throw_not_found_exception_when_finding_not_existing_employee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee(NAME_NOT_EXISTS, LAST_NAME_NOT_EXISTS));
    }

    @Test
    void Should_return_employee_not_null_when_finding_existing_employee() {
        Employee expected = employeeService.findEmployee(FIRST_NAME_1, LAST_NAME_1);
        assertNotNull(expected);
    }

    @Test
    void Should_throw_not_found_exception_when_removing_not_existing_employee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.removeEmployee(NAME_NOT_EXISTS, LAST_NAME_NOT_EXISTS));
    }

    @Test
    void Should_return_employee_not_null_when_removing_existing_employee() {
        Employee expected = employeeService.removeEmployee(FIRST_NAME_1, LAST_NAME_1);
        assertNotNull(expected);
    }

    @Test
    void Should_throw_not_found_exception_when_setting_salary_for_not_existing_employee() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.setSalary(NAME_NOT_EXISTS, LAST_NAME_NOT_EXISTS, SALARY_2));
    }

    @Test
    void Should_return_employee_not_null_when_setting_salary_for_existing_employee() {
        Employee expected = employeeService.setSalary(FIRST_NAME_1, LAST_NAME_1, SALARY_1);
        assertNotNull(expected);
    }

    @Test
    void Should_return_employee_with_min_salary() {
        Employee expected = employeeService.getEmployeeWithMinSalary();
        assertNotNull(expected);
    }

    @Test
    void Should_return_employee_with_max_salary() {
        Employee expected = employeeService.getEmployeeWithMaxSalary();
        assertNotNull(expected);
    }

    @Test
    void Should_calc_total_monthly_salary() {
        Number expected = employeeService.calcTotalMonthlySalary();
        assertNotNull(expected);
    }

    @Test
    void Should_return_all_employees() {
        List<Employee> expected = employeeService.getEmployees();

        List<Employee> actual = new ArrayList<>();

        actual.add(EMPLOYEE_1);
        actual.add(EMPLOYEE_2);
        actual.add(EMPLOYEE_3);

        assertEquals(expected, actual);
    }

    @Test
    void Should_print_all_employees() {
        Collection<Employee> expected = employeeService.printEmployees();

        List<Employee> actual = new ArrayList<>();

        actual.add(EMPLOYEE_1);
        actual.add(EMPLOYEE_2);
        actual.add(EMPLOYEE_3);

        assertEquals(expected, actual);
    }

    @Test
    void Should_return_all_employees_not_null() {
        List<Employee> expected = employeeService.getEmployees();
        assertNotNull(expected);
    }

}
