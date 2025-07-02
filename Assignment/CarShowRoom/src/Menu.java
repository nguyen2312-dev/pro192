import java.util.ArrayList;

public class Menu {
    public static int getChoice(ArrayList<?> options) {
        int n = options.size();

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        return Inputter.readIntWithRange("Please choose an option 1..." + n + ": ",
                1, n, "Invalid choice! Please enter a number between 1 and " + n);
    }

    public static <E> E ref_getChoice(ArrayList<E> options) {
        int response = getChoice(options);
        return options.get(response - 1);
    }
}   
