package oops;

public class InheritanceDemo {

    // Program execution starts from the main method.
    public static void main(String[] args) {
        // Car inherits start() from Vehicle and has its own drive() method.
        System.out.println("\n========== CAR ==========");
        Car car = new Car();
        System.out.println("Inherited behavior:");
        car.start();
        System.out.println("Car-specific behavior:");
        car.drive();

        // Bike inherits start() from Vehicle and has its own ride() method.
        System.out.println("\n========== BIKE ==========");
        Bike bike = new Bike();
        System.out.println("Inherited behavior:");
        bike.start();
        System.out.println("Bike-specific behavior:");
        bike.ride();

        // Bus inherits start() from Vehicle and has its own passenger behavior.
        System.out.println("\n========== BUS ==========");
        Bus bus = new Bus();
        System.out.println("Inherited behavior:");
        bus.start();
        System.out.println("Bus-specific behavior:");
        bus.carryPassengers();

        // Truck inherits start() from Vehicle and has its own goods behavior.
        System.out.println("\n========== TRUCK ==========");
        Truck truck = new Truck();
        System.out.println("Inherited behavior:");
        truck.start();
        System.out.println("Truck-specific behavior:");
        truck.carryGoods();

        // ElectricCar inherits start() from Vehicle and has charging behavior.
        System.out.println("\n====== ELECTRIC CAR ======");
        ElectricCar electricCar = new ElectricCar();
        System.out.println("Inherited behavior:");
        electricCar.start();
        System.out.println("Electric-car-specific behavior:");
        electricCar.chargeBattery();
    }
}
