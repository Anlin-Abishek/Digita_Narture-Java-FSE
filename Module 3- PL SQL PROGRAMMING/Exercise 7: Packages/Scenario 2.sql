CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(p_id IN NUMBER, p_name IN VARCHAR2, p_dept IN NUMBER, p_salary IN NUMBER);
    PROCEDURE UpdateEmployeeDetails(p_id IN NUMBER, p_new_salary IN NUMBER, p_new_dept IN NUMBER);
    FUNCTION GetAnnualSalary(p_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS
    PROCEDURE HireEmployee(p_id IN NUMBER, p_name IN VARCHAR2, p_dept IN NUMBER, p_salary IN NUMBER) IS
    BEGIN
        INSERT INTO employees (employee_id, name, department_id, salary)
        VALUES (p_id, p_name, p_dept, p_salary);
        COMMIT;
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(p_id IN NUMBER, p_new_salary IN NUMBER, p_new_dept IN NUMBER) IS
    BEGIN
        UPDATE employees
        SET salary = p_new_salary, department_id = p_new_dept
        WHERE employee_id = p_id;
        COMMIT;
    END UpdateEmployeeDetails;

    FUNCTION GetAnnualSalary(p_id IN NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT salary INTO v_salary FROM employees WHERE employee_id = p_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END GetAnnualSalary;
END EmployeeManagement;
