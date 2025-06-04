/**
 *
 * @author khoin
 */
public class EmployeeTest {
    public static void main(String [] args){
        Employee em1 = new Employee("David", "Mainson", 7500000);
        Employee em2 = new Employee("Kimber", "Lyn", -9500000);
        
        System.out.printf("%s %s month salary is: %.1f\n", em1.getfName(), em1.getlName(), em1.getSalary());
        System.out.printf("%s %s month salary is: %.1f\n", em2.getfName(), em2.getlName(), em2.getSalary());
        
        //increase salary
        // em1.setSalary(em1.getSalary() * 1.1);
        // em2.setSalary(em2.getSalary() * 1.1);
        //raise salary by a method not in main

        em1.raiseSalary();
        em2.raiseSalary();
        
        
        System.out.println("\nEmployee salary after raise 10% is \n");
        System.out.printf("%s %s month salary is: %.1f\n", em1.getfName(), em1.getlName(), em1.getSalary());
        System.out.printf("%s %s month salary is: %.1f\n", em2.getfName(), em2.getlName(), em2.getSalary());
    }
}
