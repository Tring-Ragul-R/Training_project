
public class Runner {

    EmployeeDto dto = new EmployeeDto();

    public Employee add() {
        System.out.print("Enter Employee ID : ");
        int id = dto.insertId();
        System.out.print("Enter Employee Name : ");
        String name = dto.insertName();
        System.out.print("Enter Employee designation : ");
        String designation = dto.insertDesignation();
        System.out.print("Enter Employee Salary : ");
        double salary = dto.insertSalary();
        System.out.print("Enter Date (dd/MM/yyyy) : ");
        String hireDate = dto.insertDate();
        return new Employee(id, name, designation, salary, hireDate);
    }
    public int getId(){
        System.out.print("Enter Employee ID :");
        int id = dto.insertId();
        return id;
    }
    public void update(Employee employee){
        System.out.print("Enter updated Name : ");
        employee.setName(dto.insertName());
        System.out.print("Enter updated Designation : ");
        employee.setDesignation(dto.insertDesignation());
        System.out.print("Enter updated Salary : ");
        employee.setSalary(dto.insertSalary());
        System.out.print("Enter updated Date (dd/MM/yyyy) : ");

        System.out.println("Updated successfully");
    }
    public String getDesignation(){
        System.out.println("Enter Employee Designation :");
        String designation = dto.insertDesignation();
        return designation;
    }

}
