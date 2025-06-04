import java.util.Scanner;
/**
 *
 * @author khoin
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        
        System.out.println("Enter quantity: ");
        int quantity = sc.nextInt();
        
        items item = new items(name, quantity);
        System.out.println("1. Test getName()\n2. Test setQuantity()");
        System.out.println("Enter TC (1 or 2): ");
        int valid = sc.nextInt();
        if(valid == 1){
            System.out.println("OUTPUT\n"+item.getName().toUpperCase());
        }else if(valid == 2){
            System.out.println("Enter new quantity: ");
            int new_quantity = sc.nextInt();
            item.setQuantity(new_quantity);
            System.out.println("OUTPUT\n"+item.getQuantity());
        }
    }
}
