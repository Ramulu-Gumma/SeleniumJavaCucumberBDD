package CheckedExceptionHandling;

import java.io.FileWriter;
import java.io.IOException;

// Class responsible for writing quality reports to a file
class QualityReportLogger {
	// Method to write report to a file
	public void saveReport(String reportData, String filePath) {
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(reportData);
			writer.close();
			System.out.println("✅ Quality report saved successfully!");
		} catch (IOException e) {
			System.err.println("❌ Error: Failed to write report! " + e.getMessage());
		}
	}
}

// Main Class
public class JT_03_IOException {
	public static void main(String[] args) {
		QualityReportLogger logger = new QualityReportLogger();
		String reportData = "Batch No: 101\nGlass Quality: Excellent\nDefects: None";
		String filePath = "GlassQualityReport.txt";

		// Attempt to save the report
		logger.saveReport(reportData, filePath);
	}
}
