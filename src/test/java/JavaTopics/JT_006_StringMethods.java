package JavaTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JT_006_StringMethods {

	public static void main(String[] args) {
		
		//1. length() Method--This method returns the length of the string (number of characters).
		String greeting = "Hello, World!";
		System.out.println("Length of the string: " + greeting.length());

		
		//2. charAt() Method--This method returns the character at the specified index.
		String word = "Java";
		System.out.println("Character at index 2: " + word.charAt(2));

		
		//3. substring() Method--This method returns a substring from the string, 
		//starting at a specified index or between two indices.
		String message = "Welcome to Java!";
		System.out.println("Substring from index 8: " + message.substring(8));
		System.out.println("Substring from index 0 to 7: " + message.substring(0, 7));

		//4. equals() and equalsIgnoreCase() Methods
		//The equals() method compares two strings for exact equality, and the equalsIgnoreCase() method compares strings ignoring case sensitivity.
		String str1 = "Java";
		String str2 = "java";

		System.out.println(str1.equals(str2));  // false
		System.out.println(str1.equalsIgnoreCase(str2));  // true

		
		//5. toUpperCase() and toLowerCase() Methods--These methods convert the string to uppercase or lowercase.
		String str = "Java Programming";
		System.out.println("Uppercase: " + str.toUpperCase());
		System.out.println("Lowercase: " + str.toLowerCase());

		//6. replace() Method--This method replaces all occurrences of a substring within the string with a new substring.
		String sentence = "I love Java!";
		System.out.println(sentence.replace("Java", "Programming"));

		
		//7. trim() Method--This method removes any leading and trailing spaces from the string.
		String str3 = "   Java Programming   ";
		System.out.println("Trimmed string: '" + str3.trim() + "'");
		
		
		//8. contains(CharSequence sequence)--Checks if a string contains a specified sequence of characters.
		String str4 = "Hello World";
		boolean contains = str4.contains("World");
		System.out.println("Does the string contain 'World'? " + contains);
		
		
		//9. indexOf(int ch)--Returns the index of the first occurrence of the specified character.
		String str5 = "Hello World";
		int index = str5.indexOf('o');
		System.out.println("Index of 'o': " + index);
		
		
		//10. split(String regex)--Splits the string into an array of substrings based on a delimiter (regular expression).
		String str6 = "apple,banana,cherry";
		String[] fruits = str6.split(",");
		for (String fruit : fruits) {
		    System.out.println(fruit);
		}
		
		
		//11. valueOf(Object obj)--Returns the string representation of the specified object.
		int num = 123;
		String str7 = String.valueOf(num);
		System.out.println("String representation of number: " + str7);
		
		
		//12. replaceAll(String regex, String replacement)--Replaces all occurrences of a regular expression with the specified replacement string.
		String sentence1 = "Hello, how are you? How is everything?";
		String replaced = sentence1.replaceAll("how", "where");
		System.out.println(replaced);

		
		//13. concat(String str)--Concatenates (combines) the specified string with the current string.
		String str11 = "Hello";
		String str12 = " World";
		String result = str11.concat(str12);
		System.out.println("Concatenated String: " + result);
		
		
		//13. Comparing WebElement with == vs .equals()
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.example.com");

		WebElement button1 = driver.findElement(By.id("submit"));
		WebElement button2 = driver.findElement(By.id("submit"));

		if (button1 == button2) {
		    System.out.println("Both buttons refer to the same object in memory.");
		} else {
		    System.out.println("Both buttons are different objects in memory.");
		}

		
		if (button1.getText().equals(button2.getText())) {
		    System.out.println("Both buttons have the same text.");
		} else {
		    System.out.println("Both buttons have different text.");
		}

		
	}
		
	}


