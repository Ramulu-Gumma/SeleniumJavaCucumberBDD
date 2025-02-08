package JavaTopics;

public class JT_001_VariablesAndDataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Primitive Data Types
        int age = 30; // integer
        double price = 19.99; // decimal number
        char grade = 'A'; // character
        boolean isRaining = false; // boolean value
        byte level = 120; // small integer
        short distance = 150; // smaller integer than int
        long population = 7800000000L; // large integer
        float temperature = 36.6f; // decimal number with single precision

        // Reference Data Types
        String name = "John Doe"; // text (String)
        int[] scores = {85, 90, 78}; // array of integers

        // Printing the variables
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Price: $" + price);
        System.out.println("Grade: " + grade);
        System.out.println("Is it raining? " + isRaining);
        System.out.println("Level: " + level);
        System.out.println("Distance to school: " + distance + " km");
        System.out.println("World Population: " + population);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Scores: " + scores[0] + ", " + scores[1] + ", " + scores[2]);

       // Primitive types store simple data like numbers and characters.
       // Reference types store complex data like strings, arrays, and objects.
	}

}
