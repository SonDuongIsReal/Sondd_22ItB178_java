package book;

// Lớp Author
class Author {
    private String name;
    private String email;
    private char gender; // 'm' hoặc 'f'

    // Constructor khởi tạo Author
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Getter và setter cho email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter cho gender
    public char getGender() {
        return gender;
    }

    // toString() của Author
    @Override
    public String toString() {
        return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }
}

// Lớp Book
class Book {
    private String name;
    private Author author; // Sử dụng lớp Author đã tạo ở trên
    private double price;
    private int qty = 0; // Mặc định là 0

    // Constructor với 3 tham số (mặc định qty = 0)
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Constructor với 4 tham số (khởi tạo đầy đủ)
    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Getter cho author
    public Author getAuthor() {
        return author;
    }

    // Getter và setter cho price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter và setter cho qty
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    // toString() của Book, sử dụng toString() của Author
    @Override
    public String toString() {
        return "Book[name=" + name + "," + author.toString() + ",price=" + price + ",qty=" + qty + "]";
    }
}

// Lớp TestBook để kiểm tra chương trình
public class TestBook {
    public static void main(String[] args) {
        // Tạo đối tượng Author
        Author author = new Author("J.K. Rowling", "jkrowling@example.com", 'f');

        // Tạo đối tượng Book với Author đã tạo
        Book book = new Book("Harry Potter", author, 19.99, 10);

        // In thông tin sách
        System.out.println(book.toString());

        // Thử thay đổi giá và số lượng, rồi in lại
        book.setPrice(25.99);
        book.setQty(5);
        System.out.println("Sau khi cập nhật:");
        System.out.println(book.toString());
    }
}
