package TheAuthorandBookClassesAgain;
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
    private Author[] authors; // Mảng chứa nhiều tác giả
    private double price;
    private int qty = 0; // Mặc định là 0

    // Constructor với 3 tham số (mặc định qty = 0)
    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    // Constructor với 4 tham số (khởi tạo đầy đủ)
    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Getter cho authors
    public Author[] getAuthors() {
        return authors;
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

    // Phương thức getAuthorNames(): trả về danh sách tên tác giả
    public String getAuthorNames() {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {
            names.append(authors[i].getName());
            if (i < authors.length - 1) {
                names.append(", ");
            }
        }
        return names.toString();
    }

    // toString() của Book, sử dụng toString() của từng Author
    @Override
    public String toString() {
        StringBuilder authorDetails = new StringBuilder();
        authorDetails.append("{");
        for (int i = 0; i < authors.length; i++) {
            authorDetails.append(authors[i].toString());
            if (i < authors.length - 1) {
                authorDetails.append(",");
            }
        }
        authorDetails.append("}");

        return "Book[name=" + name + ",authors=" + authorDetails.toString() + ",price=" + price + ",qty=" + qty + "]";
    }
}

// Lớp TestBook để kiểm tra chương trình
public class TestBook {
    public static void main(String[] args) {
        // Tạo danh sách tác giả
        Author author1 = new Author("J.K. Rowling", "jkrowling@example.com", 'f');
        Author author2 = new Author("Stephen King", "sking@example.com", 'm');
        
        // Đưa vào mảng Author[]
        Author[] authors = {author1, author2};

        // Tạo đối tượng Book với danh sách nhiều tác giả
        Book book = new Book("Famous Books Collection", authors, 39.99, 100);

        // In thông tin sách
        System.out.println(book.toString());

        // Thử gọi getAuthorNames()
        System.out.println("Danh sách tác giả: " + book.getAuthorNames());

        // Thử thay đổi giá và số lượng, rồi in lại
        book.setPrice(49.99);
        book.setQty(50);
        System.out.println("Sau khi cập nhật:");
        System.out.println(book.toString());
    }
}
