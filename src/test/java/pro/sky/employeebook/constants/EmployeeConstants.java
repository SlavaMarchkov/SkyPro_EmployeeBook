package pro.sky.employeebook.constants;

import pro.sky.employeebook.model.Employee;

public class EmployeeConstants {

    public static final String FIRST_NAME_1 = "Name1";
    public static final String FIRST_NAME_2 = "Name2";
    public static final String FIRST_NAME_3 = "Name3";
    public static final String NEW_PERSON_NAME = "New name";
    public static final String NAME_NOT_EXISTS = "Name not exists";

    public static final String LAST_NAME_1 = "Last name1";
    public static final String LAST_NAME_2 = "Last name2";
    public static final String LAST_NAME_3 = "Last name3";
    public static final String NEW_PERSON_LAST_NAME = "New last name";
    public static final String LAST_NAME_NOT_EXISTS = "Last name not exists";

    public static final int SALARY_1 = 45_000;
    public static final int SALARY_2 = 25_000;
    public static final int SALARY_3 = 65_000;
    public static final int TOTAL_SALARY = SALARY_1 + SALARY_2 + SALARY_3;
    public static final int TOTAL_SALARY_GOOD_DEPARTMENT = SALARY_1;

    public static final int DEPARTMENT_1 = 1;
    public static final int DEPARTMENT_2 = 2;
    public static final int DEPARTMENT_3 = 3;
    public static final int GOOD_DEPARTMENT_ID = 1;
    public static final int BAD_DEPARTMENT_ID = 5;

    public static final Employee EMPLOYEE_1 = new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1);
    public static final Employee EMPLOYEE_2 = new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_2);
    public static final Employee EMPLOYEE_3 = new Employee(FIRST_NAME_3, LAST_NAME_3, SALARY_3, DEPARTMENT_3);

}
