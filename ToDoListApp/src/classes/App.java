package classes;

import java.util.Scanner;

public class App {
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ようこそう！この日本語をよめるか、あなたは天才です。");
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("一. Add a new task");
            System.out.println("二. View all tasks");
            System.out.println("三. Mark a task as completed");
            System.out.println("四. Exit");
            System.out.print("えらんでください: ");

            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewTask(scanner);
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                    completeTask(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the app. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addNewTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine();

        System.out.print("Enter task priority (Low, Medium, High): ");
        String priority = scanner.nextLine();

        Task task = new Task(description, deadline, priority);
        taskManager.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void completeTask(Scanner scanner) {
        System.out.print("Enter task ID to mark as completed: ");
        int taskId = scanner.nextInt();
        if (taskManager.markTaskAsCompleted(taskId)) {
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }
}