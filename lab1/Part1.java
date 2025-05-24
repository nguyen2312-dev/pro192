import java.util.Scanner;
/**
 *
 * @author khoin
 */
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        int rows;
        int cols;
        int matrix[][];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        rows = sc.nextInt();

        System.out.print("Enter number of rows: ");
        cols = sc.nextInt();

        matrix = new int[rows][cols];

        System.out.print("Enter the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("\n[" + i + "]" + "[" + j + "]=");
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix inputted:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.format("%3d", matrix[i][j]);
            }
            System.out.println("\n");
        }
    }
}