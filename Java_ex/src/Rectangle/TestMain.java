package Rectangle;


import java.util.ArrayList;
import java.util.Collections;

class Circle implements Comparable<Circle> {
    private double radius = 1.0;
    private String color = "red"; // Default color

    // Constructors
    public Circle() {
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public Circle(double radius, String color) {
        setRadius(radius);
        this.color = color;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius with validation
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Setter for color
    public void setColor(String color) {
        this.color = color;
    }

    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // toString method
    @Override
    public String toString() {
        return "Circle - Radius: " + radius + ", Area: " + getArea() + ", Color: " + color;
    }

    // Method to compare two circles based on radius
    @Override
    public int compareTo(Circle other) {
        return Double.compare(this.radius, other.radius);
    }
}

// Test driver class
public class TestMain {
    public static void main(String[] args) {
        // Test Constructors and toString()
        Circle c1 = new Circle(1.0);
        System.out.println("Circle 1 - " + c1); // toString()

        Circle c2 = new Circle(5.0);
        System.out.println("Circle 2 - " + c2);

        // Change color
        c2.setColor("blue");
        System.out.println("Circle 2 new color: " + c2.getColor());

        // Test list of Circles and sorting
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(3.0));
        circles.add(new Circle(1.5));
        circles.add(new Circle(2.5));

        System.out.println("Before sorting: " + circles);
        Collections.sort(circles);
        System.out.println("After sorting: " + circles);
    }
}
