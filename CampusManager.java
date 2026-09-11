package campustracker;

import java.util.ArrayList;

@ProjectInfo(
        author = "CampusTrack Team",
        version = "1.0",
        description = "Campus student and task management system"
)
public class CampusManager implements Reportable {

    private ArrayList<Student> students;
    private ArrayList<Task> tasks;

    public CampusManager() {
        students = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) throws AppException {

        if (student == null) {
            throw new AppException("Student cannot be null.");
        }

        if (findStudentById(student.getId()) != null) {
            throw new AppException("Student with this ID already exists.");
        }

        students.add(student);
    }

    // Add task
    public void addTask(Task task) throws AppException {

        if (task == null) {
            throw new AppException("Task cannot be null.");
        }

        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new AppException("Task title cannot be empty.");
        }

        if (findTaskByTitle(task.getTitle()) != null) {
            throw new AppException("Task with this title already exists.");
        }

        tasks.add(task);
    }

    // Display all students
    public void displayStudents() {

        System.out.println("===== ALL STUDENTS =====");

        for (Student student : students) {
            student.displayInfo();
            System.out.println();
        }
    }

    // Display all tasks
    public void displayTasks() {

        System.out.println("===== ALL TASKS =====");

        for (Task task : tasks) {
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Deadline: " + task.getDeadline());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println();
        }
    }

    // Find student by ID
    public Student findStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Find task by title
    public Task findTaskByTitle(String title) {

        for (Task task : tasks) {

            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }

        return null;
    }

    // Generate report
    @Override
    public void generateReport() {

        int completedTasks = 0;

        for (Task task : tasks) {

            if (task.isCompleted()) {
                completedTasks++;
            }
        }

        System.out.println("===== CAMPUSTRACK REPORT =====");
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Tasks: " + tasks.size());
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Pending Tasks: " + (tasks.size() - completedTasks));
    }
}