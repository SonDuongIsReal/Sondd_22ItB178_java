package CustomerAndInvoice;
class Account {
    private int id;
    private Customer customer;
    private double balance = 0.0;

    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public Account(int id, Customer customer) {
        this(id, customer, 0.0);
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public Account deposit(double amount) {
        balance += amount;
        return this;
    }

    public Account withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Amount withdrawn exceeds the current balance!");
        }
        return this;
    }

    @Override
    public String toString() {
        return customer.getName() + "(" + id + ") balance=$" + String.format("%.2f", balance);
    }
}

// Test class
public class TestAccount {
    public static void main(String[] args) {
        Customer c1 = new Customer(1, "Bob", 'M');
        Account acc1 = new Account(2001, c1, 1000);

        System.out.println(acc1);
        acc1.deposit(500);
        System.out.println("After deposit: " + acc1);
        acc1.withdraw(200);
        System.out.println("After withdrawal: " + acc1);
        acc1.withdraw(2000); // Should print a warning message
    }
}
