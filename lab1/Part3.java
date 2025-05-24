import java.util.Scanner;
/**
 *
 * @author khoin
 */
public class Part3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] list = new String[10];
        System.out.println("Input student name: ");
        for(int i = 0; i < 10; i++){
            list[i] = sc.nextLine();
        }
        for(int i = 0; i < list.length; i++){
            list[i] = list[i].toUpperCase();
            System.out.println(list[i]);
        }
    }
}
