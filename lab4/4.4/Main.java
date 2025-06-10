import java.util.Scanner;
/**
 *
 * @author khoin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code: ");
        String nCode = sc.nextLine().toLowerCase().trim();
        System.out.print("Enter price: ");
        int nPrice = Integer.parseInt(sc.nextLine());
        System.out.print("Enter color: ");
        int nColor = Integer.parseInt(sc.nextLine());
        Item it = new SpecItem(nColor, nCode, nPrice);
        System.out.println("1. Test outputSpecItem()");
        System.out.println("2. Test setData()");
        System.out.println("3. Test getValue()");
        System.out.print("Enter TC (1,2,3): ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("OUTPUT: ");
                ((SpecItem) it).outputSpecItem();
                break;
            case 2:
                System.out.println("OUTPUT: ");
                ((SpecItem) it).setData();
                it.outputItem();
                break;
            case 3:
                System.out.println("OUTPUT: ");
                int price = ((SpecItem) it).getValue();
                System.out.println(price);
                break;
        }
    }
}
