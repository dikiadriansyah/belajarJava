import java.util.ArrayList;
import java.util.List;

// Dummy DataDao class for illustration purposes
class DataDao {
    // Assume some data is stored here
    public <T> List<T> getAllOfType(Class<T> type) {
        // In a real application, you would fetch data from a database or another source
        List<T> data = new ArrayList<>();
        // Dummy data for illustration
        if (type == User.class) {
            data.add((T) new User("John"));
            data.add((T) new User("Alice"));
        }
        return data;
    }
}

// Dummy User class
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "'}";
    }
}

public class DataService<MODEL_TYPE> {
    private final DataDao dataDao = new DataDao();
    private final Class<MODEL_TYPE> type;

    public DataService(Class<MODEL_TYPE> type) {
        this.type = type;
    }

    public List<MODEL_TYPE> getAll() {
        return dataDao.getAllOfType(type);
    }
}
