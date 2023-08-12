import java.util.UUID;

public class HDFCAccount implements BankAccInterface{
    private String name;

    private String accountNo;

    private double balance;

    private String password;

    final double rateOfInterest=7.1;

    final String IFSCCode="HDFC00321";

    //default constructor
    public HDFCAccount() {
    }

    //parameterised constructor
    public HDFCAccount(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.accountNo= String.valueOf(UUID.randomUUID());
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Your Balance is: "+ this.balance;
        }
        return "Incorrect Password!!";
    }

    @Override
    public String addMoney(double amount) {
        this.balance+=amount;
        return "Amount Added Successfully. New Balance is: "+ this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)){
            if (this.balance < amount){
                return "Insufficient Balance!";
            }
            this.balance-=amount;
            return "Amount deducted Successfully. New Balance: "+ this.balance;
        }
        return "Incorrect Password!!";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            this.password=newPassword;
            return "Password Changed Successfully";
        }

        return "Incorrect Original Password";
    }

    @Override
    public String calculateInterest(int year) {

        return ("Interest of "+year+" years on current balance will be "+(this.balance*this.rateOfInterest*year)/100);
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
