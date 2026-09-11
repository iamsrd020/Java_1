package oops;

// Cat overrides the sound() method of Animal.
public class Cat extends Animal {

    @Override
    public void sound() {
        System.out.println("Cat meows.");
    }
}
