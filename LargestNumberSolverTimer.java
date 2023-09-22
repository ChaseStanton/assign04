package assign04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import assign04.LargestNumberSolver.KthIntegerComparator;

public class LargestNumberSolverTimer {
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
		Collections.sort(list, new KthIntegerComparator());
		return sortedList[k];
	}


    public static void main(String[] args) {
    	long startTime, stopTime, midPointTime;
    	midPointTime= 0;
    	stopTime = 0;

        int timesToLoop = 500;
        int arraySize = 2; // Size of each small Integer array
        int initialListSize = 100; // Initial total number of small arrays in the list

        System.out.println("List Size\tAverage Time");
        startTime = System.nanoTime();
        for (int listSize = initialListSize; listSize <= 2000; listSize += 100) {
            double totalAverageTime = 0.0;

            for (int run = 0; run < timesToLoop; run++) {
                // Generate a list of small Integer[] arrays
                List<Integer[]> list = new ArrayList<>();
                Random rng = new Random();

                for (int i = 0; i < listSize; i++) {
                    Integer[] array = new Integer[arraySize];
                    for (int j = 0; j < arraySize; j++) {
                        array[j] = rng.nextInt(100); // Adjust the range as needed
                    }
                    list.add(array);
                }
                
                midPointTime = System.nanoTime();

                // Use the findKthLargest method on the generated list
                int k = rng.nextInt(10);
                findKthLargest(list, k);
                
                for(long i = 0; i < timesToLoop; i++) { // empty block
        		}
                stopTime = System.nanoTime();

                // Compute the time and average it over the number of runs.
                double elapsedTime = (stopTime - midPointTime) / 1e6; // Convert to milliseconds
                double averageTime = ((midPointTime - startTime) - (stopTime - midPointTime)) / timesToLoop;

            }

            // Calculate and print the average execution time for the current list size.
            double averageTime = ((midPointTime - startTime) - (stopTime - midPointTime)) / timesToLoop;
            System.out.println(listSize + "\t" + averageTime);
        }
    }

}