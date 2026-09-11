package oops;

public class Encapsulation {

    public static void main(String[] args) {

        Student student = new Student();

        // Data is changed through methods instead of direct field access.
        student.setName("Darshan");
        student.setAge(25);

        // This invalid value is ignored by setAge().
        student.setAge(-5);

        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
    }
}


//Encapsulation means::
//Keeping data private and allowing access through methods.