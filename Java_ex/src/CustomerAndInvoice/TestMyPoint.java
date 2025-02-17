class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXY() {
        return new int[]{x, y};
    }

    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public double distance(MyPoint another) {
        return distance(another.getX(), another.getY());
    }

    public double distance() {
        return distance(0, 0);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Test class
public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(3, 4);
        MyPoint p2 = new MyPoint(6, 8);

        System.out.println(p1);
        System.out.println("Distance from p1 to (6,8): " + p1.distance(6, 8));
        System.out.println("Distance from p1 to p2: " + p1.distance(p2));
        System.out.println("Distance from p1 to origin: " + p1.distance());
    }
}
