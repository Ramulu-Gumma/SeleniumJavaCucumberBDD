package JavaTopics;

public class JT_004_LoopsAndJumpStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. for Loop--The for loop is used when the number of iterations is known beforehand.
		//for (initialization; condition; update) {
		// code to be executed
		//} 
		for (int i = 1; i <= 5; i++) {
			System.out.println("Iteration: " + i);
		}

		//2. while Loop--The while loop is used when the number of iterations is not known in advance, 
		//and you want to keep repeating until a condition becomes false.
		int count = 1;
		while (count <= 5) {
			System.out.println("Count: " + count);
			count++;
		}

		//3. do-while Loop-- The do-while loop guarantees that the block of code will execute at least once, 
		//even if the condition is false, because the condition is checked after the loop runs.
		int count1 = 1;
		do {
			System.out.println("Count: " + count1);
			count1++;
		} while (count1 <= 5);

		//2. Java Jump Statements--Jump statements are used to control the flow of execution in loops, conditional blocks, or methods. Java provides three primary jump statements:
		//1. break Statement--The break statement is used to exit a loop or a switch statement prematurely.
		//It breaks the current loop or switch and proceeds with the next line of code after the loop or switch.
		for (int i = 1; i <= 10; i++) {
			if (i == 6) {
				break; // Exit the loop when i equals 6
			}
			System.out.println("i: " + i);
		}

		//2. continue Statement-- The continue statement is used to skip the current iteration of a loop and move on to the next iteration.
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue;  // Skip the rest of the loop when i equals 5
			}
			System.out.println("i: " + i);
		}

		//3. return Statement--The return statement is used to exit from a method and optionally return a value. 
		//It is not typically used in loops, but it can be used to exit a method immediately.
		printNumbers(5);
	}

	public static void printNumbers(int limit) {
		for (int i = 1; i <= 10; i++) {
			if (i > limit) {
				return; // Exit the method if i exceeds the limit
			}
			System.out.println("i: " + i);
		}
	}


}
