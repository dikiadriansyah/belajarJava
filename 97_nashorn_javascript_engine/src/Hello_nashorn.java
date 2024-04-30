import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Hello_nashorn {
    // Hello Nashorn/Hello Nashorn

    /*
     * // Obtain an instance of JavaScript engine
     * ScriptEngineManager manager = new ScriptEngineManager();
     * ScriptEngine engine = manager.getEngineByName("nashorn");
     * // Execute an hardcoded script
     * try {
     * engine.eval("print('Hello Nashorn!');");
     * } catch (ScriptException ex) {
     * // This is the generic Exception subclass for the Scripting API
     * ex.printStackTrace();
     * }
     * // Outcome:
     * // 'Hello Nashorn!' printed on standard output
     */

    public static void main(String[] args) throws Exception {
        // Obtain an instance of JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        // Execute an hardcoded script
        try {
            engine.eval("print('Hello Nashorn!');");
        } catch (ScriptException ex) {
            // This is the generic Exception subclass for the Scripting API
            ex.printStackTrace();
        }
        // Outcome:
        // Hello Nashorn!
    }
}
