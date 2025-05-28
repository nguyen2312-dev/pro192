    import java.util.Scanner;
    /**
     *
     * @author khoin
     */
    public class Part4 {
        public static void main(String[] args){
            Scanner sc1 = new Scanner(System.in);

            String name = ""; float grade;
            System.out.println("Input Student's  information:");
            System.out.println("Enter name: ");
            name = sc1.nextLine();
            System.out.println("Enter grade: ");
            grade = sc1.nextFloat();

            Scanner sc2 = new Scanner(name);
            System.out.println("Output Student's information: ");
            while(sc2.hasNext()){
                String word = sc2.next();
                if(word.length() > 0){
                    String result = word.substring(0, 1).toUpperCase() + 
                                    word.substring(1).toLowerCase();
                    System.out.print(result +" ");
                }
            }
            System.out.print("," +grade);
            System.out.println("");
        }
    }
