import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map.Entry;
import java.util.Properties;

public class Property_files_caveat_trailing_whitespace {
    // Property files caveat: trailing whitespace/Peringatan file properti: spasi
    // tambahan

    /*
     * Perhatikan baik-baik kedua file properti ini yang tampaknya sepenuhnya
     * identik:
     */

    // kecuali keduanya sebenarnya tidak identik:

    // (tangkapan layar diambil dari Notepad++)

    /*
     * Karena spasi di akhir dipertahankan, nilai lastName adalah "Smith" pada kasus
     * pertama dan "Smith " pada kasus kedua.
     * 
     * Sangat jarang hal ini yang diharapkan pengguna dan seseorang hanya dapat
     * berspekulasi mengapa ini adalah perilaku default kelas Properties. Namun
     * mudah untuk membuat versi Properti yang disempurnakan yang memperbaiki
     * masalah ini. Kelas berikutnya, TrimmedProperties, melakukan hal itu. Ini
     * adalah pengganti drop-in untuk kelas Properties standar.
     */

    /*
     * import java.io.FileInputStream;
     * import java.io.FileReader;
     * import java.io.IOException;
     * import java.io.InputStream;
     * import java.io.Reader;
     * import java.util.Map.Entry;
     * import java.util.Properties;
     * 
     * Properties class where values are trimmed for trailing whitespace if the
     * properties are loaded from a file.
     *
     * <p>
     * In the standard {@link java.util.Properties Properties} class trailing
     * whitespace is always preserved. When loading properties from a file such
     * trailing whitespace is almost always <i>unintentional</i>. This class fixes
     * this problem. The trimming of trailing whitespace only takes place if the
     * source of input is a file and only where the input is line oriented (meaning
     * that for example loading from XML file is <i>not</i> changed by this class).
     * For this reason this class is almost in all cases a safe drop-in replacement
     * for the standard <tt>Properties</tt>
     * class.
     *
     * <p>
     * Whitespace is defined here as any of space (U+0020) or tab (U+0009).
     * 
     * 
     * public class TrimmedProperties extends Properties {
     * 
     * /**
     * Reads a property list (key and element pairs) from the input byte stream.
     *
     * <p>Behaves exactly as {@link java.util.Properties#load(java.io.InputStream) }
     * with the exception that trailing whitespace is trimmed from property values
     * if <tt>inStream</tt> is an instance of <tt>FileInputStream</tt>.
     *
     * @see java.util.Properties#load(java.io.InputStream)
     * 
     * @param inStream the input stream.
     * 
     * @throws IOException if an error occurred when reading from the input stream.
     * 
     * @Override
     * public void load(InputStream inStream) throws IOException {
     * if (inStream instanceof FileInputStream) {
     * // First read into temporary props using the standard way
     * Properties tempProps = new Properties();
     * tempProps.load(inStream);
     * // Now trim and put into target
     * trimAndLoad(tempProps);
     * } else {
     * super.load(inStream);
     * }
     * }
     * 
     * /**
     * Reads a property list (key and element pairs) from the input character stream
     * in a simple
     * line-oriented format.
     *
     * <p>Behaves exactly as {@link java.util.Properties#load(java.io.Reader)}
     * with the exception that trailing whitespace is trimmed on property values
     * if <tt>reader</tt> is an instance of <tt>FileReader</tt>.
     *
     * @see java.util.Properties#load(java.io.Reader) }
     * 
     * @param reader the input character stream.
     * 
     * @throws IOException if an error occurred when reading from the input stream.
     * 
     * 
     * @Override
     * public void load(Reader reader) throws IOException {
     * if (reader instanceof FileReader) {
     * // First read into temporary props using the standard way
     * Properties tempProps = new Properties();
     * tempProps.load(reader);
     * // Now trim and put into target
     * trimAndLoad(tempProps);
     * } else {
     * super.load(reader);
     * }
     * }
     * private void trimAndLoad(Properties p) {
     * for (Entry<Object, Object> entry : p.entrySet()) {
     * if (entry.getValue() instanceof String) {
     * put(entry.getKey(), trimTrailing((String) entry.getValue()));
     * } else {
     * put(entry.getKey(), entry.getValue());
     * }
     * }
     * }
     * 
     * 
     * Trims trailing space or tabs from a string.
     *
     * @param str
     * 
     * @return
     * 
     * public static String trimTrailing(String str) {
     * if (str != null) {
     * // read str from tail until char is no longer whitespace
     * for (int i = str.length() - 1; i >= 0; i--) {
     * if ((str.charAt(i) != ' ') && (str.charAt(i) != '\t')) {
     * return str.substring(0, i + 1);
     * }
     * }
     * }
     * return str;
     * }
     * }
     * 
     */

    public static void main(String[] args) {
        try {
            // Using FileInputStream with an absolute file path
            String filePath = "example.properties";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            TrimmedProperties trimmedPropertiesFromFile = new TrimmedProperties();
            trimmedPropertiesFromFile.load(fileInputStream);
            fileInputStream.close();

            // Using FileReader with an absolute file path
            String readerFilePath = "example.txt";
            FileReader fileReader = new FileReader(readerFilePath);
            TrimmedProperties trimmedPropertiesFromReader = new TrimmedProperties();
            trimmedPropertiesFromReader.load(fileReader);
            fileReader.close();

            // Print the properties after trimming
            System.out.println("Properties from file:");
            trimmedPropertiesFromFile.list(System.out);

            /*
             * output:
             * Properties from file:
             * -- listing properties --
             * umur=25
             * kota=Kota Contoh
             * nama=John Doe
             * alamat=Jalan Contoh No. 123
             */

            System.out.println("\nProperties from reader:");
            trimmedPropertiesFromReader.list(System.out);

            /*
             * output:
             * Properties from reader:
             * -- listing properties --
             * uji=coba
             */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
