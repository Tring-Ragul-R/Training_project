
import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidInput extends Exception {

    private String exceptionName;

    public InvalidInput(String exname) {
        this.exceptionName = exname;
    }

    public String getExceptionName() {
        return exceptionName;
    }
}

public class Main {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoImplement();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Add Employee\n2. Get Employee by ID\n3. Update Employee\n4. Delete Employee\n5. List All Employees\n6.PaySlip by Designation\n 7. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Employee ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Designation: ");
                        String designation = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter Hire Date -> format (dd-MM-yyyy): ");
                        String hireDate = scanner.nextLine();

                        Employee newEmployee = new Employee(id, name, designation, salary, hireDate);
                        employeeDao.addEmployee(newEmployee);
                    } catch (Exception e) {
                        System.out.println("Enter proper Details");
                    }
                    break;

                case 2:
                    System.out.print("Enter Id to fetch: ");
                    Employee fetchedEmployee = employeeDao.getEmployeeById(scanner.nextInt());
                    if (fetchedEmployee != null) {
                        System.out.println(fetchedEmployee);
                    } else {
                        try {
                            throw new InvalidInput("Employee not found.");
                        } catch (InvalidInput e) {
                            e.getExceptionName();
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter ID to update: ");
                    Employee oldEmployee = employeeDao.updateEmployeeById(scanner.nextInt());
                    if (oldEmployee == null) {
                        try {
                            throw new InvalidInput("Employee not found.");
                        } catch (InvalidInput e) {
                            e.getExceptionName();
                        }
                    } else {
                        try {
                            System.out.println("Enter Updated Id");
                            oldEmployee.setId(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Enter Updated Name: ");
                            oldEmployee.setName(scanner.nextLine());
                            System.out.print("Enter Updated Designation: ");
                            oldEmployee.setDesignation(scanner.nextLine());
                            System.out.print("Enter Updated Salary: ");
                            oldEmployee.setSalary(scanner.nextDouble());
                            scanner.nextLine();
                            System.out.print("Enter Updated Hire Date -> format (dd-MM-yyyy): ");
                            oldEmployee.setHireDate(scanner.nextLine());
                            System.out.println("---------------------- /n Updated successfully");
                        } catch (Exception e) {
                            System.out.println("Enter proper Details");
                        }
                    }
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    employeeDao.deleteEmployee(deleteId);
                    break;

                case 5:
                    employeeDao.listAllEmployees();
                    break;

                case 6:
                    System.out.println("Enter Employee Designation");
                    employeeDao.displaySalarySlipByDesignation(scanner.nextLine());
                    break;
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
