//Bander Saleh - RTC
import java.util.ArrayList; //import built in method
import java.util.Arrays; //import the built in method
import java.util.Random; //import the built in method



public class Main {
    public static void main(String[] args) {
        // Question 1
        System.out.println("Question #1:");
        displayDashes(10, 20); //run my method

        // Question 2
        System.out.println("Question #2:");
        int[] array2 = {1, 3, 5, 7, 9};
        int value = 6;
        System.out.println("Original Array:");
        printArray(array2);
        insertIntoSortedArray(array2, value); //run my method
        System.out.println("\nArray after insertion:");
        printArray(array2); //run printArray method

        // Question 3
        System.out.println("\nQuestion #3:");
        int[] array3 = new int[30]; //Initialize new instance of array
        fillArray(array3); //run my method
        System.out.println("Filled Array:");
        printArray(array3); //run printArray method

        // Question 4:
        System.out.println("\nQuestion #4:");
        int[] array4 = {5, 9, 12, 19, 25, 30};
        int largestDifference = getLargestDifference(array4); //run my method
        printArray(array4); //run printArray method
        System.out.println("Largest Difference: " + largestDifference); //run printArray method

        // Question 5:
        System.out.println("\nQuestion #5:");
        ArrayList<Integer> array5 = new ArrayList<>();
        array5.add(7);
        array5.add(-2);
        array5.add(-5);
        array5.add(9);
        array5.add(-3);
        array5.add(11);

        System.out.println("Original ArrayList: " + array5);
        removeNegativeOddArrayList(array5);
        System.out.println("ArrayList after removal: " + array5);

        // Question 6:
        System.out.println("\nQuestion #6:");
        int[] array6 = {-7, 1, 5, 2, -4, 3, 0};
        int equilibriumIndex = findEquilibriumIndex(array6);

        if (equilibriumIndex != -1) {
            System.out.println("Equilibrium index is: " + equilibriumIndex);
        } else {
            System.out.println("No equilibrium index found.");
        }

    } // End of MAIN CLASS


    // Question 1 Method
    public static void displayDashes(int x, int y) {
        // Build the pattern of dashes
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                pattern.append("- ");
            }
            pattern.append("\n"); // Add a new line after each row
        }
        // Print the pattern to the console
        System.out.println(pattern.toString());
    }


    // Question 2 Method
    public static void insertIntoSortedArray(int[] array, int value) {
        int index = 0;
        // Find the index where the value should be inserted
        while (index < array.length + 1 && array[index] < value) {
            index++;
        }
        // Shift elements to make space for the new value
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        // Insert the value at the correct index
        array[index] = value;
    }


    // Method to Print Arrays to the Console
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    // Question 3 Method
    public static void fillArray(int[] array) {
        Random random = new Random(); //initialize new instance of the imported built in Random generator class
        int partSize = array.length / 3; //int[] array should be divisible by 3
        // Fill the first part with random values between 1 and 9 (inclusive)
        Arrays.fill(array, 0, partSize, random.nextInt(9) + 1);
        // Fill the second part with random negative values between -20 and -29 (inclusive)
        Arrays.fill(array, partSize, 2 * partSize, -(random.nextInt(10) + 20));
        // Fill the third part with random values between 50 and 59 (inclusive)
        Arrays.fill(array, 2 * partSize, array.length, random.nextInt(10) + 50);
    }


    // Question 4 Method
    public static int getLargestDifference(int[] array) {
        int largestDifference = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            int difference = array[i] - array[i - 1]; //calculate the difference
            largestDifference = Math.max(largestDifference, difference); //use built in Math Method to compare currentDifference to largestDifference
        }
        return largestDifference; //return the final largestDifference value
    }


    // Question 5 Method
    public static void removeNegativeOddArrayList(ArrayList<Integer> list) {
        // Create a copy of the list to avoid ConcurrentModificationException
        ArrayList<Integer> copy = new ArrayList<>(list);

        for (Integer number : copy) {
            if (number < 0 && number % 2 != 0) {
                list.remove(number);
            }
        }
    }


    // Question 6 Method
    public static int findEquilibriumIndex(int[] array) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : array) {
            totalSum += num;
        }

        for (int i = 0; i < array.length; i++) {
            totalSum -= array[i];

            if (leftSum == totalSum) {
                return i;
            }

            leftSum += array[i];
        }

        return -1; // No equilibrium index found
    }








    //End of Class
}