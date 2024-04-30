enum Compass {
    NORTH(0), EAST(90), SOUTH(180), WEST(270);

    private int degree;

    Compass(int deg) {
        degree = deg;
    }

    public int getDegree() {
        return degree;
    }
}