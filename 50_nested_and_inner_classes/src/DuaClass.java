public class DuaClass {
    SatuClass outer = new SatuClass();

    SatuClass.InnerClass createInner() {
        return outer.new InnerClass();
    }
}
