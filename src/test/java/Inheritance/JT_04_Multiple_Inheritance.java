package Inheritance;


//Multiple Inheritance: Involves inheritance from more than one class (not directly supported in Java, but can be achieved through interfaces).
//Java does not support multipleinheritance (inheriting from more than one class), but it does allow a class to implement multiple interfaces. 
//This can simulate multiple inheritance.
//When to use: When a class needs to inherit behaviors from multiple sources (e.g., a robot that can both cut and weld).

//Interface 1
interface CNE_Machine {
 void cut();
}

//Interface 2
interface Welding_Machine {
 void weld();
}

//Robot class implementing both interfaces
class Robot implements CNE_Machine, Welding_Machine {
 public void cut() {
     System.out.println("Robot is cutting...");
 }
 
 public void weld() {
     System.out.println("Robot is welding...");
 }
}

//Main class
public class JT_04_Multiple_Inheritance {
 public static void main(String[] args) {
     Robot robot = new Robot();
     robot.cut();   // CNC Machine functionality
     robot.weld();  // Welding Machine functionality
 }
}

