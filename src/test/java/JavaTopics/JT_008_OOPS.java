package JavaTopics;

public class JT_008_OOPS {
	
	//1. Class--A class is a blueprint or template for creating objects. 
	//It defines the properties (attributes) and behaviors (methods) that the objects created from it will have.
	// Attributes (or Fields)
    String make;
    String model;
    int year;

    ////3. Method-- A method is a function that is defined within a class and describes an action that an object can perform. 
    //Methods are used to define the behavior of the objects.
    // Method (Behavior)
    public void startEngine() {
        System.out.println("The engine is starting...");
    }

    public void drive() {
        System.out.println("The car is driving...");
    }
  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//2. Object--An object is an instance of a class. Once a class is defined, you can create objects (instances) of that class. 
		//Each object has its own set of attributes and can call the methods defined in the class.	
		 // Creating an object of the Car class
		
		JT_008_OOPS myCar = new JT_008_OOPS();

        // Setting attributes for the object
        myCar.make = "Toyota";
        myCar.model = "Corolla";
        myCar.year = 2020;

        // Calling methods on the object
        myCar.startEngine();
        myCar.drive();
	
	

	}

}
