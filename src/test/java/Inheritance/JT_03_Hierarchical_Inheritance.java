package Inheritance;

//Hierarchical Inheritance: Multiple subclasses inherit from a single superclass.
//When to use: When several different machines share common features (e.g., they can all start, stop, or have certain attributes like power).

//Parent class
class BOLDMachine {
	void start() {
		System.out.println("Machine is starting...");
	}
}

//Child classes
class CND_Machine extends BOLDMachine {
	void cut() {
		System.out.println("CNC Machine is cutting...");
	}
}

class Lathe_Machine extends BOLDMachine {
	void turn() {
		System.out.println("Lathe Machine is turning...");
	}
}

class Drilling_Machine extends Machine {
	void drill() {
		System.out.println("Drilling Machine is drilling...");
	}
}

//Main class
public class JT_03_Hierarchical_Inheritance {
	public static void main(String[] args) {
		CND_Machine cnc = new CND_Machine();
		cnc.start();  // Inherited from Machine
		cnc.cut();    // Specific to CNC Machine

		Lathe_Machine lathe = new Lathe_Machine();
		lathe.start();  // Inherited from Machine
		lathe.turn();   // Specific to Lathe Machine
	}
}

