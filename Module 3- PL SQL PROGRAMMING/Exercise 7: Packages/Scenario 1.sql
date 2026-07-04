CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddNewCustomer(p_id IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER);
    PROCEDURE UpdateCustomerDetails(p_id IN NUMBER, p_new_name IN VARCHAR2);
    FUNCTION GetCustomerBalance(p_id IN NUMBER) RETURN NUMBER;
END CustomerManagement;
