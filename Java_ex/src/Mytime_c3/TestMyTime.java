package Mytime_c3;
public class TestMyTime {
    public static void main(String[] args) {
        // Tạo đối tượng MyTime
        MyTime time = new MyTime(23, 59, 58);
        System.out.println("Initial Time: " + time);

        // Kiểm tra nextSecond()
        time.nextSecond();
        System.out.println("After nextSecond(): " + time);

        time.nextSecond();
        System.out.println("After another nextSecond(): " + time);

        // Kiểm tra previousSecond()
        time.previousSecond();
        System.out.println("After previousSecond(): " + time);

        // Kiểm tra nextMinute()
        time.nextMinute();
        System.out.println("After nextMinute(): " + time);

        // Kiểm tra previousMinute()
        time.previousMinute();
        System.out.println("After previousMinute(): " + time);

        // Kiểm tra nextHour()
        time.nextHour();
        System.out.println("After nextHour(): " + time);

        // Kiểm tra previousHour()
        time.previousHour();
        System.out.println("After previousHour(): " + time);
    }
}
