package CricleVsCylinder;
// Lớp Circle (Lớp cha)
class Circle {
    private double radius;
    private String color;

    // Constructor mặc định
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    // Constructor với tham số bán kính
    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    // Constructor với tham số bán kính và màu sắc
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Getter và Setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Tính diện tích
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}

// Lớp Cylinder (Lớp con kế thừa từ Circle)
class Cylinder extends Circle {
    private double height;

    // Constructor mặc định
    public Cylinder() {
        super(); // Gọi constructor của lớp cha
        this.height = 1.0;
    }

    // Constructor với tham số bán kính
    public Cylinder(double radius) {
        super(radius); // Gọi constructor của lớp cha
        this.height = 1.0;
    }

    // Constructor với tham số bán kính và chiều cao
    public Cylinder(double radius, double height) {
        super(radius); // Gọi constructor của lớp cha
        this.height = height;
    }

    // Constructor với tất cả các tham số
    public Cylinder(double radius, double height, String color) {
        super(radius, color); // Gọi constructor của lớp cha
        this.height = height;
    }

    // Getter và Setter cho height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Tính thể tích
    public double getVolume() {
        return getArea() * height; // Sử dụng phương thức getArea() từ lớp cha
    }

    // Ghi đè phương thức toString()
    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ", height=" + height + "]";
    }
}

// Lớp kiểm thử
public class TestInheritance {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.5, "blue");
        System.out.println(c1);
        System.out.println("Diện tích: " + c1.getArea());

        Cylinder cy1 = new Cylinder(2.5, 5.0, "green");
        System.out.println(cy1);
        System.out.println("Thể tích: " + cy1.getVolume());
    }
}
