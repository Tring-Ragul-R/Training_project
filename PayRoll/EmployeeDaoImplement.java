
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;

class EmployeeNotFound extends Exception {

    String exceptionName;

    public EmployeeNotFound(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionName() {
        return exceptionName;
    }

}

class EmployeeDaoImplement implements EmployeeDao {

    HashMap<Integer, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        try {
            if (employees.containsKey(employee.getId())) {
                throw new Exception("Employee is Already Exist");
            }
            employees.put(employee.getId(), employee);
            System.out.println("Employee added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        try {
            if (employees == null) {
                throw new NullPointerException("List is Empty");
            }
        } catch (NullPointerException e) {
            System.out.println("-------------------------");
            System.out.println(e.getMessage());
            System.out.println("-------------------------");

        }

        if (employees.containsKey(id)) {
            return employees.get(id);
        } else {
            return null;
        }
        // for (Integer emp : employees.keySet()) {
        //     if (emp == id) {
        //         return employees.get(emp);
        //     }
        // }
        // return null;
    }

    @Override
    public Employee updateEmployeeById(int id) {
        try {
            if (employees == null) {
                throw new NullPointerException("List is Empty");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        if (employees.containsKey(id)) {
            return employees.get(id);
        } else {
            return null;
        }
        // for (Integer emp : employees.keySet()) {
        //     if (emp == id) {
        //         return employees.get(emp);
        //     }
        // }
        // return null;
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            if (employees == null) {
                throw new NullPointerException("List is Empty");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (!employees.containsKey(id)) {
                throw new EmployeeNotFound("Employee not found");
            }
        } catch (EmployeeNotFound e) {
            System.out.println("-------------------------");
            System.out.println(e.getExceptionName());
            System.out.println("-------------------------");
        }

        if (employees.containsKey(id)) {
            employees.remove(id);
            System.out.println("-------------------------");
            System.out.println("Employee Removed..!");
            System.out.println("-------------------------");
        }

        // for (Integer emp : employees.keySet()) {
        //     if (emp == id) {
        //         employees.remove(emp);
        //         System.out.println("Employee Removed..!");
        //     }
        // }
    }

    @Override
    public void listAllEmployees() {
        try {
            if (employees == null) {
                throw new NullPointerException("List is Empty");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        for (Integer emp : employees.keySet()) {
            displaySalarySlip(employees.get(emp));
        }
    }

    public int calculateExperience(Employee employee) {
        try {
            int hireYear = Integer.parseInt(employee.getHireDate().split("-")[2]);
            return 2025 - hireYear;
        } catch (NumberFormatException e) {
            System.out.println("Error in hire date: ");
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
        bonus = bonus + employee.getSalary() * (0.005 * experience);
        return bonus;
    }

    public void displaySalarySlip(Employee employee) {

        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Designation: " + employee.getDesignation());
        System.out.println("Hire Date: " + employee.getHireDate());
        System.out.println("Base Salary: " + employee.getSalary());
        System.out.println("Bonus: " + calculateBonus(employee));
        System.out.println("Total Salary: " + (employee.getSalary() + calculateBonus(employee)));
        System.out.println("----------------------------");
    }

    @Override
    public void displaySalarySlipById(int id) {
        if (!employees.containsKey(id)) {
            try {
                throw new InvalidInput("Employee not found.");
            } catch (InvalidInput e) {
                System.out.println("----------------------------");
                System.out.println(e.getExceptionName());
                System.out.println("----------------------------");
            }
        }

        // for (Integer employee : employees.keySet()) {
        //     if (employee == id) {
        //         displaySalarySlip(employees.get(id));
        //     }
        // }
    }

    //List<Employee> list = new ArrayList<>();
    @Override
    public void filterByDesignation(String designation) {
        boolean flag = true;
        for (Integer employee : employees.keySet()) {
            if (employees.get(employee).getDesignation().equalsIgnoreCase(designation)) {
                flag = false;
                System.out.println(employees.get(employee));
            }
        }
        if (flag) {
            try {
                throw new EmployeeNotFound("Employee not found for " + designation + " Designation");
            } catch (EmployeeNotFound e) {
                System.out.println(e.getExceptionName());
            }
        }
    }

}
