import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;

        while (true) {
            System.out.println("Welcome to the Banking Application!");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    balance -= withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is: " + checkBalance(balance));
                    break;
                case 4:
                    System.out.println("Thank you for using our Banking Application!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static double deposit(double amount) {
        return amount;
    }

    public static double withdraw(double amount) {
        return amount;
    }

    public static double checkBalance(double balance) {
        return balance;
    }
}