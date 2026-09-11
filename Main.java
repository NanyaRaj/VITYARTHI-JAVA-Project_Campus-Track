package campustracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CampusManager manager = new CampusManager();

        // Custom Annotation
        ProjectInfo info = CampusManager.class.getAnnotation(ProjectInfo.class);

        System.out.println("===== PROJECT INFORMATION =====");
        System.out.println("Author: " + info.author());
        System.out.println("Version: " + info.version());
        System.out.println("Description: " + info.description());
        System.out.println();

        // Static method
        Task.showDefaultStatus();

        // Sample students
        Student student1 = new Student(
                "Nanya",
                101,
                "CSE AI & ML",
                3
        );

        Student student2 = new Student(
                "Rahul",
                102,
                "CSE AI & ML",
                3
        );

        // Adding students with exception handling
        try {
            manager.addStudent(student1);
            manager.addStudent(student2);
        } catch (AppException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Sample tasks
        Task task1 = new Task(
                "Complete Java Project",
                "Complete CampusTrack Java project",
                "15-09-2026"
        );

        // Constructor overloading
        Task task2 = new Task(
                "Complete DSA Assignment",
                "20-09-2026"
        );

        // Adding tasks with exception handling
        try {
            manager.addTask(task1);
            manager.addTask(task2);
        } catch (AppException e) {
            System.out.println("Error: " + e.getMessage());
        }

        int choice;

        do {

            System.out.println("\n===== CAMPUSTRACK =====");
            System.out.println("1. Display Students");
            System.out.println("2. Display Tasks");
            System.out.println("3. Search Student");
            System.out.println("4. Search Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. Generate Report");
            System.out.println("7. Start Background Reporter");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        manager.displayStudents();
                        break;

                    case 2:

                        manager.displayTasks();
                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");

                        int id = sc.nextInt();
                        sc.nextLine();

                        Student foundStudent = manager.findStudentById(id);

                        if (foundStudent != null) {
                            foundStudent.displayInfo();
                        } else {
                            System.out.println("Student not found.");
                        }

                        break;

                    case 4:

                        System.out.print("Enter Task Title: ");

                        String title = sc.nextLine();

                        Task foundTask = manager.findTaskByTitle(title);

                        if (foundTask != null) {

                            // Method overloading
                            foundTask.displayInfo(true);

                        } else {

                            System.out.println("Task not found.");
                        }

                        break;

                    case 5:

                        System.out.print("Enter Task Title: ");

                        String taskTitle = sc.nextLine();

                        Task task = manager.findTaskByTitle(taskTitle);

                        if (task != null) {

                            task.setCompleted(true);

                            System.out.println("Task marked as completed!");

                        } else {

                            System.out.println("Task not found.");
                        }

                        break;

                    case 6:

                        manager.generateReport();
                        break;

                    case 7:

                        BackgroundReporter reporter1 = new BackgroundReporter();
                        BackgroundReporter reporter2 = new BackgroundReporter();

                        reporter1.start();
                        reporter2.start();

                        break;

                    case 8:

                        System.out.println("Thank you for using CampusTrack!");
                        break;

                    default:

                        System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {

                System.out.println("Invalid input. Please enter a valid value.");

                sc.nextLine();

                choice = 0;
            }

        } while (choice != 8);

        sc.close();
    }
}