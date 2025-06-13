package lab5.pkg1;

import java.util.Scanner;

public class MyPolymorphism implements IPolymorphism {
    
    @Override
    public int f1(String str) {
        String[] words = str.split("\\s+");
        int count = 0;
        
        for (String word : words) {
            boolean Odd = false;
            
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                
                if (Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    
                    if (digit % 2 != 0) {
                        Odd = true;
                        break;
                    }
                }
            }
            
            if (Odd) {
                count++;
            }
        }
        
        return count;
    }
    
    @Override
    public String f2(String str) {
        String[] words = str.split("\\s+");
        String result = "";
        
        for (int i = 0; i < words.length; i++) {
            int digitCount = 0;
            
            for (int j = 0; j < words[i].length(); j++) {
                if (Character.isDigit(words[i].charAt(j))) {
                    digitCount++;
                }
            }
            
            if (digitCount >= 2) {
                result += "XYZ ";
            } else {
                result += words[i] + " ";
            }
        }
        
        if (result.length() > 0) {
            result = result.trim();
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Test f1()");
        System.out.println("2. Test f2()");
        System.out.print("Enter TC (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        IPolymorphism bobo = new MyPolymorphism();
        if (choice == 1) {
            System.out.println("OUTPUT: ");
            System.out.println(bobo.f1(s));            
        } else {
            System.out.println("OUTPUT: ");
            System.out.println(bobo.f2(s));
        }
        
    }
}
