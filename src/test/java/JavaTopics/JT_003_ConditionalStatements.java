package JavaTopics;

public class JT_003_ConditionalStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. if Statement--The if statement is used to execute a block of code if the specified condition is true.
		int temperature = 30;

		if (temperature > 25) {
			System.out.println("It's hot outside!");
		}


		// 2. if-else Statement
		int age = 16;

		if (age >= 18) {
			System.out.println("You are eligible to vote.");
		} else {
			System.out.println("You are not eligible to vote.");
		}

		//3. else-if Ladder--The else-if ladder is used when you need to check multiple conditions. The first if condition that evaluates to true will execute its block of code, and the rest are skipped.
		//If none of the conditions are true, the else block (if present) will execute.
		int score = 85;

		if (score >= 90) {
			System.out.println("Grade A");
		} else if (score >= 80) {
			System.out.println("Grade B");
		} else if (score >= 70) {
			System.out.println("Grade C");
		} else {
			System.out.println("Grade D");
		}

		//4. switch Statement--The switch statement is used when you have multiple possible values for a variable and want to execute different code blocks based on the value.
		int dayOfWeek = 3;

		switch (dayOfWeek) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("Invalid day");
			break;
		}

	}

}
