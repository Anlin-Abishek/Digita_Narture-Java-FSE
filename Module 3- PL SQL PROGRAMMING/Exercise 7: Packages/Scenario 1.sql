CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddNewCustomer(p_id IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER);
    PROCEDURE UpdateCustomerDetails(p_id IN NUMBER, p_new_name IN VARCHAR2);
    FUNCTION GetCustomerBalance(p_id IN NUMBER) RETURN NUMBER;
END CustomerManagement;


CREATE OR REPLACE PACKAGE BODY CustomerManagement IS
    PROCEDURE AddNewCustomer(p_id IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER) IS
    BEGIN
        INSERT INTO customers (customer_id, name, balance, LastModified)
        VALUES (p_id, p_name, p_balance, SYSDATE);
        COMMIT;
    END AddNewCustomer;

    PROCEDURE UpdateCustomerDetails(p_id IN NUMBER, p_new_name IN VARCHAR2) IS
    BEGIN
        UPDATE customers
        SET name = p_new_name
        WHERE customer_id = p_id;
        COMMIT;
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(p_id IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT balance INTO v_balance FROM customers WHERE customer_id = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END GetCustomerBalance;
END CustomerManagement;
