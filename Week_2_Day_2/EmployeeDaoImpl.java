import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



class SortById implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getId() - o2.getId();
	}
}
class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
}
class SortBySalary implements Comparator<Employee> {
	public int compare(Employee o1, Employee o2) {
		Double d1 = o1.getSal();
		Double d2 = o2.getSal();
		return d1.compareTo(d2);
	}
}

public class EmployeeDaoImpl implements EmployeeDao {
	private List<Employee> list = new ArrayList<>();

	@Override
	public Employee save(Employee e) {
		list.add(e);
		//System.out.println("save");
		return null;
	}

	@Override
	public Employee update(int id) {
		for (Employee employee : list) {
			if (employee != null && employee.getId() == id) {
				return employee;
			}
		}
		//System.out.println(id + " update");

		return null;
	}

	@Override
	public Employee remove(int id) {
		for (Employee employee : list) {
			if (employee != null && employee.getId() == id) {
				list.remove(employee);
				return employee;
			}
		}
		//System.out.println(id + " remove");

		return null;
	}

	@Override
	public List<Employee> displayAllData() {
		//System.out.println("displayallData");
		if(list.isEmpty())
			return null;

		return list;
	}

	@Override
	public void sort(int num) {
		if (num == 1) {
			Collections.sort(list, new SortById());
			for (Employee i : list) {
				System.out.println("ID: " + i.getId() + " , Name: " + i.getName() + " , Designation: " + i.getDesc()
						+ " , Mobile_Number: " + i.getMobno() + " , Salary: " + i.getSal());

			}

		} else if (num == 2) {
			Collections.sort(list, new SortByName());
			for (Employee i : list) {
				System.out.println("ID: " + i.getId() + " , Name: " + i.getName() + " , Designation: " + i.getDesc()
						+ " , Mobile_Number: " + i.getMobno() + " , Salary: " + i.getSal());

			}

		} else if (num == 3) {
			Collections.sort(list, new SortBySalary());
			for (Employee i : list) {
				System.out.println("ID: " + i.getId() + " , Name: " + i.getName() + " , Designation: " + i.getDesc()
						+ " , Mobile_Number: " + i.getMobno() + " , Salary: " + i.getSal());

			}
		}
	}

}
