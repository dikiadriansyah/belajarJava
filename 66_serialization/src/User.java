public class User {
    private Long id;
    private String name;
    private String email;

    // Constructor, getters, and setters are omitted for clarity

    public User() {
        this.id = 0L; // Default value for id (you can change it accordingly)
        this.name = "Default Name"; // Default value for name
        this.email = "default@example.com"; // Default value for email
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
