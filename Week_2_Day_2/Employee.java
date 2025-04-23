public class Employee {
	private int id;
	private String name;
	private String desc;
	private long mobno;
	private double sal;

	public Employee(int id, String name, String desc, long mobno, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.mobno = mobno;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

}