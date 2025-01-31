interface EmployeeDao {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int id);
    Employee updateEmployeeById(int id);
    void deleteEmployee(int id);
    void listAllEmployees();
    double calculateBonus(Employee employee);
    void displaySalarySlipById(int id);
    void filterByDesignation(String designation);

}