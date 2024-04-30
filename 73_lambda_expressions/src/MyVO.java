class MyVO {
    private String id;
    private String name;

    // Default constructor
    public MyVO() {
        // Empty constructor
    }

    // Constructors, getters, and setters
    public MyVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ObjectMapper {
    public static MyVO map(Object data) {
        // Assuming 'data' is an instance of MyVO or can be converted to MyVO
        // Replace this with your actual mapping logic
        return (MyVO) data;
    }
}
