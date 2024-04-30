public class Packing_unpacking {
        // Packing or unpacking values as bit fragments
        /*
         * Kinerja memori biasanya mengompresi beberapa nilai menjadi satu nilai
         * primitif. Ini mungkin berguna untuk meneruskan berbagai informasi ke dalam
         * satu variabel.
         * 
         * Misalnya, seseorang dapat mengemas 3 byte - seperti kode warna dalam RGB -
         * menjadi satu int.
         * 
         * Packing the values
         */

        public static void main(String[] args) {
                // System.out.println("Hai");
                // Raw bytes as input
                byte[] b = {
                                (byte) 0x65, (byte) 0xFF, (byte) 0x31
                };

                System.out.println(b);

                // Packed in big endian: x == 0x65FF31
                int x = (b[0] & 0xFF) << 16 // Red
                                | (b[1] & 0xFF) << 8 // Green
                                | (b[2] & 0xFF) << 0; // Blue

                // Packed in little endian: y == 0x31FF65
                int y = (b[0] & 0xFF) << 0
                                | (b[1] & 0xFF) << 8
                                | (b[2] & 0xFF) << 16;

                // Unpacking the values

                // Raw int32 as input
                int a = 0x31FF65;
                // Unpacked in big endian: {0x65, 0xFF, 0x31}
                byte[] c = {
                                (byte) (x >> 16),
                                (byte) (x >> 8),
                                (byte) (x & 0xFF)
                };
                // Unpacked in little endian: {0x31, 0xFF, 0x65}
                byte[] d = {
                                (byte) (x & 0xFF),
                                (byte) (x >> 8),
                                (byte) (x >> 16)
                };
        }
}
