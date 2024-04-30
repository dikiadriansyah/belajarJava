class Demo<T extends SomeClass> {
    private T data;

    public Demo(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void displayInfo() {
        System.out.println("Data type: " + data.getClass().getName());
    }
}