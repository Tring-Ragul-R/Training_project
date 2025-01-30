
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("BoB", 234598, 100);
        Operations operations = new Controller(account);
        while (true) { 
            System.out.println("1. Deposit \n2. Withdrawn \n3. Check Balance \n4. Exit");
        switch(scanner.nextInt()) {
            case 1:
                {
                    System.out.println("Enter the Deposit Amount");
                    operations.deposit(scanner.nextDouble());
                }
                break;
                case 2:{
                    System.out.println("Enter the Withdrawn Amount");
                    operations.withdraw(scanner.nextDouble());
                    break;
                }
                case 3:{
                    operations.checkBalance();
                    break;
                }
                case 4:{
                    System.out.println("thank you");
                    System.exit(0);
                    break;
                }
                default:
                System.out.println("Enter valid option ");
        }
          
    }
    }   
}
