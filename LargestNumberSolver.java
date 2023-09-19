package assign04;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;

public class LargestNumberSolver {
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (cmp.compare(arr[i], arr[j]) < 1)
					temp[i] = arr[j];

			}
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

	class customComparator<T> implements Comparator<T> {
		public int compare(T o1, T o2) {
			StringBuilder bigNumber1 = new StringBuilder();
			bigNumber1.append(o1);
			bigNumber1.append(o2);
			String num = bigNumber1.toString();
			int firstValue = Integer.parseInt(num);
			StringBuilder bigNumber2 = new StringBuilder();
			bigNumber2.append(o2);
			bigNumber2.append(o1);
			String num2 = bigNumber2.toString();
			int secondValue = Integer.parseInt(num2);
			return firstValue - secondValue;

		}
	};
}
