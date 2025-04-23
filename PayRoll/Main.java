
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runner runner = new Runner();
        EmployeeDao employeeDao = new EmployeeDaoImplement();

        while (true) {
            System.out.println("1. Add Employee\n2. Get Employee by ID\n3. Update Employee\n4. Delete Employee\n5. Display All Payslip\n6. PaySlip by Id\n7. Filter by Designation\n8. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1: {
                    Employee employee = runner.add();
                    employeeDao.addEmployee(employee);
                    break;
                }
                case 2: {
                    int id = runner.getId();
                    Employee employee = employeeDao.getEmployeeById(id);
                    System.out.println(employee);
                    break;
                }
                case 3: {
                    int id = runner.getId();
                    Employee employee = employeeDao.updateEmployeeById(id);
                    runner.update(employee);
                    break;
                }
                case 4:{
                    int id = runner.getId();
                    employeeDao.deleteEmployee(id);
                    break;
                }
                case 5:{
                    employeeDao.listAllEmployees();
                    break;
                }
                case 6:{
                    int id = runner.getId();
                    employeeDao.displaySalarySlipById(id);
                    break;
                }
                case 7:{
                    String designation = runner.getDesignation();
                    employeeDao.filterByDesignation(designation);
                    break;
                }
                case 8:{
                    System.out.println("Thank you");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
}
