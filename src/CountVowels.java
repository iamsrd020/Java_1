//public class CountVowels {
//    public static void main(String[] args) {
//        String str = "aeiou";
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            char ch = Character.toLowerCase(str.charAt(i));
//            if (ch == 'a' || ch == 'e' || ch == 'i' ||
//                    ch == 'o' || ch == 'u') {
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
//}

public class CountVowels {

    public static void main(String[] args){

        String str = "Harshitha";

        int vowels = 0;
        int consonants = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = Character.toLowerCase(str.charAt(i));

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowels++;
            }else {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}