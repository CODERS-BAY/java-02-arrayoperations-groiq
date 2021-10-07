package exercise.arraysTDD;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayOperationsAdditionalTests {

    @org.junit.jupiter.api.Test
    void sortingShouldHandleDuplicates() {
        int[] givenArray = { 3, 1, 7, 3 };
        ArrayOperations givenArrayOps = new ArrayOperations(givenArray);

        int[] actual = givenArrayOps.sort();

        int[] expected = { 1, 3, 3, 7 };
        assertArrayEquals(expected, actual);
    }

}
