//public class ArraysInJava {
//
//    public static void main(String[] args){
//        String[] employees = {"Darshan", "Harshitha", "Rahul", "Raju"};
//
//        int[] numbers= new int[10];
//
//        numbers = new int[]{10, 31, 20, 40, 69, 96, 90, 415, 810, 999};
//
//        System.out.println(numbers[0]);
//    }
//}

//int[] numbers = {20, 30, 40, 50, 60};
//
//numbers[0] => 20;
//numbers[20] =>  41;

public class PrintArray {

    public static void main(String[] args) {

        int[] numbers = {10, 31, 20, 40, 69};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
