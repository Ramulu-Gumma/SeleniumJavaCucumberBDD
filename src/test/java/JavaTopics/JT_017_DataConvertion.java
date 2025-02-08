package JavaTopics;

//Data conversion in Java refers to converting one type of data to another. This is often required when:
//
//Converting between primitive types (e.g., int to double).
//Converting between wrapper classes and primitives (e.g., Integer to int).
//Parsing strings to data types (e.g., converting a String to an int).
//Date format conversion (e.g., String to Date, or vice versa).
//Converting data types for database operations, like converting String values to Date or int to String.

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Order {
    private int orderId;
    private int quantity;
    private double pricePerUnit;
    private Date orderDate;

    // Constructor
    public Order(int orderId, int quantity, double pricePerUnit, Date orderDate) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.orderDate = orderDate;
    }

    // Method to calculate total price
    public double calculateTotalPrice() {
        return quantity * pricePerUnit;
    }

    // Method to display order details
    public String displayOrderDetails() {
        return "Order ID: " + orderId + ", Quantity: " + quantity + ", Price per Unit: $" + pricePerUnit + ", Date: " + orderDate;
    }
}

public class JT_017_DataConvertion {

    // Method to convert string input to integer
    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);  // Convert String to Integer
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input, defaulting to 0.");
            return 0;
        }
    }

    // Method to convert string input to double
    public static double convertToDouble(String input) {
        try {
            return Double.parseDouble(input);  // Convert String to Double
        } catch (NumberFormatException e) {
            System.out.println("Invalid price input, defaulting to 0.0.");
            return 0.0;
        }
    }

    // Method to convert string to Date
    public static Date convertToDate(String input) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(input);  // Convert String to Date using a specific format
        } catch (ParseException e) {
            System.out.println("Invalid date format, defaulting to current date.");
            return new Date();  // Return current date on error
        }
    }

    // Method to convert double to currency format
    public static String convertToCurrencyFormat(double amount) {
        return String.format("$%.2f", amount);  // Format double to currency
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accepting user input for order details
        System.out.println("Enter Order ID: ");
        String orderIdInput = scanner.nextLine();
        int orderId = convertToInt(orderIdInput);  // Convert string to integer

        System.out.println("Enter Quantity: ");
        String quantityInput = scanner.nextLine();
        int quantity = convertToInt(quantityInput);  // Convert string to integer

        System.out.println("Enter Price per Unit: ");
        String priceInput = scanner.nextLine();
        double pricePerUnit = convertToDouble(priceInput);  // Convert string to double

        System.out.println("Enter Order Date (yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        Date orderDate = convertToDate(dateInput);  // Convert string to Date

        // Create an Order object
        Order order = new Order(orderId, quantity, pricePerUnit, orderDate);

        // Display order details
        System.out.println(order.displayOrderDetails());

        // Calculate total price and display in currency format
        double totalPrice = order.calculateTotalPrice();
        System.out.println("Total Price: " + convertToCurrencyFormat(totalPrice));

        // Simulate a currency conversion (e.g., USD to EUR)
        double exchangeRate = 0.85;  // Example: 1 USD = 0.85 EUR
        double totalPriceInEUR = totalPrice * exchangeRate;
        System.out.println("Total Price in EUR: " + convertToCurrencyFormat(totalPriceInEUR));

        scanner.close();
    }
}

