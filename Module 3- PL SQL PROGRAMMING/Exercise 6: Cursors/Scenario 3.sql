DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT loan_id, interest_rate, loan_type 
        FROM loans
        FOR UPDATE;
BEGIN
    FOR rec IN UpdateLoanInterestRates LOOP
        IF rec.loan_type = 'Home' THEN
            UPDATE loans
            SET interest_rate = interest_rate - 0.5
            WHERE CURRENT OF UpdateLoanInterestRates;
        ELIF rec.loan_type = 'Auto' THEN
            UPDATE loans
            SET interest_rate = interest_rate + 0.25
            WHERE CURRENT OF UpdateLoanInterestRates;
        END IF;
    END LOOP;
    COMMIT;
END;
