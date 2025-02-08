package JavaTopics;


//Wrapper classes are used to wrap primitive data types into objects.
//When working with collections like ArrayList, HashMap, or HashSet, you need wrapper classes because collections don’t support primitive types.
//Auto-Unboxing and Auto-Boxing:
//
//Auto-boxing: Converting a primitive type to its wrapper class automatically.
//Auto-unboxing: Converting a wrapper class back to a primitive type automatically.

//Integer number = 10;  // Auto-boxing: int -> Integer
//int num = number;     // Auto-unboxing: Integer -> int

import java.util.ArrayList;
import java.util.Scanner;

class CustomerOrder {
	// Wrapper classes for order quantity and price
	private Integer orderId;
	private Integer quantity; // Wrapper class to allow null
	private Double pricePerUnit; // Wrapper class to allow null

	public CustomerOrder(Integer orderId, Integer quantity, Double pricePerUnit) {
		this.orderId = orderId;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	// Method to calculate total price for an order
	public Double calculateTotalPrice() {
		if (quantity == null || pricePerUnit == null) {
			return 0.0; // Handle null values gracefully
		}
		return quantity * pricePerUnit; // Unboxing happens here automatically
	}

	public Integer getOrderId() {
		return orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}
}

class OrderManagementSystem {
	private ArrayList<CustomerOrder> orders = new ArrayList<>();

	// Method to add order
	public void addOrder(Integer orderId, String quantityStr, String priceStr) {
		Integer quantity = null;
		Double price = null;

		// Convert String input to Integer (Wrapper class)
		try {
			quantity = Integer.parseInt(quantityStr); // Auto-unboxing happens here
		} catch (NumberFormatException e) {
			System.out.println("Invalid quantity input, defaulting to 0.");
		}

		// Convert String input to Double (Wrapper class)
		try {
			price = Double.parseDouble(priceStr); // Auto-unboxing happens here
		} catch (NumberFormatException e) {
			System.out.println("Invalid price input, defaulting to 0.0.");
		}

		// Create a new order using wrapper classes and add to the list
		orders.add(new CustomerOrder(orderId, quantity, price));
	}

	// Method to process orders and calculate total
	public void processOrders() {
		double totalRevenue = 0;
		for (CustomerOrder order : orders) {
			double totalPrice = order.calculateTotalPrice();
			System.out.println("Order ID: " + order.getOrderId() + ", Quantity: " + order.getQuantity() +
					", Price per unit: " + order.getPricePerUnit() + ", Total Price: $" + totalPrice);
			totalRevenue += totalPrice;
		}
		System.out.println("Total Revenue: $" + totalRevenue);
	}
}

public class JT_015_WrapperClasess {
	public static void main(String[] args) {
		OrderManagementSystem orderSystem = new OrderManagementSystem();
		Scanner scanner = new Scanner(System.in);

		// Simulating user input
		System.out.println("Enter number of orders:");
		int numberOfOrders = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < numberOfOrders; i++) {
			System.out.println("\nEnter details for Order " + (i + 1));

			System.out.print("Order ID: ");
			Integer orderId = Integer.parseInt(scanner.nextLine()); // Auto-boxing

			System.out.print("Quantity: ");
			String quantity = scanner.nextLine(); // User input as String

			System.out.print("Price per Unit: ");
			String price = scanner.nextLine(); // User input as String

			// Adding the order to the system
			orderSystem.addOrder(orderId, quantity, price);
		}

		// Processing all orders
		orderSystem.processOrders();

		scanner.close();
	}
}

