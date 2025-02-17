package MyLineAndMyPoint;
public class TestMyLine {
    public static void main(String[] args) {
        MyLine line1 = new MyLine(1, 2, 5, 6);
        System.out.println(line1);

        MyPoint p1 = new MyPoint(3, 4);
        MyPoint p2 = new MyPoint(7, 8);
        MyLine line2 = new MyLine(p1, p2);
        
        System.out.println("Line 2: " + line2);
        System.out.println("Length of line2: " + line2.getLength());
        System.out.println("Gradient of line2: " + line2.getGradient());

        line2.setEndXY(10, 12);
        System.out.println("Updated Line 2: " + line2);
        System.out.println("New Length of line2: " + line2.getLength());
    }
}
