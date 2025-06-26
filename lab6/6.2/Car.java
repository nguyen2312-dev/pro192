
// public class Car extends Item implements Comparable<Car> {  
//     //    Your code is here!

//     @Override
//     public int compareTo(Car obj) {       
//         //    Your code is here!
//         return 0;
//     }     
// }

public class Car extends Item implements Comparable<Car> {
    private String owner;
    private double price;
    private String color;

    public Car() {
        super();
        this.owner = "";
        this.price = 0.0;
        this.color = "";
    }

    public Car(String code, String make, String owner, double price, String color) {
        super(code, make);
        this.owner = owner;
        this.price = price;
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void input() {
        super.input();
        this.owner = Inputter.inputNonBlankStr("Enter owner: ");
        this.price = Inputter.inputDouble("Enter price: ");
        this.color = Inputter.inputNonBlankStr("Enter color: ");
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %.2f, %s",
                getCode(),
                getMake(), 
                owner,
                price,
                color);
    }

    @Override
    public int compareTo(Car obj) {
        return this.getCode().compareTo(obj.getCode());
    }
}
