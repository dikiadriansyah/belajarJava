public class Reverse_a_string_using_recursion {
    // Reverse a string using Recursion / Membalikkan string menggunakan Rekursi

    // Di bawah ini adalah kode rekursif untuk membalikkan string

    public static void main(String[] args) {
        String string = "hello world";
        System.out.println(reverse(string)); // prints dlrow olleh

    }

    public static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }

}
