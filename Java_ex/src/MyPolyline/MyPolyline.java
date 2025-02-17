package MyPolyline;
import java.util.*;
public class MyPolyline {
   public static class Point {
      private int x; 
      private int y;  
      public Point(int x, int y) {
         this.x = x;
         this.y = y;
      }
      public int getX() {
         return x;
      }

      public int getY() {
         return y;
      }

      public void setX(int x) {
         this.x = x;
      }
      public void setY(int y) {
         this.y = y;
      }
      public int[] getXY() {
         return new int[] { x, y };
      }
      public void setXY(int x, int y) {
         this.x = x;
         this.y = y;
      }
      public String toString() {
         return "(" + x + "," + y + ")";
      }
      public double distance(Point other) {
         int dx = this.x - other.x;
         int dy = this.y - other.y;
         return Math.sqrt(dx * dx + dy * dy);  // Áp dụng định lý Pythagoras
      }
   }
   private List<Point> points;  
   public MyPolyline() {
      points = new ArrayList<Point>();  
   }

   public MyPolyline(List<Point> points) {
      this.points = points;
   }
   public void appendPoint(int x, int y) {
      Point newPoint = new Point(x, y);
      points.add(newPoint);
   }
   public void appendPoint(Point point) {
      points.add(point);
   }
   public String toString() {
      StringBuilder sb = new StringBuilder("{");
      for (Point aPoint : points) {
         sb.append(aPoint.toString());
      }
      sb.append("}");
      return sb.toString();
   }
   public double getLength() {
      double length = 0.0;
      for (int i = 0; i < points.size() - 1; i++) {
         length += points.get(i).distance(points.get(i + 1));
      }
      return length;
   }
   public static void main(String[] args) {
      MyPolyline l1 = new MyPolyline();
      System.out.println(l1);  // In ra "{}"
      l1.appendPoint(new Point(1, 2));
      l1.appendPoint(3, 4);
      l1.appendPoint(5, 6);
      System.out.println(l1);  
      List<Point> points = new ArrayList<Point>();
      points.add(new Point(11, 12));
      points.add(new Point(13, 14));
      MyPolyline l2 = new MyPolyline(points);
      System.out.println(l2);  // In ra "{(11,12)(13,14)}"
      System.out.println("Chieu dai polyline l2: " + l2.getLength());
   }
}
