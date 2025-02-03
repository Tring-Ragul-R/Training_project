interface EmployeeDao {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int id);
    Employee updateEmployeeById(int id);
    void deleteEmployee(int id);
    void listAllEmployees();
    void displaySalarySlipById(int id);
    void filterByDesignation(String designation);
}