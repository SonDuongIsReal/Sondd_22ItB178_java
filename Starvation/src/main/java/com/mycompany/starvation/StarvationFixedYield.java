package com.mycompany.starvation;

public class StarvationFixedYield {
    public static void main(String[] args) {
        Thread highPriority = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("High priority thread running...");
                Thread.yield(); // Nhường CPU cho luồng khác
            }
        });

        Thread lowPriority = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Low priority thread running...");
            }
        });

        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        highPriority.start();
        lowPriority.start();
    }
}
