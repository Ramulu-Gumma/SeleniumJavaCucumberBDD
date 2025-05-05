package Polymorphism;

//Key Points of Method Overriding:

//Same Method Signature: The overridden method in the child class must have the same name, return type, and parameters as the method in the parent class.
//Dynamic (Runtime) Polymorphism: Overriding is resolved at runtime (dynamic polymorphism), unlike method overloading, which is resolved at compile time.
//@Override Annotation: It’s a good practice to use the @Override annotation to indicate that a method is intended to override a method in the superclass.
//Method Inheritance: The method in the parent class is inherited by the subclass, and the subclass can override it to provide its own functionality.
//Access Modifiers: The access level of the overridden method in the subclass should be the same or more permissive than the method in the parent class.


//Parent class representing a general Glass Machine
class GlassMachine {
	// Method to shape glass
	void shapeGlass() {
		System.out.println("Shaping glass in a general way.");
	}
}

//Child class for Cutting Machine
class CuttingMachine extends GlassMachine {
	// Overriding the shapeGlass method for cutting glass
	@Override
	void shapeGlass() {
		System.out.println("Cutting glass into desired shapes.");
	}
}

//Child class for Tempering Machine
class TemperingMachine extends GlassMachine {
	// Overriding the shapeGlass method for tempering glass
	@Override
	void shapeGlass() {
		System.out.println("Tempering the glass for strength.");
	}
}

//Child class for Blowing Machine
class BlowingMachine extends GlassMachine {
	// Overriding the shapeGlass method for glass blowing
	@Override
	void shapeGlass() {
		System.out.println("Blowing glass into specific shapes.");
	}
}

//Main class to demonstrate method overriding
public class JT_02_MethodOverriding_Child {
	public static void main(String[] args) {
		// Creating instances of different glass machines
		GlassMachine cuttingMachine = new CuttingMachine();
		GlassMachine temperingMachine = new TemperingMachine();
		GlassMachine blowingMachine = new BlowingMachine();

		// Calling the shapeGlass method on each machine, demonstrating method overriding
		cuttingMachine.shapeGlass();  // Output: Cutting glass into desired shapes.
		temperingMachine.shapeGlass();  // Output: Tempering the glass for strength.
		blowingMachine.shapeGlass();  // Output: Blowing glass into specific shapes.
	}
}

