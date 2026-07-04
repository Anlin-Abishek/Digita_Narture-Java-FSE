public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(5);

        em.addEmployee(new Employee("E001", "Alice", "Manager", 85000));
        em.addEmployee(new Employee("E002", "Bob", "Developer", 70000));
        em.addEmployee(new Employee("E003", "Charlie", "Designer", 65000));

        System.out.println("--- All Records ---");
        em.traverseEmployees();

        System.out.println("\n--- Searching for E002 ---");
        System.out.println(em.searchEmployee("E002"));

        System.out.println("\n--- Deleting E002 ---");
        em.deleteEmployee("E002");
        em.traverseEmployees();
    }
}
