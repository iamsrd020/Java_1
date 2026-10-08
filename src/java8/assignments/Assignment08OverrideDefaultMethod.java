package java8.assignments;

public class Assignment08OverrideDefaultMethod {
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
        @Override
        public void start() {
            System.out.println("Car engine started.");
        }
    }
}
