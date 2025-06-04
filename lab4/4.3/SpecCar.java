/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khoin
 */
public class SpecCar extends Car {

    private String color;

    public SpecCar() {
    }

    public SpecCar(String color) {
        this.color = color;
    }

    public SpecCar(String color, String owner, float price) {
        super(owner, price);
        this.color = color;
    }

    public void setData() {
        String owner = getOwner();
        String[] words = owner.split(" ");
        StringBuilder formatted = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                formatted.append(capitalized).append(" ");
            }
        }

        if (formatted.length() > 0) {
            formatted.setLength(formatted.length() - 1);
        }

        setOwner(formatted.toString());
    }

    public float getValue() {
        if (color.equalsIgnoreCase("silver")) {
            return getPrice() - (getPrice() * 0.1f);
        } else {
            return getPrice();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color;
    }

}
