package CustomerVsInvoice;
// Lớp Customer
class Customer {
    private int id;
    private String name;
    private int discount; // Giảm giá theo phần trăm

    // Constructor khởi tạo Customer
    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Getter và setter cho discount
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    // toString() của Customer
    @Override
    public String toString() {
        return name + "(" + id + ")(" + discount + "%)";
    }
}

// Lớp Invoice
class Invoice {
    private int id;
    private Customer customer; // Chỉ một khách hàng
    private double amount;

    // Constructor khởi tạo Invoice
    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    // Getter và setter cho customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Getter và setter cho amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Lấy id của Customer
    public int getCustomerId() {
        return customer.getId();
    }

    // Lấy tên của Customer
    public String getCustomerName() {
        return customer.getName();
    }

    // Lấy discount của Customer
    public int getCustomerDiscount() {
        return customer.getDiscount();
    }

    // Tính số tiền sau giảm giá
    public double getAmountAfterDiscount() {
        return amount - (amount * customer.getDiscount() / 100.0);
    }

    // toString() của Invoice
    @Override
    public String toString() {
        return "Invoice[id=" + id + ",customer=" + customer.toString() + ",amount=" + amount + "]";
    }
}

// Lớp TestInvoice để kiểm tra chương trình
public class TestInvoice {
    public static void main(String[] args) {
        // Tạo một khách hàng
        Customer customer = new Customer(101, "John Doe", 10);

        // Tạo một hóa đơn với khách hàng trên
        Invoice invoice = new Invoice(1, customer, 200.0);

        // In thông tin hóa đơn
        System.out.println(invoice.toString());

        // Kiểm tra các phương thức
        System.out.println("Tên khách hàng: " + invoice.getCustomerName());
        System.out.println("Giảm giá của khách hàng: " + invoice.getCustomerDiscount() + "%");
        System.out.println("Số tiền sau giảm giá: " + invoice.getAmountAfterDiscount());

        // Thử thay đổi giảm giá và in lại
        customer.setDiscount(20);
        System.out.println("Sau khi cập nhật giảm giá:");
        System.out.println("Số tiền sau giảm giá: " + invoice.getAmountAfterDiscount());
    }
}
