import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import java.util.logging.Logger;

import javax.script.*;
import java.io.*;

public class JSEngine {

    /*
     * Note Nashorn is only available for Java-8 onwards
     * You can use rhino from ScriptEngineManager.getEngineByName("js");
     */

    ScriptEngine engine;
    ScriptContext context;
    public Bindings scope;

    // Initialize the Engine from its factory in scripting mode
    public JSEngine() {
        engine = new NashornScriptEngineFactory().getScriptEngine("-scripting");
        // Script context is an interface so we need an implementation of it
        context = new SimpleScriptContext();
        // Create bindings to expose variables into
        scope = engine.createBindings();
    }

    // Clear the bindings to remove the previous variables
    public void newBatch() {
        scope.clear();
    }

    public void execute(String file) {
        try {
            // Get a buffered reader for input
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Evaluate code, with input as bufferdReader
            engine.eval(br);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (ScriptException ex) {
            // Script Exception is basically when there is an error in script
            ex.printStackTrace();
        }
    }

    public void eval(String code) {
        try {
            // Engine.eval basically treats any string as a line of code and evaluates it,
            // executes it
            engine.eval(code);
        } catch (ScriptException ex) {
            // Script Exception is basically when there is an error in script
            ex.printStackTrace();
        }
    }

    // Apply the bindings to the context and set the engine's default context
    public void startBatch(int SCP) {
        context.setBindings(scope, SCP);
        engine.setContext(context);
    }

    // We use the invocable interface to access methods from the script
    // Invocable is an optional interface, please check if your engine implements it
    public Invocable invocable() {
        return (Invocable) engine;
    }

}