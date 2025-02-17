package MyTriangle;


public class TestMyTriangle {
    public static void main(String[] args) {
        MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 0, 4);
        System.out.println("Triangle 1: " + t1);
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("Type: " + t1.getType());

        MyPoint p1 = new MyPoint(1, 1);
        MyPoint p2 = new MyPoint(4, 1);
        MyPoint p3 = new MyPoint(1, 5);
        MyTriangle t2 = new MyTriangle(p1, p2, p3);

        System.out.println("Triangle 2: " + t2);
        System.out.println("Perimeter: " + t2.getPerimeter());
        System.out.println("Type: " + t2.getType());
    }
}
