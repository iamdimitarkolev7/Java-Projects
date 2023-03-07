package atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AtmOppInterface operations = new AtmOpp();
        int userAtmNumber = 12345;
        int userPin = 1234;

        System.out.println("Enter Atm number: ");
        int atmNumber = scanner.nextInt();
        System.out.println("Enter PIN: ");
        int pin = scanner.nextInt();

        if (userAtmNumber == atmNumber && userPin == pin) {
            while (true) {
                System.out.println("1. View Available Balance\n2. Withdraw Amount\n3. Deposit Amount\n4. View Ministatement\n5. Exit");
                System.out.println("Enter Choice: ");
                int opperationNumber = scanner.nextInt();

                switch (opperationNumber) {
                    case 1: {
                        operations.viewBalance();
                    }
                    break;
                    case 2: {
                        System.out.println("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        operations.withdrawAmount(withdrawAmount);
                    }
                    break;
                    case 3: {
                        System.out.println("Enter Amount to Deposit: ");
                        double depositAmount = scanner.nextDouble();
                        operations.depositAmount(depositAmount);
                    }
                    break;
                    case 4: {
                        operations.viewMiniStatement();
                    }
                    break;
                    case 5: {
                        System.out.println("Thank you for using ATM Machine!!");
                        System.exit(0);
                    }
                    break;
                    default: {
                        System.out.println("Please enter correct choice");
                    }
                    break;
                }
            }
        }
        else {
            System.out.println("Incorrect Atm Number or pin!");
            System.exit(0);
        }
    }
}