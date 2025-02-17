package Date;
class Date {
    private int day;
    private int month;
    private int year;

    // Constructor
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}

// Test class
public class TestMain {
    public static void main(String[] args) {
        // Test constructor and toString()
        Date date = new Date(5, 11, 2023);
        System.out.println(date);

        // Test setters and getters
        date.setDay(25);
        date.setMonth(12);
        date.setYear(2025);
        System.out.println(date);
        System.out.println("Day: " + date.getDay());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Year: " + date.getYear());
    }
}