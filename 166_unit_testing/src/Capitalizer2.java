public class Capitalizer2 {
    private DataReader2 dr;

    public Capitalizer2() {
        dr = new DataReader2();
    }

    public String getVal() {
        return dr.readVal().toUpperCase();
    }
}
