package atm;

import java.util.HashMap;
import java.util.Map;

public class AtmOpp implements AtmOppInterface {
    private ATM atm = new ATM();
    private Map<Double, String> statement = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 10 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                statement.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Please enter the amount in multipal of 10!");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
        statement.put(depositAmount, " Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully!");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();

    }

    @Override
    public void viewMiniStatement() {
        for (Map.Entry<Double, String> m : statement.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }
    }
}