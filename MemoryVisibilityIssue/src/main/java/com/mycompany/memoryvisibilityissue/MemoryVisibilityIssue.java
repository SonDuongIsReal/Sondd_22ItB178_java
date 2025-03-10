/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.memoryvisibilityissue;

public class MemoryVisibilityIssue {
    private static boolean flag = false; // Biến chia sẻ giữa hai luồng

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!flag) {
                // Vòng lặp vô hạn nếu không thấy flag thay đổi
            }
            System.out.println("Thread 1: Flag changed, exiting loop.");
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000); // Chờ 2 giây trước khi thay đổi flag
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true; // Thay đổi giá trị flag
            System.out.println("Thread 2: Flag set to true.");
        });

        t1.start();
        t2.start();
    }
}
