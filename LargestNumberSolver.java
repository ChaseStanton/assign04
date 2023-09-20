package assign04;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;

public class LargestNumberSolver {
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

	public static BigInteger findLargestNumber(Integer[] arr) {
		if (arr == null || arr.length == 0) {
            return BigInteger.ZERO; // Return 0 for empty array
        }

        // Use custom comparator to sort the array in descending order of concatenated values
        insertionSort(arr, new customComparator<Integer>());

        StringBuilder result = new StringBuilder();
        for (Integer num : arr) {
            result.append(num);
        }

        return new BigInteger(result.toString());
    }



	public static int findLargestInt(Integer[] arr) throws Exception {
		BigInteger largestNumber = findLargestNumber(arr);
        
        if (largestNumber.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new Exception("Largest number exceeds int range");
        }

        return largestNumber.intValue();
	}

	public static long findLargestLong(Integer[] arr) throws Exception {
		BigInteger largestNumber = findLargestNumber(arr);
        
        if (largestNumber.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
            throw new Exception("Largest number exceeds long range");
        }

        return largestNumber.longValue();
    }

	public static BigInteger sum(List<Integer[]> list) {

	}

	public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {

	}

	public static List<Integer[]> readFile(String filename) {

	}

	protected class customComparator<T> implements Comparator<T> {
		public int compare(T o1, T o2) {
			String str1 = o1.toString() + o2.toString();
			String str2 = o2.toString() + o1.toString();
			Integer num1 = Integer.parseInt(str1);
			Integer num2 = Integer.parseInt(str2);
			return num1.compareTo(num2);

		


		}
	};
}
