package JavaTopics;

//Downcasting in Java is converting a parent class reference back into a child class reference. 
//It is primarily used when we need to access child-specific methods that are not available in the parent class.


//Parent class
class FloatMachine {
	void start() {
		System.out.println("Machine is starting...");
	}
}

//Child class - CNC Machine
class CuttingMachine extends FloatMachine {
	void start() {
		System.out.println("CNC Machine is starting...");
	}

	void cutMetal() {
		System.out.println("CNC Machine is cutting metal...");
	}
}


//Main class
public class JT_009_DownCasting {

	public static void main(String[] args) {
		FloatMachine machine = new CuttingMachine(); // Upcasting
		machine.start(); // Output: CNC Machine is starting...

		// Downcasting to access CNC-specific method
		CuttingMachine cnc = (CuttingMachine) machine; // Explicit Downcasting
		cnc.cutMetal(); // Output: CNC Machine is cutting metal
	}
}
