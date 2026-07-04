BEGIN
    FOR rec IN (SELECT customer_id, balance FROM accounts) LOOP
        IF rec.balance > 10000 THEN
            UPDATE customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = rec.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
