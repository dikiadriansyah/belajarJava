public class BasicJavaBean implements java.io.Serializable {

    private int value1;
    private String value2;
    private boolean value3;

    public BasicJavaBean() {
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue3(boolean value3) {
        this.value3 = value3;
    }

    public boolean isValue3() {
        return value3;
    }
}