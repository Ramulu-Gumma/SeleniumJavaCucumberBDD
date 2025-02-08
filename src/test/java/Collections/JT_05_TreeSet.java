package Collections;

import java.util.TreeSet;

public class JT_05_TreeSet {

//	🔹 Key Features of TreeSet
//	✅ Stores unique elements (no duplicates)
//	✅ Automatically sorts elements in ascending order
//	✅ Efficient search, insert, and delete operations (O(log n))
//	✅ Uses a balanced tree (Red-Black Tree)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1: Sorting Unique Employee Names
		TreeSet<String> employees = new TreeSet<>();

        // Adding employee names
        employees.add("John");
        employees.add("Alice");
        employees.add("Bob");
        employees.add("Alice"); // Duplicate, won't be added

        System.out.println("Sorted Employee Names: " + employees);

	}

}
