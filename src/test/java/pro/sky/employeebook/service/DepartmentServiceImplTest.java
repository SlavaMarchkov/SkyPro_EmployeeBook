package pro.sky.employeebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employeebook.exception.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.employeebook.constants.EmployeeConstants.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private ValidatorService validatorService;
    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(validatorService);
        out = new DepartmentServiceImpl(employeeService);

        employeeService.addEmployee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1);
        employeeService.addEmployee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_2);
        employeeService.addEmployee(FIRST_NAME_3, LAST_NAME_3, SALARY_3, DEPARTMENT_3);
    }

    @Test
    void Should_return_employee_service_not_null() {
        assertNotNull(employeeService);
    }

    @Test
    void Should_return_collection_when_get_all_employees_called() {
        assertNotNull(out.getAllEmployees());
    }

    @Test
    void Should_return_all_employees_by_department() {
        assertNotNull(out.getAllEmployeesByDepartment(GOOD_DEPARTMENT_ID));
    }

    @Test
    void Should_return_empty_for_employees_department_not_exists() {
        assertTrue(out.getAllEmployeesByDepartment(BAD_DEPARTMENT_ID).isEmpty());
    }

    @Test
    void Should_get_max_salary() {
        Number maxSalary = out.getMaxSalary(GOOD_DEPARTMENT_ID);
        assertEquals(SALARY_1, maxSalary);
    }

    @Test
    void Should_throw_exception_when_getting_max_salary_for_department_not_exists() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    void Should_get_min_salary() {
        Number minSalary = out.getMinSalary(GOOD_DEPARTMENT_ID);
        assertEquals(SALARY_1, minSalary);
    }

    @Test
    void Should_throw_exception_when_getting_min_salary_for_department_not_exists() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getMinSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    void Should_calc_total_salary_by_department() {
        Number totalSalary = out.calcTotalSalaryByDepartment(GOOD_DEPARTMENT_ID);
        assertEquals(TOTAL_SALARY_GOOD_DEPARTMENT, totalSalary);
    }

}
