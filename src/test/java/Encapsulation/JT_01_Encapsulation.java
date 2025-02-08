package Encapsulation;

//Encapsulation is one of the fundamental Object-Oriented Programming (OOP) principles. It is the concept of wrapping or bundling data (fields) and methods (functions) that operate on the data into a single unit called a class. 
//Encapsulation restricts direct access to some of an object's components, which can protect the integrity of the data and ensure that it is used in a controlled manner.

//In Java, encapsulation is achieved by:
//Private Fields: Making fields private to restrict direct access from outside the class.
//Public Methods (Getters and Setters): Providing public methods to access and update the fields safely. These methods are often called getters and setters.

//Key Benefits of Encapsulation
//Data Hiding: Protects the object's internal state by hiding its implementation details.
//Controlled Access: Allows you to control how the data is accessed and modified.
//Flexibility and Maintainability: By encapsulating the data, you can change the internal implementation without affecting external code.
//Increased Security: By restricting direct access to the fields, you can ensure that invalid data cannot be set.

//Machine Class with Encapsulation
class AUXMachine {
	// Private fields
	private String machineName;
	private int speed;
	private String status;
	private String lastMaintenanceDate;

	// Constructor to initialize machine attributes
	public AUXMachine(String machineName, int speed, String status, String lastMaintenanceDate) {
		this.machineName = machineName;
		this.speed = speed;
		this.status = status;
		this.lastMaintenanceDate = lastMaintenanceDate;
	}

	// Getter and Setter for machineName
	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	// Getter and Setter for speed
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed > 0 && speed <= 100) {  // Restrict speed to a maximum of 100
			this.speed = speed;
		} else {
			System.out.println("Speed must be between 0 and 100.");
		}
	}

	// Getter and Setter for status
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status.equals("Operational") || status.equals("Down")) {
			this.status = status;
		} else {
			System.out.println("Invalid status. Status must be 'Operational' or 'Down'.");
		}
	}

	// Getter and Setter for lastMaintenanceDate
	public String getLastMaintenanceDate() {
		return lastMaintenanceDate;
	}

	public void setLastMaintenanceDate(String lastMaintenanceDate) {
		this.lastMaintenanceDate = lastMaintenanceDate;
	}

	// Method to display machine details
	public void displayMachineInfo() {
		System.out.println("Machine Name: " + machineName);
		System.out.println("Speed: " + speed);
		System.out.println("Status: " + status);
		System.out.println("Last Maintenance Date: " + lastMaintenanceDate);
	}
}

public class JT_01_Encapsulation {

	public static void main(String[] args) {
		// Create a new Machine object
		AUXMachine cncMachine = new AUXMachine("CNC Machine", 80, "Operational", "2025-01-01");

		// Accessing and modifying attributes using getters and setters
		cncMachine.displayMachineInfo();

		// Update machine speed and status using setter methods
		cncMachine.setSpeed(120);  // Invalid speed (exceeds limit)
		cncMachine.setSpeed(90);   // Valid speed
		cncMachine.setStatus("Inactive");  // Invalid status

		// Display updated machine information
		cncMachine.displayMachineInfo();
	}
}


