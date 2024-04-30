import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Evaluate_arithmetic_strings {
    // Evaluate Arithmetic Strings/Evaluasi String Aritmatika

    /*
     * // Obtain an instance of JavaScript engine
     * ScriptEngineManager manager = new ScriptEngineManager();
     * ScriptEngine engine = manager.getEngineByName("JavaScript");
     * //String to be evaluated
     * String str = "3+2*4+5";
     * //Value after doing Arithmetic operation with operator precedence will be 16
     * //Printing the value
     * try {
     * System.out.println(engine.eval(str));
     * } catch (ScriptException ex) {
     * ex.printStackTrace();
     * }
     * //Outcome:
     * //Value of the string after arithmetic evaluation is printed on standard
     * output.
     * //In this case '16.0' will be printed on standard output.
     */

    public static void main(String[] args) throws Exception {
        // Obtain an instance of JavaScript engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        // String to be evaluated
        String str = "3+2*4+5";
        // Value after doing Arithmetic operation with operator precedence will be 16
        // Printing the value
        try {
            System.out.println(engine.eval(str));
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
        // Outcome:
        // Value of the string after arithmetic evaluation is printed on standard
        // output.
        // In this case '16.0' will be printed on standard output.
    }
}
