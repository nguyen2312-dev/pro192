import java.io.*;
import java.util.ArrayList;

public class BrandList extends ArrayList<Brand> {
    
    public BrandList() {
        super();
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
                if (parts.length >= 3) {
                    String brandID = parts[0];
                    String brandName = parts[1];
                    String[] soundPrice = parts[2].split(": ");
                    String soundBrand = soundPrice[0];
                    double price = Double.parseDouble(soundPrice[1]);
                    
                    Brand brand = new Brand(brandID, brandName, soundBrand, price);
                    this.add(brand);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error loading brands: " + e.getMessage());
        }
    }
    
    public void saveToFile(String filename) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename));
            for (Brand brand : this) {
                pw.println(brand.toString());
            }
            pw.close();
            System.out.println("Brands saved to file successfully!");
        } catch (Exception e) {
            System.out.println("Error saving brands: " + e.getMessage());
        }
    }
    
    public int searchID(String bID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandID().equals(bID)) {
                return i;
            }
        }
        return -1;
    }
    
    public Brand getUserChoice() {
        return Menu.ref_getChoice(this);
    }
    
    public void addBrand() {
        // Input Brand ID with validation - must be unique
        String id = Inputter.readUniqueString(
            "Enter Brand ID: ",
            "Brand ID already exists! Please enter a different ID.",
            brandId -> searchID(brandId) >= 0
        );
        
        // Input Brand Name - cannot be blank
        String name = Inputter.readNonBlankString(
            "Enter Brand Name: ",
            "Brand name cannot be blank!"
        );
        
        // Input Sound Brand - cannot be blank
        String sound = Inputter.readNonBlankString(
            "Enter Sound Brand: ",
            "Sound brand cannot be blank!"
        );
        
        // Input Price - must be positive
        double price = Inputter.readPositiveDouble(
            "Enter Price: ",
            "Price must be positive!"
        );
        
        Brand newBrand = new Brand(id, name, sound, price);
        this.add(newBrand);
        System.out.println("Brand added successfully!");
    }
    
    public void updateBrand() {
        String brandID = Inputter.readString("Enter Brand ID to update: ");
        int pos = searchID(brandID);
        
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            // Input Brand Name - cannot be blank
            String name = Inputter.readNonBlankString(
                "Enter new Brand Name: ",
                "Brand name cannot be blank!"
            );
            
            // Input Sound Brand - cannot be blank
            String sound = Inputter.readNonBlankString(
                "Enter new Sound Brand: ",
                "Sound brand cannot be blank!"
            );
            
            // Input Price - must be positive
            double price = Inputter.readPositiveDouble(
                "Enter new Price: ",
                "Price must be positive!"
            );
            
            this.get(pos).setBrandName(name);
            this.get(pos).setSoundBrand(sound);
            this.get(pos).setPrice(price);
            System.out.println("Brand updated successfully!");
        }
    }
    
    public void listBrands() {
        if (this.isEmpty()) {
            System.out.println("No brands available.");
            return;
        }
        
        for (Brand brand : this) {
            System.out.println(brand.toString());
        }
        System.out.println("Total: " + this.size() + " brand(s).");
    }
    
    public void searchBrand() {
        String brandID = Inputter.readString("Enter Brand ID to search: ");
        int pos = searchID(brandID);
        
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            System.out.println("Brand found: " + this.get(pos).toString());
        }
    }
}
