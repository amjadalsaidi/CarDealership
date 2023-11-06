package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle>getVehiclesByPrice (double min, double max) {
        List<Vehicle> smallvehicles = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                smallvehicles.add(v);
            }
        }
        return smallvehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> smallvehicles = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getModel().equals(model) && v.getMake().equals(make)) {
                smallvehicles.add(v);
            }
        }
        return smallvehicles;
    }


    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> smallvehicles = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= min && v.getYear() <= max) {
                smallvehicles.add(v);
            }
        }
        return smallvehicles;
    }



    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> smallvehicles = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equals(color)) {
                smallvehicles.add(v);
            }
        }
        return smallvehicles;
    }
    public List<Vehicle> getVehiclesByMileage(int odometer) {
        List<Vehicle> smallvehicles = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() <= odometer) {
                smallvehicles.add(v);
            }
        }
        return smallvehicles;
    }

    public  List<Vehicle> getVehiclesByType(String type) {
            List<Vehicle> smallvehicles = new ArrayList<>();
            for (Vehicle v:inventory){
                if(v.getVehicleType().equals(type)){
                    smallvehicles.add(v);
                }
            }
            return smallvehicles;
    }
     public  List<Vehicle> getAllVehicles() {
         return this.inventory;
     }

        public void addVehicle(Vehicle vehicle) {
            this.inventory.add(vehicle);

        }
            public void removeVehicle(Vehicle vehicle){
inventory.remove(vehicle);
             }

         }




