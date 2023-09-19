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

	}

	public static int findLargestInt(Integer[] arr) throws OutOfRangeException {

	}

	public static long findLargestLong(Integer[] arr) throws OutOfRangeException {

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
