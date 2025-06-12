import java.util.Scanner;

public class MyPolymorphism implements IPolymorphism {
    @Override
    public int f1(String str) {
        String[] words = str.split("\\s+");
        int maxLength = 0;
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
    }

    @Override
    public double f2(String str) {
        int sum = 0;
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if (digit % 2 == 0) {
                    sum += digit;
                    count++;
                }
            }
        }
        return count == 0 ? 0.0 : (double) sum / count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Test f1()");
        System.out.println("2. Test f2()");
        System.out.print("Enter TC (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        IPolymorphism obj = new MyPolymorphism();
        if (choice == 1) {
            System.out.println(obj.f1(input));
        } else {
            System.out.println(obj.f2(input));
        }
    }
}
