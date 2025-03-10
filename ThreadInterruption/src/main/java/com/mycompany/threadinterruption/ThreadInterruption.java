package com.mycompany.threadinterruption;

public class ThreadInterruption {
    public static void main(String[] args) {
        Thread infiniteLoopThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running...");
                try {
                    Thread.sleep(500); // Giả lập công việc tốn thời gian
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted!");
                    break; // Thoát khỏi vòng lặp khi bị interrupt
                }
            }
            System.out.println("Thread has stopped.");
        });

        infiniteLoopThread.start(); // Bắt đầu luồng

        try {
            Thread.sleep(3000); // Chờ 3 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        infiniteLoopThread.interrupt(); // Gửi tín hiệu dừng luồng
        System.out.println("Main thread sent interrupt signal.");
    }
}
