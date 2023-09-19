package assign04;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LargestNumberSolverTest {
	private Comparator<Integer> custom;
	private Integer[] arr, sortedArr;

	@BeforeEach
	<T> void setUp() throws Exception {
		arr =  new Integer[] { 1, 2, 3, 11, 49, 91, 9};
		sortedArr = new Integer[] {9, 91, 49, 3, 2, 11, 1};

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
	void test() {
		LargestNumberSolver.insertionSort(arr, custom);
		assertArrayEquals(sortedArr, arr);
	}

}
