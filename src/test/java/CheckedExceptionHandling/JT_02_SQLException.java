package CheckedExceptionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// DatabaseManager Class
class DatabaseManager {
	// Method to insert quality report into the database (Checked Exception: SQLException)
	public void saveReportToDatabase(String reportData) {
		String url = "jdbc:mysql://localhost:3306/glass_factory";
		String user = "root";
		String password = "admin";

		try {
			// Establishing a database connection
			Connection conn = DriverManager.getConnection(url, user, password);
			String query = "INSERT INTO quality_reports (report) VALUES (?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, reportData);
			stmt.executeUpdate();

			System.out.println("✅ Report saved successfully to the database!");
			conn.close();
		} catch (SQLException e) {
			System.err.println("❌ Database Error: " + e.getMessage());
		}
	}
}

// Main Class
public class JT_02_SQLException {
	public static void main(String[] args) {
		DatabaseManager dbManager = new DatabaseManager();
		String reportData = "Glass Quality: Excellent\nDefects: None";

		// Attempt to save the report to the database
		dbManager.saveReportToDatabase(reportData);
	}
}

