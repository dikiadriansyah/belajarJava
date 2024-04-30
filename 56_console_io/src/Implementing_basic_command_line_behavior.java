import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementing_basic_command_line_behavior {
    // Implementing Basic Command-Line Behavior / Menerapkan Perilaku Baris Perintah
    // Dasar

    /*
     * Untuk prototipe dasar atau perilaku baris perintah dasar, loop berikut ini
     * berguna.
     */

    private static final String CLI_LINE = "example-cli>"; // console like string
    private static final String CMD_QUIT = "quit"; // string for exiting the program
    private static final String CMD_HELLO = "hello"; // string for printing "Hello World!" on
    // the screen
    private static final String CMD_ANSWER = "answer"; // string for printing 42 on the screen

    public static void main(String[] args) {
        Implementing_basic_command_line_behavior claimCli = new Implementing_basic_command_line_behavior(); // creates
                                                                                                            // an object
                                                                                                            // of this
                                                                                                            // class
        try {
            claimCli.start(); // calls the start function to do the work like console
        } catch (IOException e) {
            e.printStackTrace(); // prints the exception log if it is failed to do get the user
            // input or something like that
        }

        /*
         * output:
         * example-cli>hello
         * Hello World!
         * example-cli>answer
         * 42
         * example-cli>quit
         */

    }

    private void start() throws IOException {
        String cmd = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!cmd.equals(CMD_QUIT)) { // terminates console if user input is "quit"
            System.out.print(CLI_LINE); // prints the console-like string
            cmd = reader.readLine(); // takes input from user. user input should be started with
            // "hello", "answer" or "quit"
            String[] cmdArr = cmd.split(" ");
            if (cmdArr[0].equals(CMD_HELLO)) { // executes when user input starts with "hello"
                hello(cmdArr);
            } else if (cmdArr[0].equals(CMD_ANSWER)) { // executes when user input starts with
                // "answer"
                answer(cmdArr);
            }
        }
    }

    // prints "Hello World!" on the screen if user input starts with "hello"
    private void hello(String[] cmdArr) {
        System.out.println("Hello World!");
    }

    // prints "42" on the screen if user input starts with "answer"
    private void answer(String[] cmdArr) {
        System.out.println("42");
    }

}
