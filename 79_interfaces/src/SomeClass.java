class SomeClass {
    private String data;

    public SomeClass(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SomeClass [data=" + data + "]";
    }
}
