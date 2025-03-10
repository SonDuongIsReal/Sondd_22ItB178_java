package Race_Condition;
class Counter {
    private int count = 0;

    // Sử dụng synchronized để đảm bảo chỉ một luồng có thể tăng biến count tại một thời điểm
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class RaceConditionExample1 {
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

        // Khởi chạy cả hai luồng
        t1.start();
        t2.start();

        // Chờ cả hai luồng kết thúc
        t1.join();
        t2.join();

        // In ra kết quả cuối cùng
        System.out.println("Final count: " + counter.getCount()); // Luôn là 2000
    }
}
