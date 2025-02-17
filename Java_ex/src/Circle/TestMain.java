package Circle;

class Circle {
    private double radius = 1.0;
    private String color = "red"; // Default color

    // Constructors
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
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
    }
}
