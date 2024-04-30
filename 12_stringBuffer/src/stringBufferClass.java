public class stringBufferClass {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Key Points:
        // used to created mutable (modifiable) string.
        // Mutable: Which can be changed.
        // is thread-safe i.e. multiple threads cannot access it simultaneously

        // Methods:
        // public synchronized StringBuffer append(String s)
        // public synchronized StringBuffer insert(int offset, String s)
        // public synchronized StringBuffer replace(int startIndex, int endIndex, String
        // str)
        // public synchronized StringBuffer delete(int startIndex, int endIndex)
        // public synchronized StringBuffer reverse()
        // public int capacity()
        // public void ensureCapacity(int minimumCapacity)
        // public char charAt(int index)
        // public int length()
        // public String substring(int beginIndex)
        // public String substring(int beginIndex, int endIndex)

        // Contoh Menampilkan perbedaan antara implementasi String dan String Buffer(
        // Example Showing difference between String and String Buffer implementation):
        String berita = "kemacetan";
        String res = berita.concat("pagi");
        System.out.println(res); // output: kemacetanpagi

        StringBuffer stringBerita = new StringBuffer("kemacetan");
        stringBerita.append("pagi");
        // System.out.println(stringBerita); // output: kemacetanpagi

    }
}
