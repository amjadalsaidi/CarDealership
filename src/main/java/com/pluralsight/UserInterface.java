package com.pluralsight;

import java.util.Scanner;
import java.util.List;

public class UserInterface {
private Dealership dealership;
private Scanner scanner;
public UserInterface(){
    scanner = new Scanner(System.in);
}
public void display() {
init();
    boolean running = true;
    while (running) {
        System.out.println("\nMenu");
        System.out.println("1) Find vehicles within a price range");
        System.out.println("2) Find vehicles by make / model");
        System.out.println("3) Find vehicles by year range");
        System.out.println("4) Find vehicles by color");
        System.out.println("5) Find vehicles by mileage range");
        System.out.println("6) Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7) List ALL vehicles");
        System.out.println("8) Add a vehicle");
        System.out.println("9) Remove a vehicle");
        System.out.println("99) Quit\n");
        System.out.print("Enter an choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                processGetByPriceRequest();
                break;
            case 2:
                processGetByMakeModelRequest();
                break;
            case 3:
                processGetByYearRequest();
                break;
            case 4:
                processGetByColorRequest();
                break;
            case 5:
                processGetByMileageRequest();
                break;
            case 6:
                processGetByVehicleTypeRequest();
                break;
            case 7:
                processGetAllVehiclesRequest();
                break;
            case 8:
                processAddVehicleRequest();
                break;
            case 9:
                processRemoveVehicleRequest();
                break;
            case 99:
                running = false;
                break;
            default:
                System.out.println("invalid response.");
                break;
        }
    }

scanner.close();
}
public void processGetByPriceRequest() {
    System.out.print("Enter the minimum price: ");
    double minPrice = scanner.nextDouble();
    System.out.print("Enter the maximum price: ");
    double maxPrice = scanner.nextDouble();
    List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
    displayVehicles(vehicles);
}

public void processGetByMakeModelRequest() {
    System.out.print("Enter the make: ");
    String make = scanner.nextLine();
    System.out.print("Enter the model: ");
    String model = scanner.nextLine();
    List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
    displayVehicles(vehicles);
}

public void processGetByYearRequest() {
    System.out.print("Enter the minimum year: ");
    int minYear = scanner.nextInt();
    System.out.print("Enter the maximum year: ");
    int maxYear = scanner.nextInt();
    List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
    displayVehicles(vehicles);
}

public void processGetByColorRequest() {
    System.out.print("Enter the color: ");
    String color = scanner.nextLine();
    List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
    displayVehicles(vehicles);
}

public void processGetByMileageRequest() {
    System.out.print("Enter the maximum mileage: ");
    int maxMileage = scanner.nextInt();
    List<Vehicle> vehicles = dealership.getVehiclesByMileage(maxMileage);
    displayVehicles(vehicles);
}

public void processGetByVehicleTypeRequest() {
    System.out.print("Enter the vehicle type (car, truck, SUV, van): ");
    String type = scanner.nextLine();
    List<Vehicle> vehicles = dealership.getVehiclesByType(type);
    displayVehicles(vehicles);
}

public void processGetAllVehiclesRequest() {
    List<Vehicle> vehicles = dealership.getAllVehicles();
    displayVehicles(vehicles);
}

public void processAddVehicleRequest() {
    System.out.print("Enter VIN: ");
    int vin = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Year: ");
    int year = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Make: ");
    String make = scanner.nextLine();
    System.out.print("Enter Model: ");
    String model = scanner.nextLine();
    System.out.print("Enter Vehicle Type: ");
    String vehicleType = scanner.nextLine();
    System.out.print("Enter Color: ");
    String color = scanner.nextLine();
    System.out.print("Enter Odometer: ");
    int odometer = scanner.nextInt();
    System.out.print("Enter Price: ");
    double price = scanner.nextDouble();

    Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
    dealership.addVehicle(newVehicle);
    System.out.println("Vehicle added successfully!");
}

public void processRemoveVehicleRequest() {
    System.out.print("Enter VIN of the vehicle to remove: ");
    int vin = scanner.nextInt();
    boolean removed = false;
    for (Vehicle vehicle : dealership.getAllVehicles()) {
        if (vehicle.getVin() == vin) {
            dealership.removeVehicle(vehicle);
            removed = true;
            System.out.println("Vehicle with VIN " + vin + " has been removed.");
            break;
        }
    }
    if (!removed) {
        System.out.println("No vehicle found with VIN " + vin);
    }
}

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("Vehicles found:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    private void init(){
    DealershipFileManager df = new DealershipFileManager();
   dealership =df.getDealership();
}

}
