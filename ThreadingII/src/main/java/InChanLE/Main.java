//package InChanLE;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.concurrent.CountDownLatch;
//
//public class Main {
//    static Queue<Integer> evenQueue = new LinkedList<>();
//    private static CountDownLatch latch = new CountDownLatch(1);
//
//    public static void main(String[] args) {
//        Thread evenThread = new Thread(new EvenNumberProducer());
//        Thread oddThread = new Thread(new OddNumberPrinter());
//
//        // Bắt đầu chạy các thread
//        evenThread.start();
//        oddThread.start();
//    }
//}
//
//class EvenNumberProducer implements Runnable {
//    @Override
//    public void run() {
//        // Đưa số chẵn vào hàng đợi
//        for (int i = 2; i <= 10; i += 2) {
//            Main.evenQueue.offer(i);
//            System.out.println("Đưa số chẵn vào queue: " + i);
//        }
//    }
//}
//
//class OddNumberPrinter implements Runnable {
//    @Override
//    public void run() {
//        // In số lẻ
//        System.out.println("\nIn số lẻ:");
//        for (int i = 1; i <= 9; i += 2) {
//            System.out.println("Số lẻ: " + i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Sau khi in xong số lẻ, in các số chẵn từ queue
//        System.out.println("\nIn số chẵn từ queue:");
//        while (!Main.evenQueue.isEmpty()) {
//            System.out.println("Số chẵn: " + Main.evenQueue.poll());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}