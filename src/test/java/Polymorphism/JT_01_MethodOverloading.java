package Polymorphism;

//🔹 Key Points of Method Overloading:
//Same Method Name: Methods have the same name.
//Different Parameters: Methods differ in the number or type of parameters.
//Compile-Time Polymorphism: Overloading is resolved at compile time (also called compile-time polymorphism).
//Return Type is Optional: The return type can be the same or different, but it is not considered for overloading.
//Method Signature: A method signature consists of the method name and the parameter list. The return type does not affect the signature.

//Parent class representing glass cutting machine
class GlassCuttingMachine {
	 // Method for Admin access
    public void grantAccess(String role) {
        System.out.println(role + " has full system access.");
    }

    // Method for PlantAdmin access
    public void grantAccess(String role, int plantId) {
        System.out.println(role + " has access to Plant ID: " + plantId);
    }

    // Method for General User access
    public void grantAccess(String role, String department) {
        System.out.println(role + " has access to " + department + " department only.");
    }
}

public class JT_01_MethodOverloading {
    public static void main(String[] args) {
    	GlassCuttingMachine access = new GlassCuttingMachine();

        // Admin Access
        access.grantAccess("Admin");

        // Plant Admin Access
        access.grantAccess("PlantAdmin", 101);

        // General User Access
        access.grantAccess("User", "Production");
    }
}

