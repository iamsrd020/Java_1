public class LargestNumber {

    public static void main(String[] args) {

        int[] numbers = {10, 31, 20, 40, 69, 96, 900};

        int largest = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        System.out.println("Largest number: " + largest);
    }
}

/**
int largest = numbers[0];

for (int i = 1; i < numbers.length; i++) {
        if (numbers[i] > largest) {
largest = numbers[i];
        }
        }

        System.out.println(largest);**/