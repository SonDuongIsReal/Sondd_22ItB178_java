package ShapePolymorphism;
// Lớp cha Shape
abstract class Shape {
    protected String color;

    // Constructor
    public Shape(String color) {
        this.color = color;
    }

    // Phương thức trừu tượng
    public abstract double getArea();

    // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "Shape[color=" + color + "]";
    }
}

// Lớp Rectangle kế thừa từ Shape
class Rectangle extends Shape {
    private int length, width;

    // Constructor
    public Rectangle(String color, int length, int width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    // Cài đặt phương thức getArea()
    @Override
    public double getArea() {
        return length * width;
    }

    // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "Rectangle[length=" + length + ", width=" + width + ", color=" + color + "]";
    }
}

// Lớp Triangle kế thừa từ Shape
class Triangle extends Shape {
    private int base, height;

    // Constructor
    public Triangle(String color, int base, int height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    // Cài đặt phương thức getArea()
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "Triangle[base=" + base + ", height=" + height + ", color=" + color + "]";
    }
}

// Lớp kiểm thử đa hình
public class TestPolymorphism {
    public static void main(String[] args) {
        Shape rect = new Rectangle("Red", 4, 5);
        Shape tri = new Triangle("Blue", 3, 6);

        System.out.println(rect);
        System.out.println("Diện tích: " + rect.getArea());

        System.out.println(tri);
        System.out.println("Diện tích: " + tri.getArea());
    }
}
