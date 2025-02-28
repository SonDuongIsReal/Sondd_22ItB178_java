package RealTime;
import java.text.SimpleDateFormat;
import java.util.Date;

class RealTimeClock extends Thread {
    private volatile boolean running = true;

    public void stopClock() {
        running = false;
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss"); // Định dạng giờ, phút, giây
        while (running) {
            Date now = new Date();
            System.out.println("⏰ Thời gian hiện tại: " + formatter.format(now));
            try {
                Thread.sleep(1000); // Chờ 1 giây trước khi cập nhật thời gian
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RealTimeClock clock = new RealTimeClock();
        clock.start();

        try {
            Thread.sleep(10000); // Chạy đồng hồ trong 10 giây
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        clock.stopClock(); // Dừng đồng hồ
        System.out.println("⏹ Đồng hồ đã dừng!");
    }
}
