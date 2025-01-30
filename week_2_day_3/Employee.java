
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Employee {

    int id;
    String name;
    long mobileNumber;

    public Employee(int id, String name, long mobileNumber) {
        super();
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + "]";
    }

    public static void main(String[] args) {
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();

        Employee employee1 = new Employee(101, "smith", 98765431);
        Employee employee2 = new Employee(102, "Allen", 98765678);
        Employee employee3 = new Employee(103, "James", 34567876);
        Employee employee4 = new Employee(104, "King", 4567898);

        //Add
        map.put(employee1.id, employee1);
        map.put(employee2.id, employee2);
        map.put(employee3.id, employee3);
        map.put(employee4.id, employee4);

        // keyset retrieve of key
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.println("key is " + key + "and value is " + map.get(key));
        }

        //entryset retrieve of key,value
        Set<Map.Entry<Integer, Employee>> entry = map.entrySet();

        for (Map.Entry<Integer, Employee> kv : entry) {
            System.out.println(kv);

        }

        //Remove
        map.remove(employee1.id);

        //containsKey(result ->true/false)
        System.out.println(map.containsKey(employee1.id));

        //containsValue(Result -> true/false)
        System.out.println(map.containsValue(employee2));

        //display all the data
        System.out.println( map.values());

    
    }
}
