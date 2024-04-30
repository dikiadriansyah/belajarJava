import java.util.*;

public final class NewNames {
    private final List<String> names;

    public NewNames(List<String> names) {
        this.names = names;
    }

    public String getName(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }
}
