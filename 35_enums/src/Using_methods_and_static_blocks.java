public class Using_methods_and_static_blocks {
    // Using methods and static blocks / Menggunakan metode dan blok statis

    /*
     * Enum dapat berisi metode, sama seperti kelas lainnya. Untuk melihat cara
     * kerjanya, kami akan mendeklarasikan enum seperti ini:
     */

    // public enum Direction {
    // NORTH, SOUTH, EAST, WEST;
    // }

    // Mari kita punya metode yang mengembalikan enum ke arah yang berlawanan:

    // public enum Direction {
    // NORTH, SOUTH, EAST, WEST;

    // public Direction getOpposite() {
    // switch (this) {
    // case NORTH:
    // return SOUTH;
    // case SOUTH:
    // return NORTH;
    // case WEST:
    // return EAST;
    // case EAST:
    // return WEST;
    // default: // This will never happen
    // return null;
    // }
    // }
    // }

    /*
     * Hal ini dapat ditingkatkan lebih lanjut melalui penggunaan kolom dan blok
     * penginisialisasi statis:
     */

    public enum Direction {
        NORTH, SOUTH, EAST, WEST;

        private Direction opposite;

        public Direction getOpposite() {
            return opposite;
        }

        static {
            NORTH.opposite = SOUTH;
            SOUTH.opposite = NORTH;
            WEST.opposite = EAST;
            EAST.opposite = WEST;
        }
    }

    /*
     * Dalam contoh ini, arah yang berlawanan disimpan dalam bidang contoh pribadi
     * yang berlawanan, yang diinisialisasi secara statis
     * pertama kali Arah digunakan. Dalam kasus khusus ini (karena UTARA mengacu
     * pada SELATAN dan sebaliknya), kita tidak bisa
     * gunakan Enum dengan konstruktor di sini (Konstruktor NORTH(SOUTH),
     * SOUTH(NORTH), EAST(WEST), WEST(EAST) akan lebih elegan dan memungkinkan
     * kebalikannya dinyatakan final, tetapi akan bersifat referensial dan oleh
     * karena itu tidak diperbolehkan )
     */

    public static void main(String[] args) {
        Direction north = Direction.NORTH;
        Direction south = Direction.SOUTH;
        Direction east = Direction.EAST;
        Direction west = Direction.WEST;

        System.out.println("Kebalikan dari " + north + " adalah " + north.getOpposite()); // Kebalikan dari NORTH adalah
                                                                                          // SOUTH
        System.out.println("Kebalikan dari " + south + " adalah " + south.getOpposite()); // Kebalikan dari SOUTH adalah
                                                                                          // NORTH
        System.out.println("Kebalikan dari " + east + " adalah " + east.getOpposite()); // Kebalikan dari EAST adalah
                                                                                        // WEST
        System.out.println("Kebalikan dari " + west + " adalah " + west.getOpposite()); // Opposite of WEST adalah EAST
    }
}
