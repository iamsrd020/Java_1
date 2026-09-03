//Input : Darshan
//Output : nahsraD

//for(int i = 0; i < name.length(); i++)

public class ReverseString {
    public static void main(String[] args){
        String name = "Darshan";
        String reversed = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reversed = reversed + name.charAt(i);
        }
            System.out.println("Original String : " + name + " ❌ ");
            System.out.println("Reversed String : " + reversed + " ✅ ");

        }
    }

