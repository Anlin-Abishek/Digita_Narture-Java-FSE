CREATE OR REPLACE PROCEDURE TransferFunds(
    p_source_account IN NUMBER,
    p_dest_account   IN NUMBER,
    p_amount         IN NUMBER
) IS
    v_source_balance NUMBER;
BEGIN
    SELECT balance INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_account;

    IF v_source_balance >= p_amount THEN
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_source_account;

        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_dest_account;

        COMMIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: Insufficient funds in source account.');
    END IF;
END;
