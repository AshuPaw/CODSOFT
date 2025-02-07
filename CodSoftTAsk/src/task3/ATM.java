package task3;

import java.util.Scanner;

class ATM {
	private BankAccount account;

	public ATM(BankAccount account) {
		this.account = account;
	}

	public void displayMenu() {
		System.out.println("\nATM Menu:");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
		System.out.print("Choose an option: ");
	}

	public void checkBalance() {
		System.out.println("Your current balance is: Rs." + account.getBalance());
	}

	public void deposit(double amount) {
		account.deposit(amount);
	}

	public void withdraw(double amount) {
		account.withdraw(amount);
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			displayMenu();
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				checkBalance();
				break;
			case 2:
				System.out.print("Enter amount to deposit: ");
				double depositAmount = scanner.nextDouble();
				deposit(depositAmount);
				break;
			case 3:
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = scanner.nextDouble();
				withdraw(withdrawAmount);
				break;
			case 4:
				System.out.println("Exiting...");
				running = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
		scanner.close();
	}
}
