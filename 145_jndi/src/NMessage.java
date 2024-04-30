import java.io.Serializable;
import java.rmi.Remote;

public class NMessage implements Remote, Serializable {
    public String message = "";

    public NMessage(String message) {
        this.message = message;
    }
}