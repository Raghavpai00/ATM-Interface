import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return this.balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.checkBalance());
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;
                case "2":
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.deposit(depositAmount)) {
                        System.out.println("Deposit successful. New balance: " + bankAccount.checkBalance());
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "3":
                    System.out.println("Your balance is: " + bankAccount.checkBalance());
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class I50task3OfCodsoftInternship  {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);  // Initial balance of $1000
        ATM atm = new ATM(account);
        atm.run();
    }
}



//public class I50task3OfCodsoftInternship {
//}
