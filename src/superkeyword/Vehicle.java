package superkeyword;

/*
 * SUPER KEYWORD:
 *
 * super refers to the immediate parent class.
 *
 * Common uses of super:
 * 1. super.variable accesses a parent field when the child has a field with
 *    the same name.
 * 2. super.method() calls the parent version of an overridden method.
 * 3. super(...) calls a parent constructor.
 *
 * The parent Vehicle stores a general brand and provides common start()
 * behavior.
 */
public class Vehicle {

    protected String brand;

    public Vehicle(String brand) {

        this.brand = brand;
    }

    public void start() {

        System.out.println("Vehicle is starting");
    }
}
