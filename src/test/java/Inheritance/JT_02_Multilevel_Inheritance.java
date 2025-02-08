package Inheritance;

//Multilevel Inheritance: A subclass inherits from a superclass, and that superclass itself inherits from another class.
//When to use: When you want to create a hierarchy of classes with specialized functionality at each level.

//Parent class
class BLDGMachine {
	void start() {
		System.out.println("Machine is starting...");
	}
}

//Child class
class CNOMachine extends BLDGMachine {
	void cut() {
		System.out.println("CNC Machine is cutting...");
	}
}

//Grandchild class
class CNC_Router extends CNOMachine {
	void route() {
		System.out.println("CNC Router is routing...");
	}
}

//Main class
public class JT_02_Multilevel_Inheritance {
	public static void main(String[] args) {
		CNC_Router router = new CNC_Router();
		router.start();  // Inherited from Machine
		router.cut();    // Inherited from CNC_Machine
		router.route();  // Specific to CNC_Router
	}
}


