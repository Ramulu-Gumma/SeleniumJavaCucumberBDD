package Inheritance;

//Single Inheritance: A subclass inherits from only one superclass.
//When to use: When you have a base class that defines common features for a specific category of machines,
//and you need to create a more specialized subclass.

//Parent class
class Machine {
	void start() {
		System.out.println("Machine is starting...");
	}
}

//Child class
class CNC_Machine extends Machine {
	void cut() {
		System.out.println("CNC Machine is cutting...");
	}
}

//Main class
public class JT_01_SingleI_Inheritance {
	public static void main(String[] args) {
		CNC_Machine cnc = new CNC_Machine();
		cnc.start();  // Inherited from Machine
		cnc.cut();    // Specific to CNC_Machine
	}
}

