package InvoiceItem;
class InvoiceItem {
    private String id;
    private String desc;
    private int qty;
    private double unitPrice;

    // Constructor
    public InvoiceItem(String id, String desc, int qty, double unitPrice) {
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public int getQty() {
        return qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    // Setters
    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    // Method to get total price
    public double getTotal() {
        return unitPrice * qty;
    }

    // toString method
    @Override
    public String toString() {
        return "InvoiceItem[id=" + id + ",desc=" + desc + ",qty=" + qty + ",unitPrice=" + unitPrice + "]";
    }
}

// Test class
public class TestMain {
    public static void main(String[] args) {
        // Test constructor and toString()
        InvoiceItem item1 = new InvoiceItem("A101", "Pen Red", 10, 0.99);
        System.out.println(item1);

        // Test setters and getters
        item1.setQty(20);
        item1.setUnitPrice(1.09);
        System.out.println(item1);
        System.out.println("id is: " + item1.getId());
        System.out.println("desc is: " + item1.getDesc());
        System.out.println("qty is: " + item1.getQty());
        System.out.println("unit price is: " + item1.getUnitPrice());
        System.out.println("total is: " + item1.getTotal());
    }
}
