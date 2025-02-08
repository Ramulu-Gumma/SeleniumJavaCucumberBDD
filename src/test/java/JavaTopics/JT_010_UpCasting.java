package JavaTopics;

//Scenario: Machine Hierarchy in a Factory
//A factory has different types of machines like CNC Machine, Lathe Machine, and Drilling Machine, 
//but they all share some common functionalities. We create a parent class Machine and let each machine type inherit from it.	
//🔹 Where is Upcasting Used?
//✅ When different machines share common functionalities
//✅ When storing different machine objects in a list or array for easy processing
//✅ When using method overriding to ensure correct behavior at runtime

//Parent class
class Machine {
	void start() {
		System.out.println("Machine is starting...");
	}
}

//Child class 1
class CNCMachine extends Machine {
	void cutMetal() {
		System.out.println("CNC Machine is cutting metal...");
	}
}

//Child class 2
class LatheMachine extends Machine {
	void shapeMetal() {
		System.out.println("Lathe Machine is shaping metal...");
	}
}

public class JT_010_UpCasting {
	public static void main(String[] args) {
		// Upcasting: Using parent class reference for child class objects
		Machine m1 = new CNCMachine();  // Upcasting
		Machine m2 = new LatheMachine(); // Upcasting

		m1.start();  // Allowed (method in parent)
		m2.start();  // Allowed (method in parent)

		// m1.cutMetal(); // ERROR: Not accessible because it's a child-specific method
		// m2.shapeMetal(); // ERROR: Not accessible
	}
}