// Lớp Author
class Author {
    private String name;
    private String email;

    // Constructor khởi tạo Author
    public Author(String name, String email) {
        this.name = name;
        this.email = email;
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

    // toString() của Author
    @Override
    public String toString() {
        return "Author[name=" + name + ",email=" + email + "]";
    }
}

// Lớp Book
class Book {
    private String isbn;
    private String name;
    private Author author; // Chỉ 1 tác giả
    private double price;
    private int qty = 0; // Mặc định là 0

    // Constructor với 3 tham số (mặc định qty = 0)
    public Book(String isbn, String name, Author author, double price) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Constructor với 4 tham số (khởi tạo đầy đủ)
    public Book(String isbn, String name, Author author, double price, int qty) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    // Getter cho isbn
    public String getIsbn() {
        return isbn;
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

    // Phương thức getAuthorName(): trả về tên tác giả
    public String getAuthorName() {
        return author.getName();
    }

    // toString() của Book, sử dụng toString() của Author
    @Override
    public String toString() {
        return "Book[isbn=" + isbn + ",name=" + name + "," + author.toString() + ",price=" + price + ",qty=" + qty + "]";
    }
}

// Lớp TestBook để kiểm tra chương trình
public class TestBook {
    public static void main(String[] args) {
        // Tạo đối tượng Author
        Author author = new Author("J.K. Rowling", "jkrowling@example.com");

        // Tạo đối tượng Book với 1 tác giả
        Book book = new Book("123-456-789", "Harry Potter", author, 29.99, 100);

        // In thông tin sách
        System.out.println(book.toString());

        // Thử gọi getAuthorName()
        System.out.println("Tên tác giả: " + book.getAuthorName());

        // Thử thay đổi giá và số lượng, rồi in lại
        book.setPrice(39.99);
        book.setQty(50);
        System.out.println("Sau khi cập nhật:");
        System.out.println(book.toString());
    }
}
