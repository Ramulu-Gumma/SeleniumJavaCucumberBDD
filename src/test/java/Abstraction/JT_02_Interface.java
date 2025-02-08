package Abstraction;

//Scenario: Factory Equipment Control System
//In a manufacturing plant, you might have several different types of equipment (e.g., CNC machines, 3D printers, robotic arms). 
//All of them need to perform tasks like starting, stopping, and performing specific actions (e.g., cutting, printing, welding)
//Interface - CraneMachine

interface CraneMachine {
	void start();  // Method to start the machine
	void stop();   // Method to stop the machine
	void performTask();  // Method to perform a task (e.g., cutting, shaping, drilling)
}

//Concrete class - CNG Machine
class CNGMachine implements CraneMachine {
	
	public void start() {
		System.out.println("CNC Machine is starting...");
	}

	public void stop() {
		System.out.println("CNC Machine is stopping...");
	}

	public void performTask() {
		System.out.println("CNC Machine is cutting metal...");
	}
}

//Concrete class - Lame Machine
class LameMachine implements CraneMachine {
	
	public void start() {
		System.out.println("Lathe Machine is starting...");
	}

	public void stop() {
		System.out.println("Lathe Machine is stopping...");
	}

	public void performTask() {
		System.out.println("Lathe Machine is shaping metal...");
	}
}

//Concrete class - Drilling Machine
class DrillingMachine implements CraneMachine {
	
	public void start() {
		System.out.println("Drilling Machine is starting...");
	}

	public void stop() {
		System.out.println("Drilling Machine is stopping...");
	}

	public void performTask() {
		System.out.println("Drilling Machine is drilling holes...");
	}
}


// Main class - JT_02_Interface
public class JT_02_Interface {
	
	public static void main(String[] args) {
		// Creating machine objects
		CraneMachine cngMachine = new CNGMachine();
		CraneMachine lameMachine = new LameMachine();
		CraneMachine drillingMachine = new DrillingMachine();

		// Using polymorphism and abstraction through the interface
		cngMachine.start();  // Output: CNG Machine is starting...
		cngMachine.performTask();  // Output: CNG Machine is cutting metal...
		cngMachine.stop();  // Output: CNG Machine is stopping...

		lameMachine.start();  // Output: Lame Machine is starting...
		lameMachine.performTask();  // Output: Lame Machine is shaping metal...
		lameMachine.stop();  // Output: Lame Machine is stopping...

		drillingMachine.start();  // Output: Drilling Machine is starting...
		drillingMachine.performTask();  // Output: Drilling Machine is drilling holes...
		drillingMachine.stop();  // Output: Drilling Machine is stopping...
	}
}