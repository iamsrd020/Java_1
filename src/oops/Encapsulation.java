package oops;

public class Encapsulation {

    public static void main(String[] args) {

        Student student = new Student();

        student.setName("Darshan");
        student.setAge(25);

        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}
