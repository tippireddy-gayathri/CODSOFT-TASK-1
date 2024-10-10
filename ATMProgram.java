class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }
}
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        boolean success = account.withdraw(amount);
        if (success) {
            System.out.println("Please take your cash.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processChoice(int choice, double amount) {
        switch (choice) {
            case 1:
                withdraw(amount);
                break;
            case 2:
                deposit(amount);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
public class ATMProgram {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Create a bank account with an initial balance
        ATM atm = new ATM(account);

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;
        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            double amount = 0;
            if (choice == 1 || choice == 2) {
                System.out.print("Enter the amount: ");
                amount = scanner.nextDouble();
            }

            atm.processChoice(choice, amount);
        } while (choice != 4);

        scanner.close();
    }
}