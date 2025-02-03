
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

enum Designation {
    manager, developer, tester, intern, clerk
}

public class EmployeeDto {

    Scanner scanner = new Scanner(System.in);

    public int insertId() {
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id > 0) {
                return id;
            } else {
                System.out.println("Invalid input.id should be positive");
                return insertId();
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid Input. Enter a Number");
            scanner.next();
            return insertId();
        }

    }

    public String insertName() {
        String name = scanner.nextLine();
        String validate = "[A-Za-z ]+";
        if (name.matches(validate)) {
            return name.trim();
        } else {
            try {
                throw new Exception("Invalid Input. Enter Name");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return insertName();
            }

        }
    }

    public String insertDesignation() {
        Designation[] desc = Designation.values();
        String role = scanner.nextLine().trim().toLowerCase();
        boolean flag = false;
        for (Designation designation : desc) {
            if (designation.name().equals(role)) {
                flag = true;
                return role;
            }
        }
        if (!flag) {
            try {
                throw new Exception("Invalid Designation. Enter proper Designation");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return insertDesignation();
            }
        }
        return null;
    }

    public double insertSalary() {
        try {
            double salary = scanner.nextDouble();
            scanner.nextLine();

            if (salary > 0) {
                return salary;
            } else {
                System.out.println("Invalid Input. Salary should be positive.");
                return insertSalary();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input. Enter Salary.");
            scanner.nextLine();
            return insertSalary();
        }
    }

    public String insertDate() {
        String format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        while (true) {
            String date = scanner.nextLine();
            try {
                dateFormat.parse(date);
                return date;
            } catch (Exception e) {
                System.out.println("Invalid date or format. Enter Date");
            }
        }
    }

}
