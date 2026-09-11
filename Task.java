package campustracker;

public class Task {

    private String title;
    private String description;
    private String deadline;
    private boolean completed;

    // final constant
    public static final String DEFAULT_STATUS = "Pending";

    // Constructor 1
    public Task(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = false;
    }

    // Constructor 2 - Constructor Overloading
    public Task(String title, String deadline) {
        this.title = title;
        this.description = "No description provided";
        this.deadline = deadline;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Method 1
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Deadline: " + deadline);
        System.out.println("Completed: " + completed);
    }

    // Method 2 - Method Overloading
    public void displayInfo(boolean showStatus) {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Deadline: " + deadline);

        if (showStatus) {
            System.out.println("Completed: " + completed);
        }
    }

    // Static method
    public static void showDefaultStatus() {
        System.out.println("Default Task Status: " + DEFAULT_STATUS);
    }
}