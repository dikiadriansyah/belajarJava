public final class MutableLocation {
    public int x;
    public int y;

    public MutableLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object other) {
        if (!(other instanceof MutableLocation)) {
            return false;
        }
        MutableLocation that = (MutableLocation) other;
        return this.x == that.x && this.y == that.y;
    }
}