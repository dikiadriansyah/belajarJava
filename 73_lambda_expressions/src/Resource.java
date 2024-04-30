class Resource implements AutoCloseable {
    public void close() {
        System.out.println("close()");
    }
}