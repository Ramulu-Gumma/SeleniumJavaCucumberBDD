package Collections;

import java.util.HashMap;

public class JT_04_HashMap {

	// Key Features of HashMap:
	//Use HashMap for key-value storage.
	//		Unique Keys: Each key is unique. If a duplicate key is added, the old value is replaced.
	//		Null Values: Allows null values and one null key.
	//		Not Synchronized: Not thread-safe. Use ConcurrentHashMap if you need thread safety.
	//		Unordered: Does not maintain the order of elements.
	//		Time Complexity: O(1) for get/put operations (on average).
	//		 Basic Example: Storing Employee Grades
	
	    public static void main(String[] args) {
	        // Creating a HashMap to store student ID and their grade
	        HashMap<Integer, String> studentGrades = new HashMap<>();

	        // Adding key-value pairs
	        studentGrades.put(101, "A");
	        studentGrades.put(102, "B+");
	        studentGrades.put(103, "A-");

	        // Retrieving value using key
	        String grade = studentGrades.get(101); // Output: A
	        System.out.println("Student ID 101's grade: " + grade);

	        // Checking if key exists
	        if (studentGrades.containsKey(104)) {
	            System.out.println("Grade: " + studentGrades.get(104));
	        } else {
	            System.out.println("Student ID 104 not found.");
	        }

	        // Displaying the entire map
	        System.out.println("All Student Grades: " + studentGrades);
	    }
	}
