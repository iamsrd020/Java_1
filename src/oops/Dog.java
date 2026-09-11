package oops;

// Dog overrides the sound() method of Animal.
public class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks.");
    }
}
