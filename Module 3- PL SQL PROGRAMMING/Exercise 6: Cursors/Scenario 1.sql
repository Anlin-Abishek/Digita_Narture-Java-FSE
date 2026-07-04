DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT account_id, transaction_id, amount, transaction_type, transaction_date
        FROM transactions
        WHERE EXTRACT(MONTH FROM transaction_date) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM transaction_date) = EXTRACT(YEAR FROM SYSDATE);
          
    v_rec GenerateMonthlyStatements%ROWTYPE;
BEGIN
    OPEN GenerateMonthlyStatements;
    LOOP
        FETCH GenerateMonthlyStatements INTO v_rec;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_rec.account_id || 
                             ' | Trans ID: ' || v_rec.transaction_id || 
                             ' | Type: ' || v_rec.transaction_type || 
                             ' | Amount: $' || v_rec.amount);
    END LOOP;
    CLOSE GenerateMonthlyStatements;
END;
