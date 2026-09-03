import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    public static void main(String[] args) {

        String str = "Darshan";

        HashMap<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (frequency.containsKey(ch)) {

                frequency.put(ch, frequency.get(ch) + 1);

            } else {

                frequency.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {

            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}