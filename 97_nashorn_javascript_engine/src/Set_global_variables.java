import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Set_global_variables {
    // Set global variables/Tetapkan variabel global

    /*
     * // Obtain an instance of JavaScript engine
     * ScriptEngineManager manager = new ScriptEngineManager();
     * ScriptEngine engine = manager.getEngineByName("nashorn");
     * // Define a global variable
     * engine.put("textToPrint", "Data defined in Java.");
     * // Print the global variable
     * try {
     * engine.eval("print(textToPrint);");
     * } catch (ScriptException ex) {
     * ex.printStackTrace();
     * }
     * // Outcome:
     * // 'Data defined in Java.' printed on standard output
     */

    public static void main(String[] args) throws Exception {
        // Obtain an instance of JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        // Define a global variable
        engine.put("textToPrint", "Data defined in Java.");
        // Print the global variable
        try {
            engine.eval("print(textToPrint);");
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
        // Outcome:
        // Data defined in Java.
    }
}
