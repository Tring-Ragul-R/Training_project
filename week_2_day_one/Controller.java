public class Controller extends Operations{
    Account account;
    public Controller(Account account) {
       this.account = account;

    }
    @Override
    void withdraw(double amount) {
        if(account.getBalance()-amount>0){
            account.setBalance(account.getBalance()-amount);
            System.out.println("Withdrawn Successfully ...!");
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    void deposit(double amount) {
        Double bal = account.getBalance()+amount;
        account.setBalance(bal);
        System.out.println("Deposited Successfully ...!");
    }

    @Override
    void checkBalance() {
        System.out.println("Account Balance : "+account.getBalance());
    }
    
}
