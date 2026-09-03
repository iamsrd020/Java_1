public class StringMethods {

    public static void main(String[] args) {

        String str = "Java Programming";

        // 1. length()
        System.out.println("1. Length: " + str.length());
        // Output: Length: 16


        // 2. toUpperCase()
        System.out.println("2. Uppercase: " + str.toUpperCase());
        // Output: Uppercase: JAVA PROGRAMMING


        // 3. toLowerCase()
        System.out.println("3. Lowercase: " + str.toLowerCase());
        // Output: Lowercase: java programming


        // 4. charAt()
        System.out.println("4. Character at index 2: " + str.charAt(2));
        // Output: Character at index 2: v


        // 5. equals()
        String str1 = "Java";
        String str2 = "Java";

        System.out.println("5. Equals: " + str1.equals(str2));
        // Output: Equals: true


        // 6. equalsIgnoreCase()
        String str3 = "java";

        System.out.println("6. Equals Ignore Case: "
                + str1.equalsIgnoreCase(str3));
        // Output: Equals Ignore Case: true


        // 7. contains()
        System.out.println("7. Contains Java: " + str.contains("Java"));
        // Output: Contains Java: true


        // 8. indexOf()
        System.out.println("8. Index of 'a': " + str.indexOf('a'));
        // Output: Index of 'a': 1


        // 9. lastIndexOf()
        System.out.println("9. Last Index of 'a': " + str.lastIndexOf('a'));
        // Output: Last Index of 'a': 11


        // 10. substring()
        System.out.println("10. Substring: " + str.substring(0, 4));
        // Output: Substring: Java


        // 11. replace()
        System.out.println("11. Replace: " + str.replace('a', 'x'));
        // Output: Replace: Jxvx Programming


        // 12. replaceAll()
        System.out.println("12. Replace All: " + str.replaceAll("a", "x"));
        // Output: Replace All: Jxvx Progrxmming


        // 13. trim()
        String str4 = " Java ";

        System.out.println("13. Trim: " + str4.trim());
        // Output: Trim: Java


        // 14. split()
        String sentence = "Java is easy";
        String[] words = sentence.split(" ");

        System.out.println("14. Split:");

        for (String word : words) {
            System.out.println(word);
        }

        // Output:
        // Java
        // is
        // easy


        // 15. startsWith()
        System.out.println("15. Starts with Java: "
                + str.startsWith("Java"));
        // Output: Starts with Java: true


        // 16. endsWith()
        System.out.println("16. Ends with Programming: "
                + str.endsWith("Programming"));
        // Output: Ends with Programming: true


        // 17. isEmpty()
        String emptyString = "";

        System.out.println("17. Is Empty: "
                + emptyString.isEmpty());
        // Output: Is Empty: true


        // 18. isBlank()
        String blankString = "   ";

        System.out.println("18. Is Blank: "
                + blankString.isBlank());
        // Output: Is Blank: true


        // 19. concat()
        String first = "Java";
        String second = " Programming";

        System.out.println("19. Concat: "
                + first.concat(second));
        // Output: Concat: Java Programming


        // 20. repeat()
        String word = "Java ";

        System.out.println("20. Repeat: "
                + word.repeat(3));
        // Output: Repeat: Java Java Java


        // 21. startsWith() with index
        System.out.println("21. Starts with 'Pro' from index 5: "
                + str.startsWith("Pro", 5));
        // Output: Starts with 'Pro' from index 5: true


        // 22. endsWith()
        System.out.println("22. Ends with 'ing': "
                + str.endsWith("ing"));
        // Output: Ends with 'ing': true


        // 23. getBytes()
        byte[] bytes = str.getBytes();

        System.out.println("23. Number of bytes: "
                + bytes.length);
        // Output: Number of bytes: 16


        // 24. toCharArray()
        char[] characters = str.toCharArray();

        System.out.println("24. Characters:");

        for (char ch : characters) {
            System.out.print(ch + " ");
        }

        System.out.println();
        // Output: J a v a   P r o g r a m m i n g


        // 25. compareTo()
        String a = "Apple";
        String b = "Banana";

        System.out.println("25. CompareTo: "
                + a.compareTo(b));
        // Output: CompareTo: -1


        // 26. compareToIgnoreCase()
        String c = "java";
        String d = "JAVA";

        System.out.println("26. CompareTo Ignore Case: "
                + c.compareToIgnoreCase(d));
        // Output: CompareTo Ignore Case: 0


        // 27. matches()
        String number = "12345";

        System.out.println("27. Contains only numbers: "
                + number.matches("\\d+"));
        // Output: Contains only numbers: true


        // 28. valueOf()
        int numberValue = 100;

        String numberString = String.valueOf(numberValue);

        System.out.println("28. ValueOf: "
                + numberString);
        // Output: ValueOf: 100


        // 29. format()
        String name = "Darshan";
        int age = 25;

        System.out.println("29. Format: "
                + String.format("Name: %s, Age: %d", name, age));
        // Output: Format: Name: Darshan, Age: 25


        // 30. strip()
        String str5 = "   Java   ";

        System.out.println("30. Strip: '"
                + str5.strip() + "'");
        // Output: Strip: 'Java'


        // 31. stripLeading()
        System.out.println("31. Strip Leading: '"
                + str5.stripLeading() + "'");
        // Output: Strip Leading: 'Java   '


        // 32. stripTrailing()
        System.out.println("32. Strip Trailing: '"
                + str5.stripTrailing() + "'");
        // Output: Strip Trailing: '   Java'
    }
}