package Mytime_c3;
public class MyTime {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    // Constructor không tham số
    public MyTime() {}

    // Constructor với tham số
    public MyTime(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    // Phương thức kiểm tra và thiết lập thời gian
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid hour, minute, or second!");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Getters
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public int getSecond() { return second; }

    // Setters
    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Invalid hour!");
        }
        this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid minute!");
        }
        this.minute = minute;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid second!");
        }
        this.second = second;
    }

    // Chuyển đổi sang chuỗi định dạng "HH:MM:SS"
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // Cập nhật giây kế tiếp
    public MyTime nextSecond() {
        second++;
        if (second == 60) {
            second = 0;
            nextMinute();
        }
        return this;
    }

    // Cập nhật phút kế tiếp
    public MyTime nextMinute() {
        minute++;
        if (minute == 60) {
            minute = 0;
            nextHour();
        }
        return this;
    }

    // Cập nhật giờ kế tiếp
    public MyTime nextHour() {
        hour++;
        if (hour == 24) {
            hour = 0;
        }
        return this;
    }

    // Giảm giây
    public MyTime previousSecond() {
        second--;
        if (second < 0) {
            second = 59;
            previousMinute();
        }
        return this;
    }

    // Giảm phút
    public MyTime previousMinute() {
        minute--;
        if (minute < 0) {
            minute = 59;
            previousHour();
        }
        return this;
    }

    // Giảm giờ
    public MyTime previousHour() {
        hour--;
        if (hour < 0) {
            hour = 23;
        }
        return this;
    }
}
