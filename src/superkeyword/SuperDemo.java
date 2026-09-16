package superkeyword;

/*
 * This class runs the super assignment.
 *
 * The Car object has:
 * - a parent Vehicle brand: "Toyota"
 * - its own Car brand: "Toyota Camry"
 *
 * Car overrides start(), but uses super.brand and super.start() to access
 * the parent's field and method.
 */
public class SuperDemo {

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Toyota Camry");
        car.start();
    }
}
