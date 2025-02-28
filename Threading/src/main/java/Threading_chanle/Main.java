package Threading_chanle;
class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i += 2) {
            System.out.println("Chẵn: " + i);
            try {
                Thread.sleep(50); // Giả lập thời gian xử lý
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.println("Lẻ: " + i);
            try {
                Thread.sleep(50); // Giả lập thời gian xử lý
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();

        evenThread.start();
        try {
            evenThread.join(); // Chờ cho đến khi evenThread hoàn thành
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        oddThread.start(); // Khi evenThread xong, mới chạy oddThread
    }
}
