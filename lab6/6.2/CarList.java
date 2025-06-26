import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CarList extends Car implements I_List {
    List<Car> list = new ArrayList<>();

    @Override
    public void addFromFile(String fName) {
        list.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s*,\\s*");
                if (parts.length >= 5) {
                    String code = parts[0];
                    String make = parts[1];
                    String owner = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    String color = parts[4];
                    Car car = new Car(code, make, owner, price, color);
                    list.add(car);
                }
            }
            System.out.println("Loaded " + list.size() + " cars from " + fName);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading from file: " + e.getMessage());
        }
    }

    @Override
    public void saveToFile(String fName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fName))) {
            for (Car car : list) {
                bw.write(car.toString());
                bw.newLine();
            }
            System.out.println("Saved " + list.size() + " cars to " + fName);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    @Override
    public int find(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addCar() {
        Car car = new Car();
        car.input();
        if (find(car.getCode()) >= 0) {
            System.out.println("Car with code " + car.getCode() + " already exists.");
        } else {
            list.add(car);
            System.out.println("Car added.");
        }
    }

    @Override
    public void findCarByMake(String make) {
        List<Car> results = list.stream()
            .filter(c -> c.getMake().equalsIgnoreCase(make))
            .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("No cars found with make: " + make);
        } else {
            results.forEach(System.out::println);
        }
    }

    @Override
    public void findCarByPartOfOwner(String owner) {
        String key = owner.toLowerCase();
        List<Car> results = list.stream()
            .filter(c -> c.getOwner().toLowerCase().contains(key))
            .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("No cars found with owner containing: " + owner);
        } else {
            results.forEach(System.out::println);
        }
    }

    @Override
    public void remove() {
        String code = Inputter.inputNonBlankStr("Enter code to remove");
        int idx = find(code);
        if (idx >= 0) {
            list.remove(idx);
            System.out.println("Car removed.");
        } else {
            System.out.println("Car not found.");
        }
    }

    @Override
    public void update() {
        String code = Inputter.inputNonBlankStr("Enter code to update");
        int idx = find(code);
        if (idx >= 0) {
            Car car = list.get(idx);
            System.out.println("Enter new details (leave blank to keep current):");
            String make = Inputter.inputStr("Make (" + car.getMake() + ")");
            String priceStr = Inputter.inputStr("Price (" + car.getPrice() + ")");
            String owner = Inputter.inputStr("Owner (" + car.getOwner() + ")");
            String color = Inputter.inputStr("Color (" + car.getColor() + ")");
            if (!make.isEmpty()) car.setMake(make);
            if (!priceStr.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceStr);
                    car.setPrice(price);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price. Keeping old value.");
                }
            }
            if (!owner.isEmpty()) car.setOwner(owner);
            if (!color.isEmpty()) car.setColor(color);
            System.out.println("Car updated.");
        } else {
            System.out.println("Car not found.");
        }
    }

    @Override
    public void sortAndPrint() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        Collections.sort(list);
        System.out.printf("%-8s %-17s %-13s %8s %-10s%n", "Code", "Make", "Owner", "Price", "Color");
        for (Car c : list) {
            System.out.printf("%-8s %-17s %-13s %8.2f %-10s%n",
                c.getCode(), c.getMake(), c.getOwner(), c.getPrice(), c.getColor());
        }
    }
}

