import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Set_and_get_global_varibles {
    // Set and get global variables/Tetapkan dan dapatkan variabel global

    /*
     * // Obtain an instance of JavaScript engine
     * ScriptEngineManager manager = new ScriptEngineManager();
     * ScriptEngine engine = manager.getEngineByName("nashorn");
     * try {
     * // Set value in the global name space of the engine
     * engine.put("name","Nashorn");
     * // Execute an hardcoded script
     * engine.eval("var value='Hello '+name+'!';");
     * // Get value
     * String value=(String)engine.get("value");
     * System.out.println(value);
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
        try {
            // Set value in the global name space of the engine
            engine.put("name", "Nashorn");
            // Execute an hardcoded script
            engine.eval("var value='Hello '+name+'!';");
            // Get value
            String value = (String) engine.get("value");
            System.out.println(value);
        } catch (ScriptException ex) {
            // This is the generic Exception subclass for the Scripting API
            ex.printStackTrace();
        }
        // Outcome:
        // Hello Nashorn!
    }
}
