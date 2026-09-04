import java.util.Arrays;

public class ArraysUtilityMethods {

    public static void main(String[] args) {

        // =========================================================
        // 1. toString() → Print a 1D array
        // =========================================================

        int[] arr1 = {10, 20, 30, 40};

        System.out.println("toString : " + Arrays.toString(arr1));
        // Output: [10, 20, 30, 40]


        // =========================================================
        // 2. deepToString() → Print multidimensional array
        // =========================================================

        int[][] arr2 = {
                {10, 20},
                {30, 40}
        };

        System.out.println(Arrays.deepToString(arr2));
        // Output: [[10, 20], [30, 40]]


        // =========================================================
        // 3. sort() → Sort array in ascending order
        // =========================================================

        int[] arr3 = {50, 10, 40, 20, 30};

        Arrays.sort(arr3);

        System.out.println(Arrays.toString(arr3));
        // Output: [10, 20, 30, 40, 50]


        // =========================================================
        // 4. parallelSort() → Parallel sorting
        // =========================================================

        int[] arr4 = {50, 10, 40, 20, 30};

        Arrays.parallelSort(arr4);

        System.out.println(Arrays.toString(arr4));
        // Output: [10, 20, 30, 40, 50]


        // =========================================================
        // 5. equals() → Compare two 1D arrays
        // =========================================================

        int[] a = {10, 20, 30};
        int[] b = {10, 20, 30};

        System.out.println(Arrays.equals(a, b));
        // Output: true


        // =========================================================
        // 6. deepEquals() → Compare multidimensional arrays
        // =========================================================

        int[][] a2 = {
                {10, 20},
                {30, 40}
        };

        int[][] b2 = {
                {10, 20},
                {30, 40}
        };

        System.out.println(Arrays.deepEquals(a2, b2));
        // Output: true


        // =========================================================
        // 7. fill() → Fill complete array with one value
        // =========================================================

        int[] arr5 = new int[5];

        Arrays.fill(arr5, 100);

        System.out.println(Arrays.toString(arr5));
        // Output: [100, 100, 100, 100, 100]


        // =========================================================
        // 8. fill() with range → Fill specific part
        // =========================================================

        int[] arr6 = {10, 20, 30, 40, 50};

        Arrays.fill(arr6, 1, 4, 99);

        System.out.println(Arrays.toString(arr6));
        // Output: [10, 99, 99, 99, 50]


        // =========================================================
        // 9. copyOf() → Copy an array
        // =========================================================

        int[] original = {10, 20, 30};

        int[] copy = Arrays.copyOf(original, original.length);

        System.out.println(Arrays.toString(copy));
        // Output: [10, 20, 30]


        // =========================================================
        // 10. copyOf() with larger size
        // =========================================================

        int[] biggerCopy = Arrays.copyOf(original, 5);

        System.out.println(Arrays.toString(biggerCopy));
        // Output: [10, 20, 30, 0, 0]


        // =========================================================
        // 11. copyOfRange() → Copy a portion of array
        // =========================================================

        int[] arr7 = {10, 20, 30, 40, 50};

        int[] range = Arrays.copyOfRange(arr7, 1, 4);

        System.out.println(Arrays.toString(range));
        // Output: [20, 30, 40]


        // =========================================================
        // 12. binarySearch() → Search sorted array
        // =========================================================

        int[] arr8 = {10, 20, 30, 40, 50};

        int index = Arrays.binarySearch(arr8, 30);

        System.out.println(index);
        // Output: 2


        // =========================================================
        // 13. binarySearch() with range
        // =========================================================

        int[] arr9 = {10, 20, 30, 40, 50};

        int index2 = Arrays.binarySearch(arr9, 1, 4, 30);

        System.out.println(index2);
        // Output: 2


        // =========================================================
        // 14. mismatch() → Find first different index
        // =========================================================

        int[] first = {10, 20, 30, 40};
        int[] second = {10, 20, 99, 40};

        System.out.println(Arrays.mismatch(first, second));
        // Output: 2


        // =========================================================
        // 15. compare() → Compare two arrays
        // =========================================================

        int[] c1 = {10, 20, 30};
        int[] c2 = {10, 20, 40};

        System.out.println(Arrays.compare(c1, c2));
        // Negative value because 30 < 40


        // =========================================================
        // 16. compareUnsigned() → Compare unsigned values
        // =========================================================

        int[] u1 = {10, 20, 30};
        int[] u2 = {10, 20, 40};

        System.out.println(Arrays.compareUnsigned(u1, u2));
        // Negative value because 30 < 40


        // =========================================================
        // 17. mismatch() with range
        // =========================================================

        int[] m1 = {10, 20, 30, 40};
        int[] m2 = {10, 20, 99, 40};

        System.out.println(Arrays.mismatch(m1, 0, 4, m2, 0, 4));
        // Output: 2


        // =========================================================
        // 18. setAll() → Generate values using a function
        // =========================================================

        int[] generated = new int[5];

        Arrays.setAll(generated, i -> i * 10);

        System.out.println(Arrays.toString(generated));
        // Output: [0, 10, 20, 30, 40]


        // =========================================================
        // 19. parallelSetAll() → Generate values in parallel
        // =========================================================

        int[] generated2 = new int[5];

        Arrays.parallelSetAll(generated2, i -> i * 10);

        System.out.println(Arrays.toString(generated2));
        // Output: [0, 10, 20, 30, 40]


        // =========================================================
        // 20. asList() → Convert Object array to List
        // =========================================================

        String[] names = {"Darshan", "Rahul", "Raju"};

        System.out.println(Arrays.asList(names));
        // Output: [Darshan, Rahul, Raju]


        // =========================================================
        // 21. hashCode() → Generate hash code for array
        // =========================================================

        int[] hashArray = {10, 20, 30};

        System.out.println(Arrays.hashCode(hashArray));
        // Generates hash code based on array contents


        // =========================================================
        // 22. deepHashCode() → Hash code for multidimensional array
        // =========================================================

        int[][] hash2D = {
                {10, 20},
                {30, 40}
        };

        System.out.println(Arrays.deepHashCode(hash2D));
        // Generates hash code based on nested array contents


        // =========================================================
        // 23. deepEquals() → Nested array comparison
        // =========================================================

        int[][] x = {
                {1, 2},
                {3, 4}
        };

        int[][] y = {
                {1, 2},
                {3, 4}
        };

        System.out.println(Arrays.deepEquals(x, y));
        // Output: true


        // =========================================================
        // 24. stream() → Create stream from array
        // =========================================================

        int[] streamArray = {10, 20, 30, 40};

        Arrays.stream(streamArray)
                .forEach(System.out::println);

        // Output:
        // 10
        // 20
        // 30
        // 40


        // =========================================================
        // 25. stream() → Perform calculations using Stream
        // =========================================================

        int[] numbers = {10, 20, 30, 40};

        int sum = Arrays.stream(numbers).sum();

        System.out.println(sum);
        // Output: 100


        // =========================================================
        // 26. stream().average() → Calculate average
        // =========================================================

        double average = Arrays.stream(numbers).average().orElse(0);

        System.out.println(average);
        // Output: 25.0


        // =========================================================
        // 27. stream().max() → Find maximum
        // =========================================================

        int max = Arrays.stream(numbers).max().orElse(0);

        System.out.println(max);
        // Output: 40


        // =========================================================
        // 28. stream().min() → Find minimum
        // =========================================================

        int min = Arrays.stream(numbers).min().orElse(0);

        System.out.println(min);
        // Output: 10


        // =========================================================
        // 29. stream().count() → Count elements
        // =========================================================

        long count = Arrays.stream(numbers).count();

        System.out.println(count);
        // Output: 4


        // =========================================================
        // 30. stream().filter() → Filter elements
        // =========================================================

        Arrays.stream(numbers)
                .filter(n -> n > 20)
                .forEach(System.out::println);

        // Output:
        // 30
        // 40


        // =========================================================
        // 31. parallelPrefix() → Prefix calculation
        // =========================================================

        int[] prefix = {1, 2, 3, 4};

        Arrays.parallelPrefix(prefix, (x1, x2) -> x1 + x2);

        System.out.println(Arrays.toString(prefix));
        // Output: [1, 3, 6, 10]


        // =========================================================
        // 32. parallelPrefix() with range
        // =========================================================

        int[] prefixRange = {1, 2, 3, 4, 5};

        Arrays.parallelPrefix(
                prefixRange,
                1,
                4,
                (x1, x2) -> x1 + x2
        );

        System.out.println(Arrays.toString(prefixRange));
        // Range indexes 1 to 3 are processed


        // =========================================================
        // 33. parallelPrefix() → Multiplication example
        // =========================================================

        int[] multiply = {1, 2, 3, 4};

        Arrays.parallelPrefix(multiply, (x1, x2) -> x1 * x2);

        System.out.println(Arrays.toString(multiply));
        // Output: [1, 2, 6, 24]


        // =========================================================
        // 34. Arrays.compare() with ranges
        // =========================================================

        int[] compare1 = {10, 20, 30, 40};
        int[] compare2 = {10, 20, 50, 40};

        System.out.println(
                Arrays.compare(compare1, 0, 3, compare2, 0, 3)
        );

        // Compares only the specified ranges


        // =========================================================
        // 35. Arrays.compareUnsigned() with ranges
        // =========================================================

        int[] unsigned1 = {10, 20, 30};
        int[] unsigned2 = {10, 20, 40};

        System.out.println(
                Arrays.compareUnsigned(
                        unsigned1, 0, 3,
                        unsigned2, 0, 3
                )
        );

        // Compares specified ranges using unsigned comparison
    }
}

