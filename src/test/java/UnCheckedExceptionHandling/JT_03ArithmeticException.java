package UnCheckedExceptionHandling;


class YieldCalculator {
	// Method to calculate production yield
	public void calculateYield(int goodProducts, int totalProducts) {
		try {
			if (totalProducts == 0) {
				throw new ArithmeticException("❌ Division by zero! No products produced.");
			}
			double yield = (double) goodProducts / totalProducts * 100;
			System.out.println("✅ Production Yield: " + yield + "%");
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}
}

// Main Class
public class JT_03ArithmeticException {
	public static void main(String[] args) {
		YieldCalculator calculator = new YieldCalculator();
		calculator.calculateYield(80, 100); // ✅ Valid input
		calculator.calculateYield(0, 0);    // ❌ Division by zero
	}
}

