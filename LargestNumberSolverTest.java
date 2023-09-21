package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LargestNumberSolverTest {
	private Comparator<Integer> custom;
	private Integer[] arr, sortedArr, findLargestNumberArr;

	@BeforeEach
	<T> void setUp() throws Exception {
		arr =  new Integer[] { 1, 2, 3, 11, 49, 91, 9};
		sortedArr = new Integer[] {9, 91, 49, 3, 2, 11, 1};
		findLargestNumberArr = new Integer[] {1 , 2 , 3 , 4 , 5};

		custom = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String str1 = o1.toString() + o2.toString();
				String str2 = o2.toString() + o1.toString();
				Integer num1 = Integer.parseInt(str1);
				Integer num2 = Integer.parseInt(str2);
				if(num2 - num1 == 0)
					return o2 - o1;
				return num2 - num1;
			}
		};

	};

	@Test
	void insertionSortTest() {
		LargestNumberSolver.insertionSort(arr, custom);
		assertArrayEquals(sortedArr, arr);
	}

	@Test
	void findLargestNumberTest(){
		BigInteger actual = new BigInteger("54321");
		assertEquals(actual, LargestNumberSolver.findLargestNumber(findLargestNumberArr));
	}

	@Test
	void findLargestInt() throws Exception{
		int actual = 54321;
		assertEquals(actual, LargestNumberSolver.findLargestInt(findLargestNumberArr));
	}
	
	@Test
	void findLargestLong() throws Exception{
		long actual = 54321;
		assertEquals(actual, LargestNumberSolver.findLargestLong(findLargestNumberArr));
	}
	@Test
	void findKthLarges() {
		Integer[] arr1 = new Integer[] {9, 8, 7};
		Integer[] arr2 = new Integer[] {5, 4, 3};
		Integer[] arr3 = new Integer[] {1, 1, 1};
		ArrayList<Integer[]> arrList = new ArrayList<>();
		arrList.add(arr1);
		arrList.add(arr2);
		arrList.add(arr3);
		Integer[] result = LargestNumberSolver.findKthLargest(arrList, 0);
		assertArrayEquals(arr1, result);


	}

}
