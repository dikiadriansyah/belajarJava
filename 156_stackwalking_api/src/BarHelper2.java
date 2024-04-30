import java.lang.StackWalker.Option;

public class BarHelper2 {
    protected static void bar() {

        System.out.println(StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).getCallerClass());
    }
}
