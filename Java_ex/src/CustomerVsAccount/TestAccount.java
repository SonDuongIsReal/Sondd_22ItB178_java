package CustomerVsAccount;
// Lớp Customer
class Customer {
    private int id;
    private String name;
    private char gender; // 'm' hoặc 'f'

    // Constructor khởi tạo Customer
    public Customer(int id, String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Getter cho gender
    public char getGender() {
        return gender;
    }

    // toString() của Customer
    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}

// Lớp Account
class Account {
    private int id;
    private Customer customer; // Chỉ một khách hàng
    private double balance;

    // Constructor khởi tạo Account với số dư ban đầu
    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    // Constructor khởi tạo Account với số dư mặc định là 0.0
    public Account(int id, Customer customer) {
        this(id, customer, 0.0);
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    // Getter cho customer
    public Customer getCustomer() {
        return customer;
    }

    // Getter và setter cho balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Lấy tên khách hàng
    public String getCustomerName() {
        return customer.getName();
    }

    // Phương thức gửi tiền
    public Account deposit(double amount) {
        this.balance += amount;
        return this;
    }

    // Phương thức rút tiền
    public Account withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Amount withdrawn exceeds the current balance!");
        }
        return this;
    }

    // toString() của Account
    @Override
    public String toString() {
        return customer.toString() + " balance=$" + String.format("%.2f", balance);
    }
}

// Lớp TestAccount để kiểm tra chương trình
public class TestAccount {
    public static void main(String[] args) {
        // Tạo một khách hàng
        Customer customer = new Customer(101, "Alice", 'f');

        // Tạo một tài khoản với khách hàng trên
        Account account = new Account(1, customer, 500.0);

        // In thông tin tài khoản
        System.out.println(account.toString());

        // Kiểm tra các phương thức
        account.deposit(200.0);
        System.out.println("Sau khi gửi tiền: " + account.toString());

        account.withdraw(100.0);
        System.out.println("Sau khi rút tiền: " + account.toString());

        // Thử rút số tiền lớn hơn số dư
        account.withdraw(700.0);
        System.out.println("Sau khi thử rút vượt quá số dư: " + account.toString());
    }
}
