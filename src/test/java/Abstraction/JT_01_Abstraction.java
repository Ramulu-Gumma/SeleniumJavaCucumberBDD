package Abstraction;


abstract class Machine {
	// Common behavior (implemented)
	void start() {
		System.out.println("Machine is starting...");
	}

	// Abstract method (To be implemented by subclasses)
	abstract void performTask();

	// Common behavior (implemented)
	void stop() {
		System.out.println("Machine is stopping...");
	}
}

//Child class - CNC Machine (Concrete Implementation)
class CNCMachine extends Machine {
	// Implementing the abstract method
	void performTask() {
		System.out.println("CNC Machine is cutting metal...");
	}
}

//Child class - Lathe Machine (Concrete Implementation)
class LatheMachine extends Machine {
	// Implementing the abstract method
	void performTask() {
		System.out.println("Lathe Machine is shaping metal...");
	}
}

//Main class - ManufacturingSystem
public class JT_01_Abstraction {

	public static void main(String[] args) {
		// Creating objects of different machine types
		Machine cnc = new CNCMachine();
		Machine lathe = new LatheMachine();

		// Using abstraction: We can call start() and stop() on any machine
		cnc.start();  // Output: Machine is starting...
		cnc.performTask();  // Output: CNC Machine is cutting metal...
		cnc.stop();  // Output: Machine is stopping...

		lathe.start();  // Output: Machine is starting...
		lathe.performTask();  // Output: Lathe Machine is shaping metal...
		lathe.stop();  // Output: Machine is stopping...
	}
}
