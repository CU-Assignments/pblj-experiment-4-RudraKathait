import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Display Employee Details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManagementSystem {
    // ArrayList to store employees
    private ArrayList<Employee> employeeList = new ArrayList<>();

    // Method to add a new employee
    public void addEmployee(int id, String name, double salary) {
        Employee emp = new Employee(id, name, salary);
        employeeList.add(emp);
        System.out.println("Employee added successfully.");
    }

    // Method to update an employee's details
    public void updateEmployee(int id, String name, double salary) {
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                emp.name = name;
                emp.salary = salary;
                System.out.println("Employee details updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Method to remove an employee
    public void removeEmployee(int id) {
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                employeeList.remove(emp);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Method to search for an employee by ID
    public void searchEmployee(int id) {
        for (Employee emp : employeeList) {
            if (emp.id == id) {
                emp.display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Method to display all employees
    public void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        for (Employee emp : employeeList) {
            emp.display();
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    system.addEmployee(id, name, salary);
                    break;
                case 2: // Update Employee
                    System.out.print("Enter Employee ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Employee Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new Employee Salary: ");
                    salary = scanner.nextDouble();
                    system.updateEmployee(id, name, salary);
                    break;
                case 3: // Remove Employee
                    System.out.print("Enter Employee ID to remove: ");
                    id = scanner.nextInt();
                    system.removeEmployee(id);
                    break;
                case 4: // Search Employee
                    System.out.print("Enter Employee ID to search: ");
                    id = scanner.nextInt();
                    system.searchEmployee(id);
                    break;
                case 5: // Display All Employees
                    system.displayAllEmployees();
                    break;
                case 6: // Exit
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
