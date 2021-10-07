package exercise.arraysTDD;

import java.util.Arrays;

/**
 * Utility class which performs various operations with integer arrays.
 */
public class ArrayOperations {
    private final int[] numbers;      // array that needs to be sorted.
    private final int[] unsorted;     // reference array which stays unsorted.

    public ArrayOperations(int[] numbers) {
        this.numbers = numbers;
        this.unsorted = numbers.clone();
    }

    /* **********************************************************
     *   Please implement the following methods.                 *
     *   It is intended that they are not static.                *
     * ***********************************************************/

    /**
     * Prints out the numbers array.
     */

    public void print() {
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < (numbers.length - 1)) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * @return the sorted numbers array.
     * @see <a href="sorting algortihms">http://faculty.cs.niu.edu/~hutchins/csci241/sorting.htm</a>
     */
    public int[] sort() {
        // room to link various sorting algorithms
       gnomeSort();

       return numbers;
    }

    public void gnomeSort() {
        int pos = 0;
        while (pos < (numbers.length - 1)) {
            if (numbers[pos] > numbers[pos+1]) {
                swap(pos, (pos+1));
                pos--;
                if (pos < 0) pos = 0;
            } else {
                pos++;
            }
        }

    }

    /**
     * @return the sorted array in reverse order
     */
    public int[] revertSort() {
       sort(); // sort numbers if unsorted
        return revert(numbers);
    }

    /**
     * @return the unsorted array in reverted order.
     */
    public int[] reverted() {
        return revert(unsorted);
    }

    /**
     * @param value which should be searched for.
     * @return true if the array contains the value, false otherwise.
     */
    public boolean contains(int value) {
        boolean result = false;
        for (int i : numbers) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @return the average value of all elements summed up.
     */
    public double average() {
        int elemCount = 0;
        double sum = 0.0;
        for (int i :
                numbers) {
            elemCount++;
            sum += i;
        }
        return (sum / elemCount);
    }

    /**
     * @return the average value of all elements summed up, but without the highest and the lowest value.
     */
    public double trimmedMean() {
        int elemCount = -2;
        double sum = 0.0;
        int min = numbers[0];
        int max = numbers[0];
        for (int i :
                numbers) {
            elemCount++;
            sum += i;
            min = min(min, i);
            max = max(max, i);
        }
        sum = sum - min - max;
        return (sum / elemCount);
    }

    /**
     * @return the max value of the array. In the array [1,9,3] max would be 9.
     */
    public int maxValue() {
        int result = numbers[0];
        for (int i :
                numbers) {
            result = max(result, i);
        }
        return result;
    }

    /**
     * @return the min value of the array. In the array [1,9,3] min would be 1.
     */
    public int minValue() {
        int result = numbers[0];
        for (int i :
                numbers) {
            result = min(result, i);
        }
        return result;
    }

    /* **********************************************************
     *   Feel free to add as many private helper methods as      *
     *   you like.                                               *
     * ***********************************************************/

    private int someHelper(int[] tmp) {
        return 1;
    }

    private void swap(int i1, int i2) {
        numbers[i1] += numbers[i2];
        numbers[i2] = numbers[i1] - numbers[i2];
        numbers[i1] = numbers[i1] - numbers[i2];
    }

    private int[] revert(int[] input) {
        int len = input.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = input[len-i-1];
        }
        return result;
    }

    private int min(int i1, int i2) {
        return i1 < i2 ? i1 : i2;
    }

    private int max(int i1, int i2) {
        return i1 > i2 ? i1 : i2;
    }

}

