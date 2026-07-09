public class EmployeeManagement {
    private final Employee[] employees;
    private int count;

    public EmployeeManagement(int capacity) {
        this.employees = new Employee[capacity];
        this.count = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (count >= employees.length) {
            System.out.println("Error: System inventory capacity full.");
            return false;
        }
        employees[count] = employee;
        count++;
        return true;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(String employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            return false;
        }

        for (int i = indexToDelete; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;
        return true;
    }
}
