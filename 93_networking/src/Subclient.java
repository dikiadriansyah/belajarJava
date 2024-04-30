import java.io.IOException;

public class Subclient {
    public static void main(String[] args) {
        try {
            final String ip = args[0];
            final int port = Integer.parseInt(args[1]);
            Client3 client = new Client3(ip, port);
            client.printMessage();
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
