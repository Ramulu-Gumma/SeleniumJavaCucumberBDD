package JavaQuestionsAndAnswers;

import java.util.HashSet;

public class ArraysQuestions {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub

			//Reverse An Array
			int[]arr = {1, 2, 3, 4, 5};
			int start = 0;
			int end = arr.length-1;
			while(start<end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
			for(int num: arr) {
				System.out.print(+num);
			}

			//Find Largest element
			int[] arrLarg = {1, 7, 3, 9, 2};
		        int largest = arrLarg[0];  // Assume the first element is the largest

		        for (int i = 1; i < arrLarg.length; i++) {
		            if (arrLarg[i] > largest) {
		                largest = arrLarg[i];  // Update the largest if a larger element is found
		            }
		        }

		        System.out.println("The largest element is: " + largest);
		    }

			//Find the Second Largest Element in an Array
			int[] arrLar = {1, 2, 3, 4, 5};
			int larges = Integer.MIN_VALUE;
			int secondLargest = Integer.MIN_VALUE;
			{
			for(int num1 : arrLar) {
				if(num1>larges) {
					secondLargest = larges;
					larges = num1;

				}else if (num1>secondLargest && num1!=larges) {
					secondLargest = num1;

				}
			}
			System.out.println("Second largest number: "+secondLargest);

			//Find the Duplicate Elements in an Array
			int[] arrDup = {1, 4, 3, 4, 4, 5};
			HashSet<Integer> seen = new HashSet<>();
			System.out.println("Duplicate Elements: ");
			for(int num2:arrDup) {
				if(!seen.add(num2)) {
					System.out.println(num2);
				}

			}
			//Find the Missing Number in an Array
			int[] arrMiss = {1, 2, 3, 5, 6};
			int n = arrMiss.length + 1; // The total number of elements should be n+1
			int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
			int actualSum = 0;

			for (int num3 : arrMiss) {
				actualSum += num3;
			}

			int missingNumber = expectedSum - actualSum;
			System.out.println("Missing number: " + missingNumber);

			//Remove Duplicates from an Array
			int[] arrDu = {1, 2, 3, 3, 4, 5, 5};
			HashSet<Integer> set = new HashSet<>();
			for (int num4 : arrDu) {
				set.add(num4);
			}
			
			// Print the array without duplicates
			for (int num5 : set) {
				System.out.print(num5 + " ");
			}

			//Find the Maximum and Minimum Element in an Array
			int[] array = {6, 7, 1, 2, 4, 8, 9, 3, 5};
			int max = array[0];
			int min = array[0];
			for(int i=1; i<array.length; i++) {
				if(array[i]>max) {
					max = array[i];
				}
				if(array[i]>min) {
					min = array[i];
				}
			}
			System.out.println(+max);
			System.out.println(+min);   


			//Find the Common Elements Between Two Arrays
			int[] arr1 = {1, 2, 3, 4, 5};
			int[] arr2 = {4, 5, 6, 7, 8};

			HashSet<Integer> set1 = new HashSet<>();
			for (int num7 : arr1) {
				set1.add(num7);
			}

			System.out.println("Common elements:");
			for (int num6 : arr2) {
				if (set1.contains(num6)) {
					System.out.println(num6);
				}
			}

			//Sum of All Elements in an Array
			int[] arrSum = {1, 2, 3, 4, 5};
			int sum = 0;

			for (int num : arrSum) {
				sum += num;
			}

			System.out.println("Sum of all elements: " + sum);

		}
	}
	 


