import java.util.Scanner;

public class SimpleBankingApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;
        boolean running = true;

        System.out.println("Welcome to Simple Banking Application\n");

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.printf("Successfully deposited $%.2f.\n\n", depositAmount);
                    } else {
                        System.out.println("Invalid deposit amount.\n");
                    }
                }
                case 2 -> {
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.printf("Successfully withdrew $%.2f.\n\n", withdrawAmount);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance.\n");
                    } else {
                        System.out.println("Invalid withdrawal amount.\n");
                    }
                }
                case 3 -> {
                    System.out.printf("Your current balance is $%.2f.\n\n", balance);
                }
                case 4 -> {
                    System.out.println("Exiting the program. Thank you for using Simple Banking Application!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.\n");
            }
        }

        scanner.close();
    }
}
