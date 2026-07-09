public class Employee {
    private final String employeeId;
    private final String name;
    private final String position;
    private final double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=$" + salary +
                '}';
    }
}
