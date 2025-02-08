package JavaTopics;

public class JT_005_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. Single-Dimensional Arrays--A single-dimensional array (1D array) is essentially a list of elements of the same type.
		// Declare and initialize an array of integers
		//type[] arrayName = {value1, value2, value3};
		int[] numbers = {10, 20, 30, 40, 50};

		// Access and print each element using a loop
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Element at index " + i + ": " + numbers[i]);
		}
		
		//2. Multi-Dimensional Arrays--A multi-dimensional array is an array of arrays. 
		//It is useful for storing data that has multiple dimensions, such as a matrix or a table.
		// Declare and initialize a 2D array
		//type[][] arrayName = new type[rows][columns];
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Print all elements of the 2D array using nested loops
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        //3. Jagged Arrays (Arrays of Arrays)--A jagged array is an array of arrays where the inner arrays can have different lengths, 
        //making the array "jagged" rather than rectangular.
        //type[][] arrayName = new type[rowCount][];
        // Declare a jagged array with 3 rows
        int[][] jaggedArray = new int[3][];

        // Initialize the inner arrays with different lengths
        jaggedArray[0] = new int[]{1, 2, 3};
        jaggedArray[1] = new int[]{4, 5};
        jaggedArray[2] = new int[]{6, 7, 8, 9};

        // Print all elements of the jagged array
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }

	}

}
