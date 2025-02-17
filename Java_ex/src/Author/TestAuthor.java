package Author;
public class TestAuthor {
    public static void main(String[] args) {
        // Tạo một đối tượng Author
        Author author = new Author("Tan Ah Teck", "ahTeck@somewhere.com", 'm');

        // Kiểm tra phương thức toString()
        System.out.println(author);

        // Kiểm tra getters
        System.out.println("Name: " + author.getName());
        System.out.println("Email: " + author.getEmail());
        System.out.println("Gender: " + author.getGender());

        // Kiểm tra setter email
        author.setEmail("newEmail@domain.com");
        System.out.println("Updated Email: " + author.getEmail());

        // Kiểm tra lại toString() sau khi cập nhật email
        System.out.println(author);
    }
}
