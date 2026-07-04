CREATE OR REPLACE PACKAGE AccountOperations IS
    PROCEDURE OpenAccount(p_acc_id IN NUMBER, p_cust_id IN NUMBER, p_type IN VARCHAR2, p_initial_balance IN NUMBER);
    PROCEDURE CloseAccount(p_acc_id IN NUMBER);
    FUNCTION GetTotalCustomerBalance(p_cust_id IN NUMBER) RETURN NUMBER;
END AccountOperations;

CREATE OR REPLACE PACKAGE BODY AccountOperations IS
    PROCEDURE OpenAccount(p_acc_id IN NUMBER, p_cust_id IN NUMBER, p_type IN VARCHAR2, p_initial_balance IN NUMBER) IS
    BEGIN
        INSERT INTO accounts (account_id, customer_id, account_type, balance)
        VALUES (p_acc_id, p_cust_id, p_type, p_initial_balance);
        COMMIT;
    END OpenAccount;

    PROCEDURE CloseAccount(p_acc_id IN NUMBER) IS
    BEGIN
        DELETE FROM accounts WHERE account_id = p_acc_id;
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalCustomerBalance(p_cust_id IN NUMBER) RETURN NUMBER IS
        v_total_balance NUMBER;
    BEGIN
        SELECT NVL(SUM(balance), 0) INTO v_total_balance
        FROM accounts
        WHERE customer_id = p_cust_id;
        
        RETURN v_total_balance;
    END GetTotalCustomerBalance;
END AccountOperations;
