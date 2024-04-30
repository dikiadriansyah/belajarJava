public class Program {
    private Long id;
    private String name;
    private User createdBy;
    private String contents;

    // Constructor, getters, and setters are omitted for clarity

    public Program() {
        this.id = 0L; // Default value for id (you can change it accordingly)
        this.name = "Default Program"; // Default value for name
        this.createdBy = new User(); // Default user for createdBy (using the default constructor)
        this.contents = "Default Contents"; // Default value for contents
    }

    public Program(Long id, String name, User createdBy, String contents) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.contents = contents;
    }
}
