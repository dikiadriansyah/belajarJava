import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class DynamicTransformer implements ClassFileTransformer {
 public byte[] transform(ClassLoader loader, String className, Class classBeingRedefined,
 ProtectionDomain protectionDomain, byte[] classfileBuffer) throws
IllegalClassFormatException {
 byte[] byteCode = classfileBuffer;
 // into the transformer will arrive every class loaded so we filter
 // to match only what we need
 if (className.equals("com/my/to/be/instrumented/MyClass")) {
    try {
    // retrive default Javassist class pool
    ClassPool cp = ClassPool.getDefault();
    // get from the class pool our class with this qualified name
    CtClass cc = cp.get("com.my.to.be.instrumented.MyClass");
    // get all the methods of the retrieved class
    CtMethod[] methods = cc.getDeclaredMethods()
    for(CtMethod meth : methods) {
    // The instrumentation code to be returned and injected
   final StringBuffer buffer = new StringBuffer();
    String name = meth.getName();
    // just print into the buffer a log for example
    buffer.append("System.out.println(\"Method " + name + " executed\" );");
    meth.insertBefore(buffer.toString())
    }
    // create the byteclode of the class
    byteCode = cc.toBytecode();
    // remove the CtClass from the ClassPool
    cc.detach();
    } catch (Exception ex) {
    ex.printStackTrace();
    }
    }
    return byteCode;
    }
}
