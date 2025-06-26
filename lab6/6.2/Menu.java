// =========================================================
// Do NOT modify this file 
// =========================================================
import java.util.*;
import java.util.Scanner;

public class Menu extends ArrayList<String> implements I_Menu{
    public Menu(){
        super();
    }
    
    @Override
    public void addItem(String s){
        this.add(s);
        return;
    }
    
    @Override
    public int getChoice(){
        int result=0;
        for (int i=0; i<this.size()-1; i++)
            System.out.println((i+1) + ". " + this.get(i));
        System.out.println(this.get(this.size()-1));
        System.out.println("____________________________");
        System.out.println();
        System.out.print("Select 1 ... 5: ");
        Scanner sc = new Scanner(System.in);
        result = Integer.parseInt(sc.nextLine()); // get user choice

        return result;
    }
    
    @Override
    public String getChoice2(ArrayList options) {
        for (int i=0; i<options.size(); i++) {
            System.out.println("   2."+ (i+1) + "- " + options.get(i)); 
        }
            System.out.print("   Choose 2.1 or 2.2: ");
            Scanner sc = new Scanner(System.in);
            return sc.nextLine().trim().toUpperCase();
    }
    
    @Override
    public String getChoice3(ArrayList options) {
        for (int i=0; i<options.size(); i++) {
            System.out.println("   3."+ (i+1) + "- " + options.get(i)); 
        }
            System.out.print("   Choose 3.1 or 3.2: ");
            Scanner sc = new Scanner(System.in);
            return sc.nextLine().trim().toUpperCase();
    }
}
// =========================================================
// Do NOT modify this file 
// =========================================================