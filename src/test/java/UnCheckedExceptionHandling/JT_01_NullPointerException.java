package UnCheckedExceptionHandling;


class ProductionReport {
    String batchNumber;
    Double glassThickness; // Thickness in mm

    // Constructor
    public ProductionReport(String batchNumber, Double glassThickness) {
        this.batchNumber = batchNumber;
        this.glassThickness = glassThickness;
    }

    // Method to display report details
    public void displayReport() {
        try {
            if (batchNumber == null || glassThickness == null) {
                throw new NullPointerException("❌ Production data is missing!");
            }
            System.out.println("✅ Batch No: " + batchNumber);
            System.out.println("Glass Thickness: " + glassThickness + " mm");
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}

// Main Class
public class JT_01_NullPointerException {
    public static void main(String[] args) {
        ProductionReport report1 = new ProductionReport("B101", 5.5); // Valid report
        ProductionReport report2 = new ProductionReport(null, null);  // Missing data

        report1.displayReport();
        report2.displayReport(); // ❌ This will trigger NullPointerException handling
    }
}

