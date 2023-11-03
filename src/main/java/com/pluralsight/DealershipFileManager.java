package com.pluralsight;
import java.io.*;
import java.util.List;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership1 = null;
        String Line;
        int LineNumber = 1;

        try {
            BufferedReader br = new BufferedReader(new FileReader("dealership.csv"));
            String line = br.readLine();
            String[] pipes = line.split("\\|");
            String name = pipes[0];
            String adress = pipes[1];
            String phoneNumber = pipes[2];
         dealership1 = new Dealership(name, adress, phoneNumber);
            List<Vehicle> vehicles = dealership1.getAllVehicles();
      while ((line =br.readLine())!=null){
          String[] tokens = line.split("\\|");
           int vin = Integer.parseInt(tokens[0]);
           int year = Integer.parseInt(tokens[1]);
           String make = tokens[2];
           String model = tokens[3];
           String vehicleType = tokens[4];
           String color = tokens[5];
           int odometer = Integer.parseInt(tokens[6]);
           double price = Double.parseDouble(tokens[7]);
           dealership1.addVehicle(new Vehicle(vin, year,make,model,vehicleType,color,odometer,price));
            }
      br.close();





        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return dealership1;

    }
    public void saveDealership (Dealership  dealership){
        
    }
}


