package Polymorphism;

//🔹 Key Points of Method Overloading:
//Same Method Name: Methods have the same name.
//Different Parameters: Methods differ in the number or type of parameters.
//Compile-Time Polymorphism: Overloading is resolved at compile time (also called compile-time polymorphism).
//Return Type is Optional: The return type can be the same or different, but it is not considered for overloading.
//Method Signature: A method signature consists of the method name and the parameter list. The return type does not affect the signature.

//Parent class representing glass cutting machine
class GlassCuttingMachine {

	// Method to cut glass based on dimensions
	void cut(double width, double height) {
		System.out.println("Cutting glass with width: " + width + " and height: " + height);
	}

	// Overloaded method to cut glass based on thickness
	void cut(double width, double height, double thickness) {
		System.out.println("Cutting glass with width: " + width + ", height: " + height + " and thickness: " + thickness);
	}

	// Overloaded method to cut colored glass based on color
	void cut(double width, double height, String color) {
		System.out.println("Cutting " + color + " glass with width: " + width + " and height: " + height);
	}

	// Overloaded method to cut tempered glass
	void cut(double width, double height, boolean isTempered) {
		if (isTempered) {
			System.out.println("Cutting tempered glass with width: " + width + " and height: " + height);
		} else {
			System.out.println("Cutting regular glass with width: " + width + " and height: " + height);
		}
	}
}

//Main class to demonstrate method overloading
public class JT_01_MethodOverloading {
	
	public static void main(String[] args) {
		GlassCuttingMachine machine = new GlassCuttingMachine();

		// Cutting glass by dimensions
		machine.cut(5.0, 7.0);

		// Cutting glass by dimensions and thickness
		machine.cut(5.0, 7.0, 0.5);

		// Cutting colored glass
		machine.cut(5.0, 7.0, "Blue");

		// Cutting tempered glass
		machine.cut(5.0, 7.0, true);  // for tempered glass
		machine.cut(5.0, 7.0, false); // for regular glass
	}
}


