package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LargestNumberSolverTest {
	private Comparator<Integer> custom;
	private Integer[] arr, sortedArr, findLargestNumberArr;
	private ArrayList<Integer[]> arrList;
	private Integer[] arr1, arr2, arr3, empty;

	@BeforeEach
	void setUp() throws Exception {
		arr =  new Integer[] { 1, 2, 3, 11, 49, 91, 9};
		sortedArr = new Integer[] {9, 91, 49, 3, 2, 11, 1};
		findLargestNumberArr = new Integer[] {1 , 2 , 3 , 4 , 5};
		arrList = new ArrayList<>();
		empty = new Integer[0];
		arr1 = new Integer[] {9, 8, 7};
		arr2 = new Integer[] {5, 4, 3};
		arr3 = new Integer[] {1, 1, 1};
		arrList.add(arr1);
		arrList.add(arr2);
		arrList.add(arr3);

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
	void emptyFindLargestNumberTest()  {
		assertEquals(BigInteger.ZERO, LargestNumberSolver.findLargestNumber(empty));
	}
	@Test
	void emptyFindLargestIntTest()  {
		assertEquals(0, LargestNumberSolver.findLargestInt(empty));

	}
	@Test
	void emptyFindLargestLongTest()  {
		assertEquals(0, LargestNumberSolver.findLargestLong(empty));
	}
	@Test
	void tooLargeIntTest() throws OutOfRangeException{
		Integer[] longArr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, };
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestInt(longArr);
		});
	}
	@Test
	void tooLargeLongTest() throws OutOfRangeException{
		Integer[] bigIntArr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestLong(bigIntArr);
		});
	}
	@Test
	void validNumberFindLargestInt() {
		Integer[] intArr = new Integer[] {1};
		assertEquals(1, LargestNumberSolver.findLargestInt(intArr));
	}
	@Test
	void validNumberFindLargestLong() {
		Integer[] validLongArr = new Integer[] {10,000000000000000000};
		assertEquals(10,000000000000000000, LargestNumberSolver.findLargestInt(validLongArr));
	}
	
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
		
		Integer[] result = LargestNumberSolver.findKthLargest(arrList, 0);
		assertArrayEquals(arr1, result);


	}
	@Test
	void sum() {
	

	BigInteger expected = new BigInteger("1641");
	BigInteger result = LargestNumberSolver.sum(arrList);
	assertEquals(expected, result);
	}

}
