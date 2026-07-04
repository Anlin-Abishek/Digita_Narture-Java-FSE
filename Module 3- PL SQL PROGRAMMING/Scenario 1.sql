CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) IS
    v_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT balance INTO v_balance FROM accounts WHERE account_id = p_from_account;
    
    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE accounts SET balance = balance - p_amount WHERE account_id = p_from_account;
    UPDATE accounts SET balance = balance + p_amount WHERE account_id = p_to_account;
    
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transaction aborted due to insufficient funds.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: System failure encountered. Transaction rolled back. Message: ' || SQLERRM);
END;
