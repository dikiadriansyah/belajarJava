import java.io.FileReader;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Implementing_an_interface_from_script {
    // Implementing an interface from script/Menerapkan antarmuka dari skrip

    /*
     * import java.io.IOException;
     * import javax.script.ScriptEngine;
     * import javax.script.ScriptEngineManager;
     * import javax.script.ScriptException;
     * public class InterfaceImplementationExample {
     * public static interface Pet {
     * public void eat();
     * }
     * public static void main(String[] args) throws IOException {
     * // Obtain an instance of JavaScript engine
     * ScriptEngineManager manager = new ScriptEngineManager();
     * ScriptEngine engine = manager.getEngineByName("nashorn");
     * try {
     * //evaluate a script
     * // pet.js
     * var Pet = Java.type("InterfaceImplementationExample.Pet");
     * new Pet() {
     * eat: function() { print("eat"); }
     * }
     * 
     * Pet pet = (Pet) engine.eval(new FileReader("pet.js"));
     * 
     * pet.eat();
     * } catch (ScriptException ex) {
     * ex.printStackTrace();
     * }
     * // Outcome:
     * // 'eat' printed on standard output
     * }
     * }
     * 
     */
    public static interface Pet {
        public void eat();
    }

    public static void main(String[] args) throws Exception {
        // Obtain an instance of JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        try {
            // evaluate a script
            /* pet.js */
            /*
             * var Pet = Java.type("InterfaceImplementationExample.Pet");
             * 
             * new Pet() {
             * eat: function() { print("eat"); }
             * }
             */

            Pet pet = (Pet) engine.eval(new FileReader("pet.js"));

            pet.eat();
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
        // Outcome:
        // 'eat' printed on standard output
    }
}
