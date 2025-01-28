import java.util.List;


public interface EmployeeDao {

	Employee save(Employee e);

	Employee update(int id);

	Employee remove(int id);

	List<Employee> displayAllData();

	void sort(int num);

}