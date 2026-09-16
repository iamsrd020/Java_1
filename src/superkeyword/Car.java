package superkeyword;

/*
 * Car extends Vehicle, so it inherits Vehicle's brand and start().
 *
 * Car also declares its own brand field to demonstrate the difference between
 * the child field (brand) and the parent field (super.brand).
 */
public class Car extends Vehicle {

    private String brand;

    public Car(String vehicleBrand, String carBrand) {
        super(vehicleBrand); // Calls Vehicle's constructor.
        this.brand = carBrand;
    }

    @Override
    public void start() {
        System.out.println("Car is starting");

        // Accesses the parent class's brand field.
        System.out.println("Parent brand: " + super.brand);

        // Accesses Car's own brand field.
        System.out.println("Car brand: " + brand);

        // Calls the parent class's start() method.
        super.start();
    }
}
