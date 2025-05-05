package Collections;

import java.util.HashSet;

public class JT_03_HashSet {
	
//	Key Features of HashSet:
//		✅ No Duplicate Elements – Automatically removes duplicates.
//		✅ Unordered Collection – Does not maintain the insertion order.
//		✅ Allows Null Values – Can store a single null value.
//		✅ Fast Operations – Provides average O(1) time complexity for insertions and lookups.
//		✅ Not Thread-Safe – Use Collections.synchronizedSet() for thread safety.
	//Use Case 1: Removing Duplicates from a List of Names
	//Used in windowhandles
	
	 public static void main(String[] args) {
	        // List of names with duplicates
	        String[] names = {"Alice", "Bob", "Charlie", "Alice", "David", "Bob"};

	        // Using HashSet to remove duplicates
	        HashSet<String> uniqueNames = new HashSet<>();
	        for (String name : names) {
	            uniqueNames.add(name);
	        }

	        // Displaying unique names
	        System.out.println("Unique Names: " + uniqueNames);
	    }
	}


