package JavaTopics;


class Employee {
    private String name;
    private double salary;

    // Constructor using `this` to differentiate between instance and local variables
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Using `this` to call another constructor
    public Employee(String name) {
        this(name, 30000); // Default salary
    }

    // Using `this` to invoke another method
    public void showDetails() {
        System.out.println("Employee Name: " + this.name);
        System.out.println("Salary: $" + this.salary);
    }

    public void display() {
        this.showDetails(); // Calling another method in the same class
    }
}

public class JT_012_ThisKeyword {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 50000);
        emp1.display();

        Employee emp2 = new Employee("Bob"); // Uses default salary
        emp2.display();
    }
}

