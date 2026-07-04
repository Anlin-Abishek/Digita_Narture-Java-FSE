CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.transaction_type = 'Deposit' AND :NEW.amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Invalid Transaction: Deposits must be greater than zero.');
    END IF;

    IF :NEW.transaction_type = 'Withdrawal' THEN
        SELECT balance INTO v_balance FROM accounts WHERE account_id = :NEW.account_id;
        
        IF :NEW.amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20002, 'Invalid Transaction: Withdrawal amount exceeds current account balance.');
        END IF;
    END IF;
END;
