
import java.util.ArrayList;
import java.util.List;

class EmployeeDaoImplement implements EmployeeDao {

    List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    @Override
    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public Employee updateEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }

        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        boolean flag = true;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                flag = false;
            }
        }
        if (!flag) {
            try {
                throw new InvalidInput("Employee not found.");
            } catch (InvalidInput e) {
                e.getExceptionName();
            }
        }
    }

    @Override
    public void listAllEmployees() {
        for (Employee emp : employees) {
            calculateBonus(emp);
        }
    }

    public int calculateExperience(Employee employee) {
        try {
            int hireYear = Integer.parseInt(employee.getHireDate().split("-")[2]);
            return 2025 - hireYear;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing hire date: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public double calculateBonus(Employee employee) {
        double bonus;
        switch (employee.getDesignation().toLowerCase()) {
            case "manager":
                bonus = employee.getSalary() * 0.20;
                break;
            case "tech lead":
                bonus = employee.getSalary() * 0.18;
                break;
            case "software developer":
                bonus = employee.getSalary() * 0.15;
                break;
            case "intern":
                bonus = employee.getSalary() * 0.10;
                break;
            default:
                bonus = employee.getSalary() * 0.05;
                break;
        }
        int experience = calculateExperience(employee);
        bonus += employee.getSalary() * (0.005 * experience);
        return bonus;
    }

    public void displaySalarySlip(Employee employee) {

        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Designation: " + employee.getDesignation());
        System.out.println("Hire Date: " + employee.getHireDate());
        System.out.println("Base Salary: $" + employee.getSalary());
        System.out.println("Bonus: $" + calculateBonus(employee));
        System.out.println("Total Salary: $" + (employee.getSalary() + calculateBonus(employee)));
        System.out.println("----------------------------\n");
    }

    @Override
    public void displaySalarySlipByDesignation(String designation) {
        boolean flag = true;
        for (Employee employee : employees) {
            if (employee.getDesignation().equalsIgnoreCase(designation)) {
                displaySalarySlip(employee);
                flag = false;
            }
        }
        if (!flag) {
            try {
                throw new InvalidInput("Employee not found.");
            } catch (InvalidInput e) {
                e.getExceptionName();
            }
        }
    }
}
