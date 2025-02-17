package MyCircle;


public class TestMyCircle {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle();
        System.out.println("Circle 1: " + c1);
        System.out.println("Area of Circle 1: " + c1.getArea());
        System.out.println("Circumference of Circle 1: " + c1.getCircumference());

        MyCircle c2 = new MyCircle(3, 4, 5);
        System.out.println("Circle 2: " + c2);
        System.out.println("Distance from Circle 1 to Circle 2: " + c1.distance(c2));

        MyPoint p = new MyPoint(7, 8);
        MyCircle c3 = new MyCircle(p, 6);
        System.out.println("Circle 3: " + c3);

        c3.setRadius(10);
        System.out.println("Updated Circle 3: " + c3);
        System.out.println("New Area of Circle 3: " + c3.getArea());
    }
}
