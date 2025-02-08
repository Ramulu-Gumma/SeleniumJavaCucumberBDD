package Collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class JT_02_LinkedList {

	//	Key Features of LinkedList:
	//      Use LinkedList when frequent insertions & deletions are needed.
	//		✅ Dynamic Size – No need to predefine size.
	//		✅ Fast Insertions & Deletions – O(1) at the beginning and end.
	//		✅ Doubly Linked – Efficient traversal in both directions.
	//		✅ More Memory Usage – Each node stores extra references.
	//		✅ Slower Random Access – O(n) for getting elements vs. O(1) in ArrayList.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Use Case 1: Implementing a Browser's Back & Forward Navigation

		LinkedList<String> history = new LinkedList<>();

		// Simulating browser navigation
		history.add("google.com");
		history.add("stackoverflow.com");
		history.add("github.com");

		// Navigating back
		ListIterator<String> iterator = history.listIterator(history.size());
		System.out.println("Going Back:");
		while (iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
	}
}


