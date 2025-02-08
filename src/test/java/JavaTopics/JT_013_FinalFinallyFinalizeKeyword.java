package JavaTopics;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//1. final Keyword
//The final keyword is used for variables, methods, and classes to impose restrictions in Java
final class SecuritySystem { // final class cannot be inherited
	void authenticate() {
		System.out.println("User authenticated successfully.");
	}
}

class BankTransaction {
	// final constant
	private static final String BANK_NAME = "XYZ Bank";

	Connection conn = null;

	// final method to prevent overriding
	public final void calculateInterest(double amount) {
		double interest = amount * 0.05; // 5% interest rate
		System.out.println("Interest on " + amount + " is: " + interest);
	}

	// 2. finally Block
	//The finally block is used in exception handling. It always executes whether an exception occurs or not.
	public void processTransaction(double amount) {
		try {
			// Simulating database connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankDB", "user", "password");
			System.out.println("Connected to " + BANK_NAME + " database.");

			System.out.println("Processing transaction of $" + amount);
			calculateInterest(amount); // Call final method

			// Simulating transaction success
			System.out.println("Transaction successful.");
		} catch (SQLException e) {
			System.out.println("Database connection failed.");
		} finally {
			// finally ensures resource cleanup
			try {
				if (conn != null) {
					conn.close();
					System.out.println("Database connection closed.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//3. finalize() Method (Deprecated in Java 9)
	// The finalize() method was used to clean up resources before an object is garbage collected.
	// finalize method (Deprecated) - Used for cleanup before garbage collection
	@Override
	protected void finalize() {
		System.out.println("Finalize method called: Cleaning up before object destruction.");
	}
}

public class JT_013_FinalFinallyFinalizeKeyword {
	public static void main(String[] args) {
		SecuritySystem security = new SecuritySystem();
		security.authenticate();

		BankTransaction transaction = new BankTransaction();
		transaction.processTransaction(1000);

		// Marking the object for garbage collection
		transaction = null;
		System.gc(); // Request garbage collection (Not guaranteed)
	}
}
