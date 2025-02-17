package Author;
class Author {
    private String name;
    private String email;
    private char gender; // 'm' hoặc 'f'

    // Constructor
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

    // Phương thức toString()
    @Override
    public String toString() {
        return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }
}
