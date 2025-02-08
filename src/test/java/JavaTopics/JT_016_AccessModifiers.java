package JavaTopics;


//Class with different access modifiers
class Employe {
	// Public field, accessible anywhere
	public String name;

	// Private field, accessible only within the Employee class
	private double salary;

	// Protected field, accessible within the same package or subclasses
	protected String department;

	// Default (no modifier) field, accessible only within the same package
	String position;

	// Constructor with public access
	public Employe(String name, double salary, String department, String position) {
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.position = position;
	}

	// Public method to access private salary
	public double getSalary() {
		return salary;
	}

	// Private method, accessible only within the Employee class
	private void displaySalary() {
		System.out.println("Salary is confidential: " + salary);
	}

	// Protected method, accessible within the same package or subclasses
	protected void displayDepartment() {
		System.out.println("Department: " + department);
	}

	// Default method, accessible within the same package
	void displayPosition() {
		System.out.println("Position: " + position);
	}
}

//Subclass demonstrating protected access modifier
class Manager extends Employe {
	private int teamSize;

	public Manager(String name, double salary, String department, String position, int teamSize) {
		super(name, salary, department, position); // Calling parent constructor
		this.teamSize = teamSize;
	}

	// Overriding the protected method to display team size
	@Override
	protected void displayDepartment() {
		super.displayDepartment();  // Calling parent method
		System.out.println("Manager's team size: " + teamSize);
	}
}

public class JT_016_AccessModifiers {
	public static void main(String[] args) {
		// Creating employee and manager objects
		Employe employee = new Employe("John Doe", 50000, "Finance", "Analyst");
		Manager manager = new Manager("Jane Smith", 80000, "Finance", "Manager", 10);

		// Accessing public fields and methods
		System.out.println("Employee Name: " + employee.name);
		employee.displayPosition();

		// Accessing private field using public method
		System.out.println("Employee Salary: $" + employee.getSalary());

		// Accessing protected method within the same package
		employee.displayDepartment();

		// Accessing protected method from subclass (Manager)
		manager.displayDepartment();

		// The following line would result in a compile-time error because salary is private
		// System.out.println("Employee Salary: $" + employee.salary); // Error!

		// The following line would also result in an error because displaySalary is private
		// employee.displaySalary(); // Error!
	}
}

