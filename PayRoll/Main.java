
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

            System.out.println("1. Add Employee\n2. Get Employee by ID\n3. Update Employee\n4. Delete Employee\n5. Display All Payslip\n6. PaySlip by Id\n7. Filter by Designation\n8. Exit");
            System.out.println("--------------------------");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("-------------------------");
                System.out.println("Invalid input. Enter a number.");
                System.out.println("-------------------------");
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
                        System.out.println("-------------------------");
                        System.out.println("Enter proper Details");
                        System.out.println("-------------------------");
                        scanner.next();
                        continue;
                    }
                    break;

                case 2:
                    System.out.print("Enter Id to fetch: ");
                    int id;
                    try {
                        id = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("-------------------------");
                        System.out.println("Invalid input. Enter a number.");
                        System.out.println("-------------------------");
                        scanner.next();
                        continue;
                    }
                    Employee fetchedEmployee = employeeDao.getEmployeeById(id);
                    if (fetchedEmployee != null) {
                        System.out.println(fetchedEmployee);
                    } else {
                        try {
                            throw new EmployeeNotFound( "Employee not found.");
                        } catch (EmployeeNotFound e) {
                            System.out.println("-------------------------");
                            System.out.println(e.getExceptionName());
                            System.out.println("-------------------------");

                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter ID to update: ");
                    int oldId;
                    try {
                        oldId = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Enter a number.");
                        scanner.next();
                        continue;
                    }
                    Employee oldEmployee = employeeDao.updateEmployeeById(oldId);
                    if (oldEmployee == null) {
                        try {
                            throw new InvalidInput("Employee not found.");
                        } catch (InvalidInput e) {
                            System.out.println("-------------------------");
                            System.out.println(e.getExceptionName());
                            System.out.println("-------------------------");
                        }
                    } else {
                        try {
                            System.out.print("Enter Updated Id");
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
                            System.out.println("-------------------------");
                            System.out.println("Updated successfully");
                            System.out.println("-------------------------");
                        } catch (Exception e) {
                            System.out.println("-------------------------");
                            System.out.println("Enter proper Details");
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId;
                    try {
                        deleteId = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Enter a number.");
                        scanner.next();
                        continue;
                    }

                    employeeDao.deleteEmployee(deleteId);
                    break;

                case 5:
                    employeeDao.listAllEmployees();
                    break;

                case 6:
                    System.out.println("Enter Employee Id");
                    employeeDao.displaySalarySlipById(scanner.nextInt());
                    break;

                case 7:
                    scanner.nextLine();
                    System.out.println("Enter Employee Designation");
                    employeeDao.filterByDesignation(scanner.nextLine());
                    break;
                case 8:
                    System.out.println("thank you");
                    scanner.close();
                    return;

                default:
                    System.out.println("--------------------------");
                    System.out.println("Invalid choice");
            }
        }
    }
}
