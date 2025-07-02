import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CarList extends ArrayList<Car> {
    private BrandList brandList;
    
    public CarList(BrandList bList) {
        super();
        this.brandList = bList;
    }
    
    public void loadFromFile(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) {
                System.out.println("File " + filename + " does not exist!");
                return;
            }
            
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 5) {
                    String carID = parts[0];
                    String brandID = parts[1];
                    String color = parts[2];
                    String frameID = parts[3];
                    String engineID = parts[4];
                    
                    int pos = brandList.searchID(brandID);
                    if (pos >= 0) {
                        Brand brand = brandList.get(pos);
                        Car car = new Car(carID, brand, color, frameID, engineID);
                        this.add(car);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error loading cars: " + e.getMessage());
        }
    }
    
    public void saveToFile(String filename) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename));
            for (Car car : this) {
                pw.println(car.getCarID() + ", " + car.getBrand().getBrandID() + ", " + 
                          car.getColor() + ", " + car.getFrameID() + ", " + car.getEngineID());
            }
            pw.close();
            System.out.println("Cars saved to file successfully!");
        } catch (Exception e) {
            System.out.println("Error saving cars: " + e.getMessage());
        }
    }
    
    public int searchID(String carID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchFrame(String fID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(fID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchEngine(String eID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineID().equals(eID)) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean isValidFrameID(String frameID) {
        return frameID.matches("F\\d{5}");
    }
    
    private boolean isValidEngineID(String engineID) {
        return engineID.matches("E\\d{5}");
    }
    
    public void addCar() {
        // Input Car ID with validation - must be unique
        String carID = Inputter.readUniqueString(
            "Enter Car ID: ",
            "Car ID already exists! Please enter a different ID.",
            id -> searchID(id) >= 0
        );
        
        // Choose Brand using menu
        System.out.println("Choose a brand:");
        Brand brand = brandList.getUserChoice();
        
        // Input Color - cannot be blank
        String color = Inputter.readNonBlankString(
            "Enter Color: ",
            "Color cannot be blank!"
        );
        
        // Input Frame ID with format validation and uniqueness check
        String frameID = Inputter.readUniqueString(
            "Enter Frame ID (F00000 format): ",
            "Frame ID must be in F00000 format and unique!",
            fId -> !fId.matches("F\\d{5}") || searchFrame(fId) >= 0
        );
        
        // Input Engine ID with format validation and uniqueness check
        String engineID = Inputter.readUniqueString(
            "Enter Engine ID (E00000 format): ",
            "Engine ID must be in E00000 format and unique!",
            eId -> !eId.matches("E\\d{5}") || searchEngine(eId) >= 0
        );
        
        Car newCar = new Car(carID, brand, color, frameID, engineID);
        this.add(newCar);
        System.out.println("Car added successfully!");
    }
    
    public void printBasedBrandName() {
        String partOfBrandName = Inputter.readString("Enter part of brand name: ");
        int count = 0;
        
        for (Car car : this) {
            if (car.getBrand().getBrandName().toLowerCase().contains(partOfBrandName.toLowerCase())) {
                System.out.println(car.toString());
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("No car is detected!");
        }
    }
    
    public void removeCar() {
        String removedID = Inputter.readString("Enter Car ID to remove: ");
        int pos = searchID(removedID);
        
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            Car removedCar = this.get(pos);
            this.remove(pos);
            System.out.println("Car " + removedCar.getCarID() + " has been removed.");
        }
    }
    
    public void updateCar() {
        String updatedID = Inputter.readString("Enter Car ID to update: ");
        int pos = searchID(updatedID);
        
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            // Choose Brand using menu
            System.out.println("Choose a new brand:");
            Brand brand = brandList.getUserChoice();
            
            // Input Color - cannot be blank
            String color = Inputter.readNonBlankString(
                "Enter new Color: ",
                "Color cannot be blank!"
            );
            
            // Input Frame ID with format validation and uniqueness check (excluding current car's frame ID)
            String currentFrameID = this.get(pos).getFrameID();
            String frameID = Inputter.readUniqueString(
                "Enter new Frame ID (F00000 format): ",
                "Frame ID must be in F00000 format and unique!",
                fId -> !fId.matches("F\\d{5}") || (searchFrame(fId) >= 0 && !fId.equals(currentFrameID))
            );
            
            // Input Engine ID with format validation and uniqueness check (excluding current car's engine ID)
            String currentEngineID = this.get(pos).getEngineID();
            String engineID = Inputter.readUniqueString(
                "Enter new Engine ID (E00000 format): ",
                "Engine ID must be in E00000 format and unique!",
                eId -> !eId.matches("E\\d{5}") || (searchEngine(eId) >= 0 && !eId.equals(currentEngineID))
            );
            
            this.get(pos).setBrand(brand);
            this.get(pos).setColor(color);
            this.get(pos).setFrameID(frameID);
            this.get(pos).setEngineID(engineID);
            System.out.println("Car " + updatedID + " has been updated.");
        }
    }
    
    public void listCars() {
        if (this.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }
        
        Collections.sort(this);
        for (Car car : this) {
            System.out.println(car.toString());
        }
        System.out.println("Total: " + this.size() + " car(s).");
    }
}