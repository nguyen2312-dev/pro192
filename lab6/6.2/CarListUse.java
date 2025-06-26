// =========================================================
// Do NOT modify this file 
// =========================================================
import java.util.ArrayList;
import java.util.Scanner;

public class CarListUse {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String filename = "data.dat";
        I_Menu menu = new Menu();
        menu.addItem("Add Car");
        menu.addItem("Search Car");
        menu.addItem("Update/Delete Car");
        menu.addItem("Print list");
        menu.addItem("Save to file");
        menu.addItem("Others: Quit");
        int choice;
        String choice2 = null;
        String choice3 = null;
        boolean quit = false;
        I_List list = new CarList();
        list.addFromFile(filename); // load initial data
        do {
            System.out.println("____________________________");
            System.out.println("\n       CAR MANAGER");
            System.out.println();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.addCar();
                    break;
                case 2:
                    ArrayList<String> list2 = new ArrayList<>();
                    do {
                        list2.clear();
                        list2.add("Seach by make");
                        list2.add("Seach by part of owner");
                        choice2 = menu.getChoice2(list2);
                        switch (choice2) {
                            case "2.1":
                                System.out.print("   Enter make: ");
                                String make = sc.nextLine();
                                list.findCarByMake(make);
                                break;
                            case "2.2":
                                System.out.print("   Enter part of owner: ");
                                String owner = sc.nextLine();
                                list.findCarByPartOfOwner(owner);
                                break;
                            default:
                                quit = true;
                        }
                    } while (!quit);
                    break;
                case 3:
                    ArrayList<String> list3 = new ArrayList<>();
                    do {
                        list3.clear();
                        list3.add("Update a Car");
                        list3.add("Delete a Car");
                        choice3 = menu.getChoice3(list3);
                        switch (choice3) {
                            case "3.1":
                                list.update();
                                break;
                            case "3.2":
                                list.remove();
                                break;
                            default:
                                quit = true;
                        }
                    } while (!quit);
                    break;
                case 4:
                    list.sortAndPrint();
                    break;
                case 5:
                    list.saveToFile(filename);
                    break;
            }
        } while (choice > 0 && choice <= 5);
        sc.close();
    }
}
// =========================================================
// Do NOT modify this file 
// =========================================================