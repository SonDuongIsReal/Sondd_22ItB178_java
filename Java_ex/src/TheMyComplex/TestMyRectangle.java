package TheMyComplex;
// Lớp MyPoint đại diện cho một điểm trong không gian 2D
class MyPoint {
    private int x, y;
    
    // Constructor
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Getter & Setter
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    
    // Phương thức toString
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Lớp MyRectangle sử dụng hai điểm để xác định hình chữ nhật
class MyRectangle {
    private MyPoint topLeft, bottomRight;
    
    // Constructor
    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    
    // Tính chiều rộng
    public int getWidth() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }
    
    // Tính chiều cao
    public int getHeight() {
        return Math.abs(bottomRight.getY() - topLeft.getY());
    }
    
    // Tính diện tích
    public int getArea() {
        return getWidth() * getHeight();
    }
    
    // Tính chu vi
    public int getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }
    
    // Phương thức toString
    public String toString() {
        return "MyRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]";
    }
}

// Lớp TestMyRectangle để kiểm thử các phương thức
public class TestMyRectangle {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(2, 5);
        MyPoint p2 = new MyPoint(8, 1);
        
        MyRectangle rect = new MyRectangle(p1, p2);
        
        System.out.println(rect);
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Height: " + rect.getHeight());
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());
    }
}
