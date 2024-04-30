import java.io.StringWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Intercept_script_output {
    // Intercept script output/ Mencegat keluaran skrip

    /*
     * // Obtain an instance of JavaScript engine
     * ScriptEngineManager manager = new ScriptEngineManager();
     * ScriptEngine engine = manager.getEngineByName("nashorn");
     * // Setup a custom writer
     * StringWriter stringWriter = new StringWriter();
     * // Modify the engine context so that the custom writer is now the default
     * // output writer of the engine
     * engine.getContext().setWriter(stringWriter);
     * // Execute some script
     * try {
     * engine.eval("print('Redirected text!');");
     * } catch (ScriptException ex) {
     * ex.printStackTrace();
     * }
     * // Outcome:
     * // Nothing printed on standard output, but
     * // stringWriter.toString() contains 'Redirected text!''
     * 
     */

    public static void main(String[] args) throws Exception {
        // Obtain an instance of JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        // Setup a custom writer
        StringWriter stringWriter = new StringWriter();
        // Modify the engine context so that the custom writer is now the default
        // output writer of the engine
        engine.getContext().setWriter(stringWriter);
        // Execute some script
        try {
            engine.eval("print('Redirected text!');");
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }

        /*
         * output:
         * Warning: Nashorn engine is planned to be removed from a future JDK release
         */

    }
}
