// =========================================================
// Do NOT modify this file 
// =========================================================
//Interface for a group of objects
public interface I_List {
    void addFromFile(String fName);
    void saveToFile(String fName);
    int find(String code);
    void addCar(); 
    void findCarByMake(String make);
    void findCarByPartOfOwner(String owner);
    void remove();
    void update();
    void sortAndPrint();
}
// =========================================================
// Do NOT modify this file 
// =========================================================