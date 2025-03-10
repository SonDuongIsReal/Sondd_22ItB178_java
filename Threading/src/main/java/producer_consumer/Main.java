public class Main {
    private static boolean isOddDone = false;
    
    public static void main(String[] args) {
        Thread evenThread = new Thread(new EvenNumberPrinter());
        Thread oddThread = new Thread(new OddNumberPrinter());

        // Bắt đầu chạy các thread
        oddThread.start();
        evenThread.start();
    }

    static class EvenNumberPrinter implements Runnable {
        @Override
        public void run() {
            try {
                // Đợi cho đến khi số lẻ in xong
                while (!isOddDone) {
                    Thread.sleep(100);
                }
                
                // In số chẵn
                System.out.println("\nIn số chẵn:");
                for (int i = 2; i <= 10; i += 2) {
                    System.out.println("Số chẵn: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class OddNumberPrinter implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("In số lẻ:");
                for (int i = 1; i <= 9; i += 2) {
                    System.out.println("Số lẻ: " + i);
                    Thread.sleep(500);
                }
                // Đánh dấu đã in xong số lẻ
                isOddDone = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
