package producer_consumer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Producer: Nhà sản xuất
class Producer extends Thread {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) { // Sản xuất 10 sản phẩm
            try {
                System.out.println("🛠️ Producer tạo sản phẩm: " + i);
                queue.put(i); // Đưa sản phẩm vào kho (chờ nếu kho đầy)
                Thread.sleep(500); // Giả lập thời gian sản xuất
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Consumer: Người tiêu dùng
class Consumer extends Thread {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int item = queue.take(); // Lấy sản phẩm từ kho (chờ nếu kho rỗng)
                System.out.println("✅ Consumer tiêu thụ sản phẩm: " + item);
                Thread.sleep(1000); // Giả lập thời gian tiêu thụ
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // Kho chứa tối đa 5 sản phẩm

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}
