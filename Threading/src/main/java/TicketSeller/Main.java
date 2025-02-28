package TicketSeller;
import java.util.ArrayList;
import java.util.List;

class TicketSeller extends Thread {
    private static final List<Integer> tickets = new ArrayList<>(); // Danh sách vé
    private static int index = 0; // Vị trí bán vé
    private final String sellerName;

    public TicketSeller(String name) {
        this.sellerName = name;
    }

    // Phương thức bán vé được đồng bộ (synchronized) để tránh trùng vé
    private synchronized static int sellTicket() {
        if (index < tickets.size()) {
            return tickets.get(index++); // Lấy vé hiện tại và tăng index
        }
        return -1; // Hết vé
    }

    @Override
    public void run() {
        while (true) {
            int ticket = sellTicket(); // Lấy vé
            if (ticket == -1) {
                break; // Nếu hết vé thì dừng thread
            }
            System.out.println(sellerName + " bán vé số: " + ticket);

            try {
                Thread.sleep(100); // Giả lập thời gian bán vé
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Tạo danh sách vé từ 1 đến số lượng mong muốn
    public static void initTickets(int totalTickets) {
        for (int i = 1; i <= totalTickets; i++) {
            tickets.add(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int totalTickets = 10; // Số vé cần bán
        TicketSeller.initTickets(totalTickets); // Khởi tạo danh sách vé

        // Tạo 3 nhân viên bán vé
        TicketSeller seller1 = new TicketSeller("Nhân viên A");
        TicketSeller seller2 = new TicketSeller("Nhân viên B");
        TicketSeller seller3 = new TicketSeller("Nhân viên C");

        // Bắt đầu bán vé
        seller1.start();
        seller2.start();
        seller3.start();
    }
}
