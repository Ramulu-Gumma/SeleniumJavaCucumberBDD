package Collections;

import java.util.TreeMap;

public class JT_06_TreeMap {
	
//	Key Features of TreeMap
//	✅ Stores key-value pairs in sorted order of keys
//	✅ Efficient searching, inserting, and deleting (O(log n))
//	✅ Faster than a LinkedHashMap but slower than HashMap
//	✅ Allows natural sorting or custom sorting using Comparator

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Storing and Sorting User Login Timestamps
		TreeMap<Long, String> loginTimes = new TreeMap<>();

        // Adding user login timestamps
        loginTimes.put(1700001000L, "User A");
        loginTimes.put(1700002000L, "User B");
        loginTimes.put(1700000500L, "User C");

        System.out.println("User Login Times (Sorted by Timestamp): " + loginTimes);

	}

}
