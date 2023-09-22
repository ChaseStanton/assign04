package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
		arr = new Integer[] { 1, 2, 3, 11, 49, 91, 9 };
		sortedArr = new Integer[] { 9, 91, 49, 3, 2, 11, 1 };
		findLargestNumberArr = new Integer[] { 1, 2, 3, 4, 5 };
		arrList = new ArrayList<>();
		empty = new Integer[0];
		arr1 = new Integer[] { 9, 8, 7 };
		arr2 = new Integer[] { 5, 4, 3 };
		arr3 = new Integer[] { 1, 1, 1 };
		arrList.add(arr1);
		arrList.add(arr2);
		arrList.add(arr3);

		custom = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				String str1 = o1.toString() + o2.toString();
				String str2 = o2.toString() + o1.toString();
				Integer num1 = Integer.parseInt(str1);
				Integer num2 = Integer.parseInt(str2);
				if (num2 - num1 == 0)
					return o2 - o1;
				return num2 - num1;
			}
		};

	};

	@Test
	void emptyFindLargestNumberTest() {
		assertEquals(BigInteger.ZERO, LargestNumberSolver.findLargestNumber(empty));
	}

	@Test
	void emptyFindLargestIntTest() {
		assertEquals(0, LargestNumberSolver.findLargestInt(empty));

	}

	@Test
	void emptyFindLargestLongTest() {
		assertEquals(0, LargestNumberSolver.findLargestLong(empty));
	}

	@Test
	void tooLargeIntTest() throws OutOfRangeException {
		Integer[] longArr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, };
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestInt(longArr);
		});
	}

	@Test
	void tooLargeLongTest() throws OutOfRangeException {
		Integer[] bigIntArr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestLong(bigIntArr);
		});
	}

	@Test
	void validNumberFindLargestInt() {
		Integer[] intArr = new Integer[] { 1 };
		assertEquals(1, LargestNumberSolver.findLargestInt(intArr));
	}

	@Test
	void validNumberFindLargestLong() {
		Integer[] validLongArr = new Integer[] { 10, 000000000000000000 };
		assertEquals(10, 000000000000000000, LargestNumberSolver.findLargestInt(validLongArr));
	}

	@Test
	void insertionSortTest() {
		LargestNumberSolver.insertionSort(arr, custom);
		assertArrayEquals(sortedArr, arr);
	}

	@Test
	void findLargestNumberTest() {
		BigInteger actual = new BigInteger("54321");
		assertEquals(actual, LargestNumberSolver.findLargestNumber(findLargestNumberArr));
	}

	@Test
	void findLargestInt() throws Exception {
		int actual = 54321;
		assertEquals(actual, LargestNumberSolver.findLargestInt(findLargestNumberArr));
	}

	@Test
	void findLargestLong() throws Exception {
		long actual = 54321;
		assertEquals(actual, LargestNumberSolver.findLargestLong(findLargestNumberArr));
	}

	@Test
	void findKthLarges() {

		Integer[] result = LargestNumberSolver.findKthLargest(arrList, 0);
		assertArrayEquals(arr1, result);

	}

	@Test
	void sumTest() {

		BigInteger expected = new BigInteger("1641");
		BigInteger result = LargestNumberSolver.sum(arrList);
		assertEquals(expected, result);
	}

	@Test
	void smallListFindKthLargestTest() {
		ArrayList<Integer[]> smallList = new ArrayList<>();
		Integer[] smallArr1 = new Integer[] { 6 };
		Integer[] smallArr2 = new Integer[] { 4 };
		Integer[] smallArr3 = new Integer[] { 1 };
		Integer[] smallArr4 = new Integer[] { 93 };
		smallList.add(smallArr4);
		smallList.add(smallArr1);
		smallList.add(smallArr3);
		smallList.add(smallArr2);
		Integer[] result = LargestNumberSolver.findKthLargest(smallList, 0);
		assertEquals(smallArr4, result);

	}

	@Test
	void emptyReadFileTest() {
		List<Integer[]> emptyList = new ArrayList<>();
		List<Integer[]> result = LargestNumberSolver.readFile("abcde.txt");
		assertTrue(emptyList.equals(result));

	}

	@Test
	void readFileTest() {
		List<Integer[]> emptyList = new ArrayList<>();
		List<Integer[]> result = LargestNumberSolver.readFile("src/assign04/ints.txt");
		assertFalse(result.equals(emptyList));
		Integer[] line1 = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] line2 = new Integer[] { 6, 7, 8, 9, 10 };
		List<Integer[]> smallFileListExpected = new ArrayList<>();
		smallFileListExpected.add(line1);
		smallFileListExpected.add(line2);
		List<Integer[]> smallFileListActual = LargestNumberSolver.readFile("src/assign04/simple_int_file.txt");
		Integer[] actualArr1 = smallFileListActual.get(0);
		Integer[] actualArr2 = smallFileListActual.get(1);
		Integer[] expectedArr1 = smallFileListExpected.get(0);
		Integer[] expectedArr2 = smallFileListExpected.get(1);

		assertArrayEquals(actualArr1, expectedArr1);
		assertArrayEquals(actualArr2, expectedArr2);

	}

	@Test
	void fileFindKthLargestTest() {
		List<Integer[]> smallFile = LargestNumberSolver.readFile("src/assign04/simple_int_file.txt");
		Integer[] firstValue = new Integer[] { 6, 7, 8, 9, 10 };
		Integer[] smallFileResult = LargestNumberSolver.findKthLargest(smallFile, 0);
		assertArrayEquals(firstValue, smallFileResult);

	}

	@Test
	void findKthLargestTestExpection() throws IllegalArgumentException {
		List<Integer[]> smallFile = LargestNumberSolver.readFile("src/assign04/simple_int_file.txt");
		assertThrows(IllegalArgumentException.class, () -> {
			LargestNumberSolver.findKthLargest(smallFile, -1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			LargestNumberSolver.findKthLargest(smallFile, 2);
		});
	}

	@Test
	void sumEmptyListTest() {
		List<Integer[]> emptyList = new ArrayList<>();
		BigInteger result = LargestNumberSolver.sum(emptyList);
		assertEquals(BigInteger.ZERO, result);
	}

	@Test
	void sumSingleElementListTest() {
		List<Integer[]> singleElementList = new ArrayList<>();
		singleElementList.add(new Integer[] { 42 });
		BigInteger result = LargestNumberSolver.sum(singleElementList);
		assertEquals(new BigInteger("42"), result);
	}

	@Test
	void findKthLargestWithEmptyList() {
		List<Integer[]> emptyList = new ArrayList<>();
		assertThrows(IllegalArgumentException.class, () -> {
			LargestNumberSolver.findKthLargest(emptyList, 0);
		});
	}

	@Test
	void readFileWithInvalidFileName() {
		List<Integer[]> result = LargestNumberSolver.readFile("nonexistentfile.txt");
		assertTrue(result.isEmpty());
	}

	@Test
	void readFileWithEmptyFile() {
		List<Integer[]> result = LargestNumberSolver.readFile("src/assign04/empty_file.txt");
		assertTrue(result.isEmpty());
	}

	@Test
	void findKthLargestWithKEqualToListSize() {
		assertThrows(IllegalArgumentException.class, () -> {
			LargestNumberSolver.findKthLargest(arrList, 3);
		});
	}

	@Test
	void findKthLargestWithKGreaterThanListSize() {
		assertThrows(IllegalArgumentException.class, () -> {
			LargestNumberSolver.findKthLargest(arrList, 4);
		});
	}

	@Test
	void findKthLargestWithKEqualToListSizeMinusOne() {
		Integer[] expectedResult = new Integer[] { 1, 1, 1 };
		Integer[] result = LargestNumberSolver.findKthLargest(arrList, 2);
		assertArrayEquals(expectedResult, result);
	}

}
