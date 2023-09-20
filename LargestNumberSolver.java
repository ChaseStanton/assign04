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

	public static BigInteger findLargestNumber(Integer[] o1) {
		if (o1 == null || o1.length == 0) {
			return BigInteger.ZERO; // Return 0 for empty array
		}

		// Use custom comparator to sort the array in descending order of concatenated
		// values
		insertionSort(o1, new IntegerComparator<Integer>());

		StringBuilder result = new StringBuilder();
		for (Integer num : o1) {
			result.append(num);
		}

		return new BigInteger(result.toString());
	}

	public static int findLargestInt(Integer[] arr) throws OutOfRangeException {
		BigInteger largestNumber = findLargestNumber(arr);

		if (largestNumber.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
			throw new OutOfRangeException("Largest number exceeds int range");
		}

		return largestNumber.intValue();
	}

	public static long findLargestLong(Integer[] arr) throws OutOfRangeException {
		BigInteger largestNumber = findLargestNumber(arr);

		if (largestNumber.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
			throw new OutOfRangeException("Largest number exceeds long range");
		}

		return largestNumber.longValue();
	}

	public static BigInteger sum(List<Integer[]> list) {
		BigInteger sum = new BigInteger("0");
		for(Integer[] intArr: list){
			sum.add(findLargestNumber(intArr));
		}
		return sum;
	}

	public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {
		if(k < 0 || k >= list.size()){
			throw new IllegalArgumentException("Kth value is too large or small for the given arrays");
		}
		Integer[] sortedList = new Integer[list.size()];
		for(int i = 0; i < list.size(); i++){
			sortedList[i] = findLargestInt(list.get(i));
		}
		
		insertionSort(sortedList, new KthIntegerComparator());
		return sortedList[k];
	}

	public static List<Integer[]> readFile(String filename) {

	}

	protected static class IntegerComparator<T> implements Comparator<T> {
		public int compare(T o1, T o2) {
			String str1 = o1.toString() + o2.toString();
				String str2 = o2.toString() + o1.toString();
				Integer num1 = Integer.parseInt(str1);
				Integer num2 = Integer.parseInt(str2);
				if(num2 - num1 == 0)
					return 0;
				return num2 - num1;
		}
	};
	protected static class KthIntegerComparator implements Comparator<Integer> {
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	};
}

