package assign04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Chase Stanton and Reece Kalmar
 * @version 09/21/2023
 *
 */
public class LargestNumberSolver {
	/**
	 * This method uses a comparator to sort the given array
	 * 
	 * @param <T> - The type of array to be sorted
	 * @param arr - The array to be sorted
	 * @param cmp - The comparator used to sort the array
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		for (int i = 1; i < arr.length; i++) {
			T item = arr[i];
			int j;
			for (j = i - 1; j >= 0 && cmp.compare(arr[j], item) > 0; j--) {
				arr[j + 1] = arr[j];

			}
			arr[j + 1] = item;
		}

	}

	/**
	 * This method finds the largest number that can be formed for an integer array
	 * 
	 * @param o1 - The integer array to sort
	 * @return BigInteger that is the largest number formed by the given array
	 */
	public static BigInteger findLargestNumber(Integer[] o1) {
		if (o1 == null || o1.length == 0) {
			return BigInteger.ZERO; // Return 0 for empty array
		}

		// Copy the original array so it doesn't modify the original array
		Integer[] copiedArr = new Integer[o1.length];
		for (int i = 0; i < o1.length; i++)
			copiedArr[i] = o1[i];
		// Use custom comparator to sort the array in descending order of concatenated
		// values
		insertionSort(copiedArr, new IntegerComparator<Integer>()); // Use

		StringBuilder result = new StringBuilder();
		for (Integer num : copiedArr) {
			result.append(num);
		}

		return new BigInteger(result.toString());
	}

	/**
	 * This method finds the largest int value that can be formed from the given
	 * array
	 * 
	 * @param arr - The array to be sorted
	 * @return an int value that is the largest int that can be formed
	 * @throws OutOfRangeException if the value is too big to be stored in an int
	 */
	public static int findLargestInt(Integer[] arr) throws OutOfRangeException {
		if (arr.length == 0)
			return 0; // Return 0 if array is empty
		BigInteger largestNumber = findLargestNumber(arr); // Use findLargestNumber to find the biggest number

		if (largestNumber.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
			throw new OutOfRangeException("Largest number exceeds int range");
		}
		// Changes the BigInteger value to an int
		return largestNumber.intValue();
	}

	/**
	 * This method finds the largest long value that can be formed from a given
	 * array
	 * 
	 * @param arr - The array to be sorted
	 * @return a long value that is the largest number formed from the array
	 * @throws OutOfRangeException if the value is too big to be stored in a long
	 */
	public static long findLargestLong(Integer[] arr) throws OutOfRangeException {
		if (arr.length == 0)
			return 0; // Return 0 if array is empty
		BigInteger largestNumber = findLargestNumber(arr);

		if (largestNumber.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
			throw new OutOfRangeException("Largest number exceeds long range");
		}
		// Changes the BigInteger value to a long
		return largestNumber.longValue();
	}

	/**
	 * This method adds all the numbers formed out of a list of integer arrays
	 * 
	 * @param list - The list to be added
	 * @return BigInteger value that is the sum of all the formed numbers
	 */
	public static BigInteger sum(List<Integer[]> list) {
		if (list.size() == 0)
			return BigInteger.ZERO; // return 0 if list is empty
		BigInteger sum = new BigInteger("0");
		for (Integer[] intArr : list) {
			sum = sum.add(findLargestNumber(intArr)); // adds each largest number value to the sum
		}
		return sum;
	}

	/**
	 * This method finds the Kth largest array based on what the biggest number
	 * formed is
	 * 
	 * @param list - The list to be searched
	 * @param k    - The Kth largest array to find
	 * @return an array that is the Kth largest array
	 * @throws IllegalArgumentException if the K value is too small or large to be
	 *                                  in the list
	 */
	public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {
		if (k < 0 || k >= list.size()) {
			throw new IllegalArgumentException("Kth value is too large or small for the given arrays");
		}
		// Make a 2D array to store the arrays in
		Integer[][] sortedList = new Integer[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			sortedList[i] = list.get(i);
		}
		// Use insertionSort to sort the 2D array
		insertionSort(sortedList, new KthIntegerComparator());
		return sortedList[k];
	}

	/**
	 * This method reads a file and returns a list of arrays with each array being a
	 * line seperated by white spaces
	 * 
	 * @param filename - the file to be read
	 * @return a list containing an array of each line in the file
	 */
	public static List<Integer[]> readFile(String filename) {
		List<Integer[]> result = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] elements = line.trim().split("\\s+");
				Integer[] arr = new Integer[elements.length];

				for (int i = 0; i < elements.length; i++) {
					arr[i] = Integer.parseInt(elements[i]);
				}

				result.add(arr);
			}
		} catch (IOException e) {
		}

		return result;
	}

	/**
	 * This class represents a comparator that compares the concatenations of the
	 * two numbers
	 * 
	 * @author Chase Stanton and Reece Kalmar
	 * @param <T> - The type of the numbers to be compared
	 */
	protected static class IntegerComparator<T> implements Comparator<T> {
		public int compare(T o1, T o2) {
			String str1 = o1.toString() + o2.toString();
			String str2 = o2.toString() + o1.toString();
			Integer num1 = Integer.parseInt(str1);
			Integer num2 = Integer.parseInt(str2);
			if (num2 - num1 == 0)
				return 0;
			return num2 - num1;
		}
	};

	/**
	 * This class represents a comparator that compares two Integer Arrays based on
	 * which one has a greater value from the findLargestNumber method
	 * 
	 * @author Chase Stanton and Reece Kalmar
	 *
	 */
	protected static class KthIntegerComparator implements Comparator<Integer[]> {
		public int compare(Integer[] o1, Integer[] o2) {
			BigInteger num1 = findLargestNumber(o1);
			BigInteger num2 = findLargestNumber(o2);
			return num2.compareTo(num1);
		}
	};
}
