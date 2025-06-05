/*ASSIGNMENT 2:CAR RENTAL SYSTEM USING OBJECT-ORIENTED PROGRAMMING PRINCIPLES(JAVA)*/
Name:Abigail Muthoni
Adm no:BBIT-05-0019/2024
Campus:TRC
Git Username:Abigail056   
   
import java.util.*;

// Represents a car with an ID, model name, and availability status
class Car {
    private String carId;
    private String model;
    private boolean isAvailable;

    public Car(String carId, String model) {
        this.carId = carId;
        this.model = model;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        this.isAvailable = false;
    }

    public void returnCar() {
        this.isAvailable = true;
    }

    public String toString() {
        return carId + " - " + model + " (" + (isAvailable ? "Available" : "Rented") + ")";
    }
}

// Represents a customer with an ID and name
class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return customerId + " - " + name;
    }
}

// Core agency class that manages cars and customers
class RentalAgency {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(String customerId, String carId) {
        Customer customer = findCustomer(customerId);
        Car car = findCar(carId);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        if (!car.isAvailable()) {
            System.out.println("Car is already rented.");
            return;
        }

        car.rent();
        System.out.println(customer.getName() + " has rented " + car.getModel());
    }

    public void returnCar(String carId) {
        Car car = findCar(carId);
        if (car != null && !car.isAvailable()) {
            car.returnCar();
            System.out.println("Car returned: " + car.getModel());
        } else {
            System.out.println("Car not found or not rented.");
        }
    }

    public void listCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void listCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private Car findCar(String id) {
        for (Car car : cars) {
            if (car.getCarId().equals(id)) return car;
        }
        return null;
    }

    private Customer findCustomer(String id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) return customer;
        }
        return null;
    }
}

// Console-based UI to interact with the rental system
public class CarRentalSystem {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        agency.addCar(new Car("C1", "Toyota Corolla"));
        agency.addCar(new Car("C2", "Honda Civic"));
        agency.addCustomer(new Customer("CU1", "Alice"));
        agency.addCustomer(new Customer("CU2", "Bob"));

        boolean running = true;
        while (running) {
            System.out.println("\n1. List Cars\n2. List Customers\n3. Rent Car\n4. Return Car\n5. Exit");
            System.out.print("Choose an option: ");

            // Check if the user entered an integer
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // consume invalid input
                continue;
            }

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    agency.listCars();
                    break;
                case 2:
                    agency.listCustomers();
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter Car ID: ");
                    String carId = scanner.nextLine();
                    agency.rentCar(customerId, carId);
                    break;
                case 4:
                    System.out.print("Enter Car ID: ");
                    String returnId = scanner.nextLine();
                    agency.returnCar(returnId);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}

