import java.util.UUID;

public class SBIAccount implements BankAccount{
    private String name;
    private String accountNo;
    private String password;
    private double balance;

    final double average_minimum_balance=3000;
    final double rateOfInterest=7.8;
    final String IFSCCode="SBI3457bc01";

    public SBIAccount(){
    }

    public SBIAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo=String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public double getAverage_minimum_balance() {
        return average_minimum_balance;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Your Balance is: "+this.balance;
        }
        return "Invalid Password!!!";
    }

    @Override
    public String addMoney(double amount) {
        this.balance+=amount;
        return "Amount added successfully.Your balance is: "+this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)){
            if((this.balance-amount)>=this.average_minimum_balance){
                this.balance-=amount;
                return "You withdraw Rs: "+amount+". Your current balance is :"+this.balance;
            }
            return "You must have to maintain rs "+average_minimum_balance+".According to our bank policy";
        }
        return "Invalid Password!!!";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            this.password=newPassword;
            return "Password Change Succefully";
        }
        return "Invalid Password!!!";
    }

    @Override
    public double calculateInterest(int NumberOfyears) {
        return ((this.balance*NumberOfyears*this.rateOfInterest)/100.0);
    }

    @Override
    public String toString() {
        return "SBIAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", average_minimum_balance=" + average_minimum_balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
