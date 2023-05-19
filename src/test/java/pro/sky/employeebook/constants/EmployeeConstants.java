package pro.sky.employeebook.constants;

import pro.sky.employeebook.model.Employee;

import java.util.List;

public class EmployeeConstants {

    public static final String FIRST_NAME_1 = "Name1";
    public static final String FIRST_NAME_2 = "Name2";
    public static final String FIRST_NAME_3 = "Name3";
    public static final String NEW_PERSON_NAME = "New_Name";
    public static final String NAME_NOT_EXISTS = "Name_Not_Exists";

    public static final String LAST_NAME_1 = "Last_Name1";
    public static final String LAST_NAME_2 = "Last_Name2";
    public static final String LAST_NAME_3 = "Last_Name3";
    public static final String NEW_PERSON_LAST_NAME = "New_Last_Name";
    public static final String LAST_NAME_NOT_EXISTS = "Last_Name_Not_Exists";

    public static final int SALARY_1 = 45_000;
    public static final int SALARY_2 = 25_000;
    public static final int SALARY_3 = 65_000;
    public static final int DEPARTMENT = 3;

    public static final Employee EMPLOYEE_1 = new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT);
    public static final Employee EMPLOYEE_2 = new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT);
    public static final Employee EMPLOYEE_3 = new Employee(FIRST_NAME_3, LAST_NAME_3, SALARY_3, DEPARTMENT);

    public static final List<Employee> EMPLOYEE_LIST = List.of(
            EMPLOYEE_1,
            EMPLOYEE_2,
            EMPLOYEE_3
    );

}
