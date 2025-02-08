package Arrays;

//An array in Java is a data structure that stores a fixed-size sequence of elements of the same type. 
//Arrays allow you to store multiple values in a single variable instead of declaring separate variables for each value.
//Key Points about Arrays:
//Fixed Size: Once an array is created, its size cannot be changed.
//Homogeneous Elements: All elements in an array must be of the same type (e.g., all integers, all strings).
//Index-Based: Array elements are accessed using their index, starting from 0.

//Single-Dimensional Array: A simple array that holds multiple elements in a single row (like a list).

public class JT_01_SingleArray {
	
	public static void main(String[] args) {
        // Array of machine names
        String[] machines = {"CNC Machine", "Lathe Machine", "Drilling Machine", "Milling Machine"};
        
        // Print all machine names using a for loop
        for (String machine : machines) {
            System.out.println("Machine: " + machine);
        }
    }
}


