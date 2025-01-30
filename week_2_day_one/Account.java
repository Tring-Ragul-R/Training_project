public class Account {
    private String name;
    private int accountNumber;
    private double balance;
    
    public Account(String name,int accountNumber,double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public void setName(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}