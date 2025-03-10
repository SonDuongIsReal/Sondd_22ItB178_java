package RaceConditionn;
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private AtomicInteger count = new AtomicInteger(0); // Sử dụng AtomicInteger

    // Phương thức tăng biến đếm một cách an toàn
    public void increment() {
        count.incrementAndGet();
    }

    // Lấy giá trị hiện tại của biến đếm
    public int getCount() {
        return count.get();
    }
}

public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Tạo hai luồng để tăng biến đếm 1000 lần mỗi luồng
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Khởi chạy hai luồng
        t1.start();
        t2.start();

        // Chờ cả hai luồng kết thúc
        t1.join();
        t2.join();

        // In kết quả cuối cùng
        System.out.println("Final count: " + counter.getCount()); // Luôn là 2000
    }
}
