import java.util.Scanner;

public class Inputter {
    private static Scanner sc = new Scanner(System.in);
    
    // Read a non-blank string with custom prompt and error message
    public static String readNonBlankString(String prompt, String errorMsg) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(errorMsg);
            }
        } while (input.isEmpty());
        return input;
    }
    
    // Read a positive double
    public static double readPositiveDouble(String prompt, String errorMsg) {
        double value;
        do {
            System.out.print(prompt);
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input! Please enter a number.");
                System.out.print(prompt);
                sc.nextLine();
            }
            value = sc.nextDouble();
            sc.nextLine(); // consume newline
            if (value <= 0) {
                System.out.println(errorMsg);
            }
        } while (value <= 0);
        return value;
    }
    
    // Read a string with pattern validation (for Frame ID and Engine ID)
    public static String readPattern(String prompt, String pattern, String errorMsg) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (!input.matches(pattern)) {
                System.out.println(errorMsg);
            }
        } while (!input.matches(pattern));
        return input;
    }
    
    // Read a string that must be unique (not exist in a collection)
    public static String readUniqueString(String prompt, String errorMsg, java.util.function.Predicate<String> existsChecker) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (existsChecker.test(input)) {
                System.out.println(errorMsg);
            }
        } while (existsChecker.test(input));
        return input;
    }
    
    // Read integer with range validation
    public static int readIntWithRange(String prompt, int min, int max, String errorMsg) {
        int value;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                System.out.print(prompt);
                sc.nextLine();
            }
            value = sc.nextInt();
            sc.nextLine(); // consume newline
            if (value < min || value > max) {
                System.out.println(errorMsg);
            }
        } while (value < min || value > max);
        return value;
    }
    
    // Read any string (for search operations)
    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}