package JavaQuestionsAndAnswers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Reverse String Using java 8
		String str = "Selenium Java";
		String rev = new StringBuilder(str).reverse().toString();
		System.out.println("Reversed String: "+rev);

		//Reverse String by using normal
		String str1 =  "Selenium Java";
		String rev1 = "";
		for(int i=0; i<str1.length(); i++) {
			rev1 = str1.charAt(i)+rev1;
		}
		System.out.println("Reversed the String: "+rev1);
	
		String stri = "Hello, World!";

		String reversed = stri.chars()  // Create an IntStream of characters
				.mapToObj(c -> (char) c)  // Convert each int to a Character
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					// Reverse the list using a lambda expression
					StringBuilder sb = new StringBuilder();
					list.forEach(sb::append);  // Append each character to the StringBuilder
					return sb.reverse().toString();  // Reverse the StringBuilder and convert to string
				}));

		System.out.println("Reversed string: " + reversed);
		
		//Reverse each word or letter
		String str2 = "Selenium Java";
		String[] words = str2.split(" ");
		StringBuilder result = new StringBuilder();
		for(String word : words) {
			StringBuilder rev2 = new StringBuilder(word);
			result.append(rev2.reverse().toString()).append(" ");

		}
		System.out.println("Reversed the String: "+result.toString().trim());

		//Swap Two numbers
		int a =100;
		int b =200;
		int temp =a;
		a = b;
		b=temp;
		System.out.println("A Vluse is: "+a);
		System.out.println("B Value is: "+b);

		//Compress a string
		String str3 = "aabbccdd";
		StringBuilder compressed = new StringBuilder();
		for(int i=0; i<str3.length(); i++) {
			int count =1;
			while(i+1<str3.length() && str3.charAt(i) == str3.charAt(i+1)) {
				count++;
				i++;
			}
			compressed.append(count).append(str3.charAt(i));
		}
		System.out.println("Compressed the string: "+compressed.toString().trim());

		// Second letter shoud be capital
		String name = "My Name Is Ramulu";
		String[] nameWords = str.split(" ");
		StringBuilder results = new StringBuilder();
		for(String word : nameWords) {
			if(word.length()>1) {
				String modifiedWord = word.substring(0, 1)
						+ Character.toUpperCase(word.charAt(1))
						+ word.substring(2);
				results.append(modifiedWord).append(" ");
			}

		}
		System.out.println("Reversed Second letter: "+results.toString().trim());

		//Reverse number
		int number = 12345;
		String numberStr = Integer.toString(number);
		String revNumber = new StringBuilder(numberStr).reverse().toString();
		System.out.println("Reversed Number to String : "+revNumber);


		//Convert number to String
		int numb = 12345;
		String convertNum = Integer.toString(numb);
		StringBuilder res = new StringBuilder();
		for(char digitChar : convertNum.toCharArray()) {
			char letter = (char)('a' +(digitChar - '1'));
			res.append(letter);
		}
		System.out.println("Converted String: " +res.toString());


		//Convert string to numbe
		String input = "abcd";
		// Creating a map to define custom string to number mapping
		Map<String, Integer> stringToNumberMap = new HashMap<>();

		// Populate the map with predefined string-to-number mappings
		stringToNumberMap.put("abcd", 1234);
		stringToNumberMap.put("efgh", 5678);
		stringToNumberMap.put("ijkl", 91011);

		// Get the mapped number
		Integer output = stringToNumberMap.get(input);

		if (output != null) {
			System.out.println("Mapped number for '" + input + "' is: " + output);
		} else {
			System.out.println("No mapping found for input: " + input);
		}
	}}






