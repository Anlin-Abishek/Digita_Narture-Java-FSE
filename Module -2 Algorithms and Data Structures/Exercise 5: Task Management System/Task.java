public class Task {
    private final String taskId;
    private final String taskName;
    private final String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + taskId + '\'' +
                ", name='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
