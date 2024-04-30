public class Abstract_classes {
    // Abstract Classes

    /*
     * Kelas abstrak adalah kelas yang ditandai dengan kata kunci abstrak. Berbeda
     * dengan kelas non-abstrak, itu mungkin berisi
     * abstrak - tanpa implementasi - metode. Namun, sah untuk membuat kelas abstrak
     * tanpa metode abstrak.
     * 
     * Kelas abstrak tidak dapat dipakai. Itu dapat disubklasifikasikan (diperluas)
     * selama subkelasnya juga abstrak, atau mengimplementasikan semua metode yang
     * ditandai sebagai abstrak oleh kelas super.
     */

    // Contoh kelas abstrak:
    /*
     * public abstract class Component {
     * private int x, y;
     * 
     * public setPosition(int x, int y) {
     * this.x = x;
     * this.y = y;
     * }
     * public abstract void render();
     * }
     */

    /*
     * Kelas harus ditandai abstrak, bila memiliki setidaknya satu metode abstrak.
     * Metode abstrak adalah metode yang tidak memiliki implementasi. Metode lain
     * dapat dideklarasikan dalam kelas abstrak yang implementasinya berurutan
     * untuk memberikan kode umum untuk setiap sub-kelas.
     * 
     * Mencoba membuat instance kelas ini akan menghasilkan kesalahan kompilasi:
     * 
     * //error: Component is abstract; cannot be instantiated
     * Component myComponent = new Component();
     * 
     */

    /*
     * Namun kelas yang memperluas Component, dan menyediakan implementasi untuk
     * semua metode abstraknya dan bisa dipakai.
     * 
     * public class Button extends Component {
     * 
     * @Override
     * public void render() {
     * //render a button
     * }
     * }
     * public class TextBox extends Component {
     * 
     * @Override
     * public void render() {
     * //render a textbox
     * }
     * }
     */

    /*
     * Contoh kelas yang mewarisi juga dapat dijadikan sebagai kelas induk
     * (pewarisan normal) dan memberikan efek polimorfik ketika metode abstrak
     * dipanggil
     * 
     * Component myButton = new Button();
     * Component myTextBox = new TextBox();
     * myButton.render(); //renders a button
     * myTextBox.render(); //renders a text box
     */

    // Abstract classes vs Interfaces
    /*
     * Kelas abstrak dan antarmuka keduanya menyediakan cara untuk mendefinisikan
     * tanda tangan metode sambil memerlukan memperluas/menerapkan kelas untuk
     * menyediakan implementasi.
     * 
     * Ada dua perbedaan utama antara kelas abstrak dan antarmuka:
     * 1. Suatu kelas hanya dapat memperluas satu kelas, namun dapat
     * mengimplementasikan banyak antarmuka.
     * 
     * 2. Kelas abstrak dapat berisi bidang instan (non-statis), tetapi antarmuka
     * hanya boleh berisi bidang statis
     */

    // Version < Java SE 8
    /*
     * Metode yang dideklarasikan di antarmuka tidak boleh berisi implementasi, jadi
     * kelas abstrak digunakan saat itu
     * berguna untuk menyediakan metode tambahan yang implementasinya disebut metode
     * abstrak.
     */

    /*
     * versi > java se 8
     * 
     * Java 8 memungkinkan antarmuka memuat metode default, biasanya
     * diimplementasikan menggunakan metode antarmuka lainnya,
     * membuat antarmuka dan kelas abstrak sama kuatnya dalam hal ini.
     */

    // Anonymous subclasses of Abstract Classes / Subkelas anonim dari Kelas Abstrak

    /*
     * Demi kenyamanan, Java memungkinkan pembuatan instance subkelas anonim dari
     * kelas abstrak, yang menyediakan implementasi untuk metode abstrak saat
     * membuat objek baru. Dengan menggunakan contoh di atas, tampilannya akan
     * seperti ini:
     * 
     * Component myAnonymousComponent = new Component() {
     * 
     * @Override
     * public void render() {
     * // render a quick 1-time use component
     * }
     * }
     */

    public static void main(String[] args) {
        Component myButton = new Button();
        Component myTextBox = new TextBox();

        myButton.render(); // Renders a button
        myTextBox.render(); // Renders a textbox

        // Anonymous Component
        Component myAnonymousComponent = new Component() {
            @Override
            public void render() {
                System.out.println("Rendering a quick 1-time use component");
                // Implement rendering logic for a quick 1-time use component
            }
        };

        myAnonymousComponent.render(); // Renders the anonymous component

    }
}
