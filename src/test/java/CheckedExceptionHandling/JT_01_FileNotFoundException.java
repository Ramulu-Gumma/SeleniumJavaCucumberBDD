package CheckedExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Checked exceptions are important for handling external resource failures like file operations, databases, and networks.
//Using try-catch, throws, and proper logging ensures a smooth and error-free glass manufacturing process.
//Exception handling improves system reliability, data security, and user experience.


// Class responsible for reading production reports
class ProductionReportReader {
    // Method to read report from file
    public void readReport(String filePath) {
        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            System.out.println("📄 Reading Production Report:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("❌ Error: Production report file not found! " + e.getMessage());
        }
    }
}

// Main Class
public class JT_01_FileNotFoundException {
    public static void main(String[] args) {
        ProductionReportReader reportReader = new ProductionReportReader();
        String filePath = "GlassProductionReport.txt";  // Ensure this file exists

        // Attempt to read the production report
        reportReader.readReport(filePath);
    }
}

