
import java.util.List;
import java.util.Scanner;

class InvalidInput extends Exception {

    private String exName;

    public InvalidInput(String exname) {
        this.exName = exname;
    }

    public String getexName() {
        return exName;
    }
}

class Driver {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       // Scanner s1 = new Scanner(System.in);
        EmployeeDao e = new EmployeeDaoImpl();
        while (true) {
            System.out.println("1: Save\n2: Update\n3: Remove\n4: DisplayAllData\n5: Sort\n6: Exit");
            System.out.println("Enter the choice");
            int choice = s.nextInt();

            switch (choice) {
                case 1: {
                    try {
                        System.out.println("Enter the ID");
                        int id = s.nextInt();
                        System.out.println("Enter the Name");
                        String name = s.next();
                        System.out.println("Enter the Designation");
                        String desc = s.next();
                        System.out.println("Enter the Mobile Number");
                        long mobno = s.nextLong();
                        System.out.println("Enter the Salary");
                        double sal = s.nextDouble();
                        Employee e1 = new Employee(id, name, desc, mobno, sal);
                        e.save(e1);
                    } catch (Exception exception) {
                        System.out.println("Enter proper Details");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the ID");
                    int id1 = s.nextInt();
                    Employee e1 = e.update(id1);
                    if (e1 == null) {
                        try {
                            throw new InvalidInput("ID is Not Found");
                        } catch (InvalidInput ex) {
                            System.out.println(ex.getexName());
                        }
                    } else {
                        System.out.println("Enter Updated ID");
                        e1.setId(s.nextInt());
                        System.out.println("Enter Updated Name");
                        e1.setName(s.next());
                        System.out.println("Enter Updated Designation");
                        e1.setDesc(s.next());
                        System.out.println("Enter Updated Mobile Number");
                        e1.setMobno(s.nextLong());
                        System.out.println("Enter Updated Salary");
                        e1.setSal(s.nextDouble());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter ID");

                    Employee e1 = e.remove(s.nextInt());
                    if (e1 == null) {
                        try {
                            throw new InvalidInput("ID is Not Found");
                        } catch (InvalidInput ex) {
                            System.out.println(ex.getexName());
                        }
                    }

                    break;
                }
                case 4: {
                    List<Employee> e1 = e.displayAllData();
                    if (e1 == null) {
                        try {
                            throw new InvalidInput("Data is Empty");
                        } catch (InvalidInput ex) {
                            System.out.println(ex.getexName());
                        }

                    } else {
                        for (Employee i : e1) {
                            System.out.println("ID: " + i.getId() + " , Name: " + i.getName() + " , Designation: "
                                    + i.getDesc() + " , Mobile_Number: " + i.getMobno() + " , Salary: " + i.getSal());
                        }

                        break;
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter the choice");
                    System.out.println("1: SortById\n2: SortByName\n3: SortBySalary");
                    int val = s.nextInt();
                    switch (val) {
                        case 1: {
                            e.sort(val);
                            break;
                        }
                        case 2: {
                            e.sort(val);
                            break;
                        }
                        case 3: {
                            e.sort(val);
                            break;
                        }
                        default:
                            try {
                                throw new InvalidInput("Enter Proper Custom Sorting");
                            } catch (InvalidInput ex) {
                                System.out.println(ex.getexName());
                            }

                            break;
                    }
                    break;
                }
                case 6: {
                    System.out.println("Thank you");
                    System.exit(0);
                    break;
                }

                default:
                    try {
                        throw new InvalidInput("Invalid Input Enter Proper Choice");
                    } catch (InvalidInput ex) {
                        System.out.println(ex.getexName());
                    }
                    break;
            }
        }
    }
}
