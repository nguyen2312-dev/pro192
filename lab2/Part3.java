/*
 *
 * @author khoin
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("employee.txt"));
            sc.useDelimiter(";|\n");

            while (sc.hasNext()) {
                String id = sc.next();
                String name = sc.next();
                String salary = sc.next();

                System.out.println(id + ", " + name + ", " + salary);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("The system cannot find the file specified");
        }
    }
}

