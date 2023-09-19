package assign04;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LargestNumberSolverTest {
	private Integer[] arr;

	@BeforeEach
	<T> void setUp() throws Exception {
		arr = new Integer[] { 1, 2, 3, 4 };
		Comparator<Integer> custom = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - 1;
			}
		};
		insertionSort(arr, custom);

	};

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
