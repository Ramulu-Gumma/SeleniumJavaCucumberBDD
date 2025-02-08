package JavaTopics;

public class JT_002_Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. Arithmetic Operators
		int num1 = 10, num2 = 3;

		System.out.println("num1 + num2 = " + (num1 + num2)); // Addition
		System.out.println("num1 - num2 = " + (num1 - num2)); // Subtraction
		System.out.println("num1 * num2 = " + (num1 * num2)); // Multiplication
		System.out.println("num1 / num2 = " + (num1 / num2)); // Division (int result)
		System.out.println("num1 % num2 = " + (num1 % num2)); // Modulus (remainder)
		
		//2. Relational Operators
		int num3 = 5, num4 = 10;

        System.out.println("num3 == num4: " + (num3 == num4)); // False
        System.out.println("num3 != num4: " + (num3 != num4)); // True
        System.out.println("num3 > num4: " + (num3 > num4)); // False
        System.out.println("num3 < num4: " + (num3 < num4)); // True
        System.out.println("num3 >= num4: " + (num3 >= num4)); // False
        System.out.println("num3 <= num4: " + (num3 <= num4)); // True
        
        //3. Logical Operators
        boolean isWeekend = true;
        boolean isHoliday = false;

        if (isWeekend && isHoliday) {
            System.out.println("Time for a vacation!");
        } else {
            System.out.println("Just another day at work.");
        }

        if (isWeekend || isHoliday) {
            System.out.println("Enjoy some rest!");
        }

        if (!isHoliday) {
            System.out.println("No holiday today.");
        }
        
        //4. Assignment Operators
        int num = 10;
        num += 5;  // num = num + 5
        System.out.println("num += 5: " + num);

        num -= 3;  // num = num - 3
        System.out.println("num -= 3: " + num);

        num *= 2;  // num = num * 2
        System.out.println("num *= 2: " + num);

        num /= 4;  // num = num / 4
        System.out.println("num /= 4: " + num);

        num %= 3;  // num = num % 3
        System.out.println("num %= 3: " + num);
        
        //5. Ternary Operator
        int age = 20;
        String result = (age >= 18) ? "Adult" : "Minor";
        System.out.println(result);  // Outputs: Adult
        
        //6. Increment and Decrement Operators
        int count = 5;
        System.out.println("count++: " + count++); // Post-increment: prints 5, then increments to 6
        System.out.println("count after increment: " + count); // Prints 6

        System.out.println("--count: " + --count); // Pre-decrement: decrements to 5, then prints
        
        //7. Bitwise Operators
        int a = 5, b = 3;

        System.out.println("a & b: " + (a & b));  // AND: 0101 & 0011 = 0001
        System.out.println("a | b: " + (a | b));  // OR: 0101 | 0011 = 0111
        System.out.println("a ^ b: " + (a ^ b));  // XOR: 0101 ^ 0011 = 0110
        System.out.println("~a: " + (~a));        // NOT: Inverts all bits of a
        
      

	}

}
