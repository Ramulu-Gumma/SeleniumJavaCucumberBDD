package JavaTopics;


class BankAccount {
	private String accountHolder;
	private double balance;

	// Static variable (Shared across all objects)
	private static double interestRate = 5.0; // 5% Interest Rate

	public BankAccount(String accountHolder, double balance) {
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	// Static method to update interest rate
	public static void setInterestRate(double newRate) {
		interestRate = newRate;
	}

	// Static method to get interest rate
	public static double getInterestRate() {
		return interestRate;
	}

	// Method to calculate interest
	public void calculateInterest() {
		double interest = (balance * interestRate) / 100;
		System.out.println(accountHolder + "'s Interest: $" + interest);
	}
}

public class JT_014_StaticKeyword {
	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("Alice", 10000);
		BankAccount acc2 = new BankAccount("Bob", 20000);

		// Calculate interest before changing interest rate
		acc1.calculateInterest();
		acc2.calculateInterest();

		// Update static interest rate (affects all accounts)
		BankAccount.setInterestRate(6.0);

		// Calculate interest after changing interest rate
		acc1.calculateInterest();
		acc2.calculateInterest();
	}
}

