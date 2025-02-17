package Account;
class Account {
    private String id;
    private String name;
    private int balance = 0;

    // Constructors
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    // Methods
    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    public int transferTo(Account anotherAccount, int amount) {
        if (amount <= balance) {
            balance -= amount;
            anotherAccount.credit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    @Override
    public String toString() {
        return "Account[id=" + id + ",name=" + name + ",balance=" + balance + "]";
    }
}

// Test class
public class TestMain {
    public static void main(String[] args) {
        Account acc1 = new Account("A100", "John Doe", 500);
        Account acc2 = new Account("A101", "Jane Doe", 300);

        System.out.println(acc1);
        System.out.println(acc2);

        acc1.credit(200);
        System.out.println("After credit: " + acc1);

        acc1.debit(100);
        System.out.println("After debit: " + acc1);

        acc1.transferTo(acc2, 300);
        System.out.println("After transfer: " + acc1);
        System.out.println("Receiver account: " + acc2);
    }
}
