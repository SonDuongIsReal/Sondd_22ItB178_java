package MyRectangleAndMyPoint;


class MyPoint {
    private int x, y;
    
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    
    public double distance(MyPoint another) {
        return Math.sqrt(Math.pow(this.x - another.x, 2) + Math.pow(this.y - another.y, 2));
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class MyRectangle {
    private MyPoint topLeft;
    private MyPoint bottomRight;
    
    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    
    public MyPoint getTopLeft() { return topLeft; }
    public void setTopLeft(MyPoint topLeft) { this.topLeft = topLeft; }
    
    public MyPoint getBottomRight() { return bottomRight; }
    public void setBottomRight(MyPoint bottomRight) { this.bottomRight = bottomRight; }
    
    public double getWidth() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }
    
    public double getHeight() {
        return Math.abs(bottomRight.getY() - topLeft.getY());
    }
    
    public double getArea() {
        return getWidth() * getHeight();
    }
    
    public double getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }
    
    @Override
    public String toString() {
        return "MyRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]";
    }
}

public class TestMyRectangle {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(1, 5);
        MyPoint p2 = new MyPoint(6, 2);
        
        MyRectangle rect = new MyRectangle(p1, p2);
        
        System.out.println(rect);
        System.out.println("Width: " + rect.getWidth());
        System.out.println("Height: " + rect.getHeight());
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());
    }
}
