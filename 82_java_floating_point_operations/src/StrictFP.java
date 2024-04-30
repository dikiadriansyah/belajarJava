public class StrictFP {
    // No strictfp -> default lenient
    public strictfp float strict(float input) {
        return input * input / 3.4f; // Strictly adheres to the spec.
        // May be less accurate and may be slower.
    }

    public float lenient(float input) {
        return input * input / 3.4f; // Can sometimes be more accurate and faster,
        // but results may not be reproducible.
    }

    public static final strictfp class Ops { // strictfp affects all enclosed entities
        private Ops() {
        }

        public static double div(double dividend, double divisor) { // implicitly strictfp
            return dividend / divisor;
        }
    }
}