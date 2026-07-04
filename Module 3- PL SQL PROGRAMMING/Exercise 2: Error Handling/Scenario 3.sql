CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name        IN VARCHAR2,
    p_balance     IN NUMBER
) IS
BEGIN
    INSERT INTO customers (customer_id, name, balance)
    VALUES (p_customer_id, p_name, p_balance);
    
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: A customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: Failed to register new customer. Message: ' || SQLERRM);
END;
