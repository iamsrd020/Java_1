package abstraction;

/*
 * ABSTRACTION:
 *
 * Abstraction means showing only the important details and hiding the
 * implementation details.
 *
 * Real-life example:
 * When we drive a car, we use the steering wheel, brake, and accelerator.
 * We do not need to know how the engine works internally.
 *
 * An abstract class is an incomplete parent class. It defines a common rule
 * for child classes, but it does not provide every implementation detail.
 */
public abstract class Vehicle {

    /*
     * This is an abstract method:
     * - It has no method body.
     * - It defines what every vehicle must do.
     * - Each child class must decide how it starts.
     *
     * Since Vehicle is abstract, this is not allowed:
     *
     *     Vehicle vehicle = new Vehicle();
     *
     * We cannot create an object from an incomplete abstract class.
     */
    public abstract void start();
}
