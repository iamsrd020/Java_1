public class Palindrome {

    public static void main(String[] args){

        String name = "CIVIC";
        String reversed = "";

        for(int i = name.length() - 1; i >= 0; i--) {
            reversed = reversed + name.charAt(i);
        }
        if (name.equals(reversed)){
            System.out.println("Palindrome || True");
        }else {
            System.out.println("Not palindrome || False");
        }
    }
}
