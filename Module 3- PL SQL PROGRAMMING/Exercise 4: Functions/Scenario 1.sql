CREATE OR REPLACE FUNCTION CalculateAge(
    p_date_of_birth IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_date_of_birth) / 12);
    RETURN v_age;
END;
