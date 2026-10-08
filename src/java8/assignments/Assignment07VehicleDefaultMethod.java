package java8.assignments;

public class Assignment07VehicleDefaultMethod {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start();
    }

    private interface Vehicle {
        default void start() {
            System.out.println("Vehicle is starting.");
        }
    }

    private static class Car implements Vehicle {
    }
}
