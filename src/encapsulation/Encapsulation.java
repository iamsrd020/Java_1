package encapsulation;

/*
 * ENCAPSULATION:
 *
 * Encapsulation means keeping data private and allowing access through
 * controlled methods. This protects an object's data from invalid changes.
 *
 * In this example, Student's name and age are private. The setter methods
 * control how those values are changed, and setAge() rejects invalid values.
 */
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