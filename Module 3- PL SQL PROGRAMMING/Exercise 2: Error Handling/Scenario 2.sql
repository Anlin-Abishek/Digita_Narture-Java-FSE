CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage  IN NUMBER
) IS
    v_dummy NUMBER;
BEGIN
    SELECT 1 INTO v_dummy FROM employees WHERE employee_id = p_employee_id;

    UPDATE employees
    SET salary = salary + (salary * (p_percentage / 100))
    WHERE employee_id = p_employee_id;
    
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: Unexpected problem updating salary. Message: ' || SQLERRM);
END;
