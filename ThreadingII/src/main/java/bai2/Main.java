package bai2;

class BanAn {
    private int soMonToiDa = 5;
    private int soMonHienTai = 0;

    public synchronized void themMonAn() throws InterruptedException {
        while (soMonHienTai == soMonToiDa) {
            System.out.println("Bàn ăn đầy, đầu bếp đợi...");
            wait(); // Đợi cho đến khi có chỗ trên bàn
        }
        soMonHienTai++;
        System.out.println("Đầu bếp nấu món mới. Số món trên bàn: " + soMonHienTai);
        notify(); // Thông báo cho khách hàng biết có món mới
        Thread.sleep(2000); // Thời gian nấu mỗi món
    }

    public synchronized void anMonAn() throws InterruptedException {
        while (soMonHienTai == 0) {
            System.out.println("Bàn ăn trống, khách hàng đợi...");
            wait(); // Đợi cho đến khi có món ăn trên bàn
        }
        soMonHienTai--;
        System.out.println("Khách hàng ăn món. Số món trên bàn: " + soMonHienTai);
        notify(); // Thông báo cho đầu bếp biết bàn đã có chỗ
        Thread.sleep(3000); // Thời gian ăn mỗi món
    }
}

public class Main {
    public static void main(String[] args) {
        BanAn banAn = new BanAn();
        Thread dauBep = new Thread(() -> {
            while (true) {
                try {
                    banAn.themMonAn();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread khachHang = new Thread(() -> {
            while (true) {
                try {
                    banAn.anMonAn();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        dauBep.start();
        khachHang.start();
    }
}
