package exercise.arraysTDD;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class ArrayOperationsTest {

	private final int[] numbers;
	private final int[] unsorted;
	private final ArrayOperations instance;
	private final int ELEMENTS = 10;

	public ArrayOperationsTest() {
		numbers = new int[ELEMENTS];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new Random().nextInt(100);
		}
		// for testing contains we insert 250 at random position
		numbers[new Random().nextInt(ELEMENTS)] = 250;

		// clone the numbers array to have a reference.
		unsorted = numbers.clone();

		// create instance of the ArrayOperations
		instance = new ArrayOperations(numbers);
	}

	@org.junit.jupiter.api.Test
	void print() {
		System.out.println("This is just a visual test. " + "It does print the unsorted array in this test");
		System.out.println("It should look like this:");
		System.out.println(Arrays.toString(numbers));
		System.out.println("=========");
		System.out.println("Your output is: ");
		instance.print();
	}

	@org.junit.jupiter.api.Test
	void sort() {
		int[] expected = numbers.clone();
		Arrays.sort(expected);
		int[] result = instance.sort();
		assertArrayEquals(expected, result);
		printArrays("sort", expected, result);
	}

	@org.junit.jupiter.api.Test
	void revertSort() {
		Arrays.sort(numbers);
		int[] expected = new int[numbers.length];
		int index = 0;
		for (int i = numbers.length - 1; i >= 0; i--) {
			expected[index++] = numbers[i];
		}

		int[] result = instance.revertSort();
		printArrays("revertSort", expected, result);
		assertArrayEquals(expected, result);
	}

	@org.junit.jupiter.api.Test
	void reverted() {
		int[] expected = new int[unsorted.length];

		int index = 0;
		for (int i = unsorted.length - 1; i >= 0; i--) {
			expected[index++] = unsorted[i];
		}
		int[] result = instance.reverted();
		printArrays("reverted", expected, result);

		assertArrayEquals(expected, result);
	}

	@org.junit.jupiter.api.Test
	void contains() {
		Integer[] arr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		boolean expected = new ArrayList<>(Arrays.asList(arr)).contains(250);
		boolean result = instance.contains(250);

		assertEquals(expected, result);
		result = instance.contains(-1);
		assertNotEquals(true, result);
	}

	@org.junit.jupiter.api.Test
	void average() {
		double expected = getSum() / ELEMENTS;
		double result = instance.average();
		printValues("average", expected, result);

		assertEquals(expected, result);
	}

	@org.junit.jupiter.api.Test
	void trimmedMean() {
		double expected = (getSum() - getMax() - getMin()) / (ELEMENTS - 2);
		double result = instance.trimmedMean();
		printValues("trimmedMean", expected, result);

		assertEquals(expected, result);
	}

	@org.junit.jupiter.api.Test
	void maxValue() {
		int expected = getMax();
		int result = instance.maxValue();
		printValues("maxValue", expected, result);

		assertEquals(expected, result);
	}

	@org.junit.jupiter.api.Test
	void minValue() {
		int expected = getMin();
		int result = instance.minValue();
		printValues("minValue", expected, result);

		assertEquals(expected, result);
	}

	private void printArrays(String current, int[] expected, int[] result) {
		System.out.println(current);
		System.out.print("Expected: \t");
		for (int i : expected)
			System.out.print(i + " ");
		System.out.println();
		System.out.print("Result: \t");
		for (int i : result)
			System.out.print(i + " ");
	}

	private void printValues(String current, double expected, double result) {
		System.out.println(current);
		System.out.println("expected: \t" + expected);
		System.out.println("result: \t" + result);
	}

	private double getSum() {
		double sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}

	private int getMin() {
		Integer[] arr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		return Collections.min(Arrays.asList(arr));
	}

	private int getMax() {
		Integer[] arr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
		return Collections.max(Arrays.asList(arr));
	}
}
