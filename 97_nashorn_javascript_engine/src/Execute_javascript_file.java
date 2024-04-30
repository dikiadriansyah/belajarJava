import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.*;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Execute_javascript_file {
    // Execute JavaScript file/Jalankan file JavaScript

    /*
     * // Required imports
     * import javax.script.ScriptEngineManager;
     * import javax.script.ScriptEngine;
     * import javax.script.ScriptException;
     * import java.io.FileReader;
     * import java.io.FileNotFoundException;
     * // Obtain an instance of the JavaScript engine
     * ScriptEngineManager manager = new ScriptEngineManager();
     * ScriptEngine engine = manager.getEngineByName("nashorn");
     * // Load and execute a script from the file 'demo.js'
     * try {
     * engine.eval(new FileReader("demo.js"));
     * } catch (FileNotFoundException ex) {
     * ex.printStackTrace();
     * } catch (ScriptException ex) {
     * // This is the generic Exception subclass for the Scripting API
     * ex.printStackTrace();
     * }
     * // Outcome:
     * // 'Script from file!' printed on standard output
     */

    /*
     * demo.js:
     * print('Script from file!');
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // ----------------
        // Obtain an instance of the JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        // Load and execute a script from the file 'demo.js'
        try {
            engine.eval(new FileReader("demo.js"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (ScriptException ex) {
            // This is the generic Exception subclass for the Scripting API
            ex.printStackTrace();
        }
    }
}
