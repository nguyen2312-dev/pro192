import java.util.ArrayList;

public class CarManager {
    public static void main(String[] args) {
        // Create options menu
        ArrayList<String> ops = new ArrayList<>();
        ops.add("List all brands");
        ops.add("Add a new brand");
        ops.add("Search a brand based on its ID");
        ops.add("Update a brand");
        ops.add("Save brands to the file, named brands.txt");
        ops.add("List all cars in ascending order of brand names");
        ops.add("List cars based on a part of an input brand name");
        ops.add("Add a car");
        ops.add("Remove a car based on its ID");
        ops.add("Update a car based on its ID");
        ops.add("Save cars to file, named cars.txt");
        ops.add("Exit");
        
        // Create brand list and load from file
        BrandList brandList = new BrandList();
        brandList.loadFromFile("data/brands.txt");
        
        // Create car list and load from file
        CarList carList = new CarList(brandList);
        carList.loadFromFile("data/cars.txt");
        
        int choice;
        
        System.out.println("=== MINH TRANG BMW CAR SHOWROOM MANAGEMENT SYSTEM ===");
        
        do {
            System.out.println("\n--- MAIN MENU ---");
            choice = Menu.getChoice(ops);
            
            switch (choice) {
                case 1:
                    System.out.println("\n--- LIST ALL BRANDS ---");
                    brandList.listBrands();
                    break;
                case 2:
                    System.out.println("\n--- ADD A NEW BRAND ---");
                    brandList.addBrand();
                    break;
                case 3:
                    System.out.println("\n--- SEARCH BRAND BY ID ---");
                    brandList.searchBrand();
                    break;
                case 4:
                    System.out.println("\n--- UPDATE BRAND ---");
                    brandList.updateBrand();
                    break;
                case 5:
                    System.out.println("\n--- SAVE BRANDS TO FILE ---");
                    brandList.saveToFile("data/brands.txt");
                    break;
                case 6:
                    System.out.println("\n--- LIST ALL CARS ---");
                    carList.listCars();
                    break;
                case 7:
                    System.out.println("\n--- SEARCH CARS BY BRAND NAME ---");
                    carList.printBasedBrandName();
                    break;
                case 8:
                    System.out.println("\n--- ADD A NEW CAR ---");
                    carList.addCar();
                    break;
                case 9:
                    System.out.println("\n--- REMOVE CAR ---");
                    carList.removeCar();
                    break;
                case 10:
                    System.out.println("\n--- UPDATE CAR ---");
                    carList.updateCar();
                    break;
                case 11:
                    System.out.println("\n--- SAVE CARS TO FILE ---");
                    carList.saveToFile("data/cars.txt");
                    break;
                case 12:
                    System.out.println("Thank you for using Minh Trang BMW Car Showroom Management System!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (choice != 12);
    }
}