package Java8;

import java.util.Arrays;
import java.util.List;

public class TC_01_LamdaExpressions {
	//1. Lambda Expressions--Lambda expressions allow you to write instances of single-method interfaces (functional interfaces) more concisely.
	
	public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Alice", "Bob");
        
        // Using lambda expression to print each name
        names.forEach(name -> System.out.println(name));
    }
}


