package Collections;

import java.util.Hashtable;

public class JT_07_HashTable {
	
//	🔹 Key Features of HashTable
//	✅ Key-Value Storage: Uses unique keys to map values.
//	✅ Thread-Safe: Can be used in multi-threaded environments.
//	✅ No Null Keys or Values: Unlike HashMap, it does not allow null keys or values.
//	✅ Fast Lookups: Uses O(1) complexity for searching and inserting.
//	✅ Legacy Class: Introduced before HashMap, but still useful in multi-threaded applications.
//Hash table is used in inventory module to check the glass stsock availability
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Inventory Management System
		//A HashTable can be used to store product stock availability in an e-commerce or retail inventory

		 Hashtable<String, Integer> inventory = new Hashtable<>();

	        // Adding products with stock count
	        inventory.put("Laptop", 10);
	        inventory.put("Smartphone", 25);
	        inventory.put("Headphones", 50);

	        System.out.println("Inventory: " + inventory);

	        // Checking stock availability
	        System.out.println("Stock of Smartphones: " + inventory.get("Smartphone"));

	}

}
