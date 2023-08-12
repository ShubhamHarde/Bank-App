import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HDFCAccount ShubhamAcc=new HDFCAccount("Shubham",5000,"Shubham123");

        System.out.println(ShubhamAcc);

        //fetch balance
        System.out.println(ShubhamAcc.fetchBalance("wrongPassword"));
        System.out.println(ShubhamAcc.fetchBalance("Shubham123"));

        //add money
        System.out.println(ShubhamAcc.addMoney(3000));

        //withdraw money
        System.out.println(ShubhamAcc.withdrawMoney(10000,"Shubham123"));//incorrect amount
        System.out.println(ShubhamAcc.withdrawMoney(4000,"random"));//wrong password
        System.out.println(ShubhamAcc.withdrawMoney(4000,"Shubham123"));

        //change password
        System.out.println(ShubhamAcc.changePassword("random","shubham123"));
        System.out.println(ShubhamAcc.changePassword("Shubham123","shuham123"));

        //calculate interest
        System.out.println(ShubhamAcc.calculateInterest(5));
    }
}