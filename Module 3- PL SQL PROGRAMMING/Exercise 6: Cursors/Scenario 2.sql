DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT account_id, balance 
        FROM accounts;
        
    v_fee CONSTANT NUMBER := 50.00;
BEGIN
    FOR rec IN ApplyAnnualFee LOOP
        UPDATE accounts
        SET balance = balance - v_fee
        WHERE account_id = rec.account_id;
    END LOOP;
    COMMIT;
END;
