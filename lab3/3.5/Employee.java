/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khoin
 */
public class Employee {
    private String fName;
    private String lName;
    private double Salary;

    public Employee() {
    }

    public Employee(String fName, String lName, double Salary) {
        this.fName = fName;
        this.lName = lName;
        if(Salary > 0){
            this.Salary = Salary;
        }else{
            this.Salary = 0.0;
        }
    } // constructor have no return type both with parameters and without parameters 
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        if(Salary > 0.0){
            this.Salary = Salary;
        }else{
            this.Salary = 0.0;
        }
    }  
}
