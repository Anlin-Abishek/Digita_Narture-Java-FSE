public class TaskTest {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTask(new Task("T001", "Database Setup", "Completed"));
        taskList.addTask(new Task("T002", "API Integration", "In Progress"));
        taskList.addTask(new Task("T003", "UI Code Review", "Pending"));

        System.out.println("--- All Tasks ---");
        taskList.traverseTasks();

        System.out.println("\n--- Searching for T002 ---");
        System.out.println(taskList.searchTask("T002"));

        System.out.println("\n--- Deleting T002 ---");
        taskList.deleteTask("T002");
        taskList.traverseTasks();
    }
}
