package abstraction;

/*
 * This class contains the main method, where program execution begins.
 *
 * Execution flow:
 * 1. Create a complete Car object.
 * 2. Call car.start().
 * 3. Java runs the start() implementation from Car.
 *
 * We create a Car object instead of a Vehicle object because Vehicle is
 * abstract and abstract classes cannot be instantiated directly.
 */
public class AbstractionDemo {

    public static void main(String[] args) {
        // Car is complete because it has implemented Vehicle.start().
        Car car = new Car();

        // Output: Car is starting
        car.start();
    }
}
