package exercise.arraysTDD;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayOperationsAdditionalTests {

    /**
     * sort a reversed array of ints 0-7, for clear tracing in BucketSort
     */
    @org.junit.jupiter.api.Test
    void testSortingReversedArray() {
        int[] givenArray = { 7, 6, 5, 4, 3, 2, 1, 0 };
        ArrayOperations givenArrayOps = new ArrayOperations(givenArray);

        int[] actual = givenArrayOps.sort();

        int[] expected = { 0, 1, 2, 3, 4, 5, 6, 7 };
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void sortingShouldHandleDuplicates() {
        int[] givenArray = { 3, 1, 7, 3 };
        ArrayOperations givenArrayOps = new ArrayOperations(givenArray);

        int[] actual = givenArrayOps.sort();

        int[] expected = { 1, 3, 3, 7 };
        assertArrayEquals(expected, actual);
    }

}
