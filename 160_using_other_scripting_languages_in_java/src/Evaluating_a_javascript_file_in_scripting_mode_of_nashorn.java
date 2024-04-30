import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptException;

public class Evaluating_a_javascript_file_in_scripting_mode_of_nashorn {
    // Evaluating A JavaScript file in -scripting mode of nashorn/Mengevaluasi file
    // JavaScript dalam mode -scripting nashorn

    /*
     * public class JSEngine {
     * 
     * //Note Nashorn is only available for Java-8 onwards
     * //You can use rhino from ScriptEngineManager.getEngineByName("js");
     * 
     * ScriptEngine engine;
     * ScriptContext context;
     * public Bindings scope;
     * 
     * // Initialize the Engine from its factory in scripting mode
     * public JSEngine(){
     * engine = new NashornScriptEngineFactory().getScriptEngine("-scripting");
     * // Script context is an interface so we need an implementation of it
     * context = new SimpleScriptContext();
     * // Create bindings to expose variables into
     * scope = engine.createBindings();
     * }
     * 
     * // Clear the bindings to remove the previous variables
     * public void newBatch(){
     * scope.clear();
     * }
     * 
     * public void execute(String file){
     * try {
     * // Get a buffered reader for input
     * BufferedReader br = new BufferedReader(new FileReader(file));
     * // Evaluate code, with input as bufferdReader
     * engine.eval(br);
     * } catch (FileNotFoundException ex) {
     * Logger.getLogger(JSEngine.class.getName()).log(Level.SEVERE, null, ex);
     * } catch (ScriptException ex) {
     * // Script Exception is basically when there is an error in script
     * Logger.getLogger(JSEngine.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * }
     * 
     * public void eval(String code){
     * try {
     * // Engine.eval basically treats any string as a line of code and evaluates
     * it, executes
     * it
     * engine.eval(code);
     * } catch (ScriptException ex) {
     * // Script Exception is basically when there is an error in script
     * Logger.getLogger(JSEngine.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * }
     * // Apply the bindings to the context and set the engine's default context
     * public void startBatch(int SCP){
     * context.setBindings(scope, SCP);
     * engine.setContext(context);
     * }
     * 
     * // We use the invocable interface to access methods from the script
     * // Invocable is an optional interface, please check if your engine implements
     * it
     * public Invocable invocable(){
     * return (Invocable)engine;
     * }
     * 
     * }
     * 
     * 
     * 
     */

    // Sekarang metode utamanya
    /*
     * public static void main(String[] args) {
     * JSEngine jse = new JSEngine();
     * // Create a new batch probably unecessary
     * jse.newBatch();
     * // Expose variable x into script with value of hello world
     * jse.scope.put("x", "hello world");
     * // Apply the bindings and start the batch
     * jse.startBatch(ScriptContext.ENGINE_SCOPE);
     * // Evaluate the code
     * jse.eval("print(x);");
     * }
     */

    // Output Anda harus serupa dengan ini

    /*
     * hello world
     */

    // Seperti yang Anda lihat, variabel terbuka x telah dicetak. Sekarang pengujian
    // dengan file.

    // Di sini kita memiliki test.js

    /*
     * print(x);
     * function test(){
     * print("hello test.js:test");
     * }
     * test();
     */

    // Dan metode utama yang diperbarui

    /*
     * public static void main(String[] args) {
     * JSEngine jse = new JSEngine();
     * // Create a new batch probably unecessary
     * jse.newBatch();
     * // Expose variable x into script with value of hello world
     * jse.scope.put("x", "hello world");
     * // Apply the bindings and start the batch
     * jse.startBatch(ScriptContext.ENGINE_SCOPE);
     * // Evaluate the code
     * jse.execute("./test.js");
     * }
     */

    /*
     * Dengan asumsi bahwa test.js berada di direktori yang sama dengan aplikasi
     * Anda, Anda akan mendapatkan keluaran yang serupa dengan ini
     * 
     * hello world
     * hello test.js:test
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        JSEngine jse = new JSEngine();
        // Create a new batch probably unecessary
        jse.newBatch();
        // Expose variable x into script with value of hello world
        jse.scope.put("x", "hello world");
        // Apply the bindings and start the batch
        jse.startBatch(ScriptContext.ENGINE_SCOPE);
        // Evaluate the code
        // jse.eval("print(x);");
        /*
         * output:
         * Warning: Nashorn engine is planned to be removed from a future JDK release
         * hello world
         */
        // ---------------------------
        jse.execute("test2.js");
    }
}
