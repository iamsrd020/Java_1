package polymorphism;

/*
 * POLYMORPHISM:
 *
 * Polymorphism means "many forms". The same method name can behave
 * differently depending on the object or the arguments.
 *
 * This example shows:
 * 1. Overriding: Dog and Cat provide different sound() implementations.
 * 2. Overloading: Calculator has several add() methods with different
 *    parameter lists.
 */
public class PolymorphismDemo {

    public static void main(String[] args) {
        System.out.println("OVERRIDING:");

        // The reference type is Animal, but the actual object is Dog.
        Animal animal = new Dog();
        animal.sound(); // Calls Dog's overridden sound() method.

        // The same Animal reference now points to a Cat object.
        animal = new Cat();
        animal.sound(); // Calls Cat's overridden sound() method.

        System.out.println("\nOVERLOADING:");

        // Calculator has multiple add() methods with different parameters.
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(2, 3));          // add(int, int)
        System.out.println(calculator.add(2, 3, 4));       // add(int, int, int)
        System.out.println(calculator.add(2.5, 3.5));      // add(double, double)
    }
}
