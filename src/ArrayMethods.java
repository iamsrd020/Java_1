import java.util.*;

public class ArrayMethods{
    public static void main(String[] args){

        int[] arr = {10, 20, 30, 40};
        System.out.println(Arrays.toString(arr));

        //===========================================================

        int[] arr1 = {333,10,54,85,89,75,66,69,54};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        //=========================================================

        int[] a = {10,20,30};
        int[] b = {10,20,30};
        int[] c = {11,22,33};

        String[] name1 = {"Darshan", "Harshitha"};
        String[] name2 = {"Darshan", "Harshitha"};
        String[] name3 = {"Darshan"};
        System.out.println(Arrays.equals(name1, name2));

        String name4 = "Darshan";
        String name5 = "Harshitha";

        System.out.println(name4.equals(name5));

        //============================================================

        int[] arr3 = new int[6];
        Arrays.fill(arr3, 69);
        System.out.println(Arrays.toString(arr3));

        //====================================================

        int[] numbers = {10,20,30,40};
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        copy[3] = 69;
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(copy));

        //===========================================================


    }
}
