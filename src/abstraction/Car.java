package abstraction;

/*
 * Car is a child class of Vehicle.
 *
 * Vehicle says: "Every vehicle must have a start() method."
 * Car decides how a car starts.
 */
public class Car extends Vehicle {

    /*
     * @Override means that Car is providing its own implementation of the
     * abstract start() method declared in Vehicle.
     *
     * This is called method overriding.
     */
    @Override
    public void start() {
        System.out.println("Car is starting");
    }
}
