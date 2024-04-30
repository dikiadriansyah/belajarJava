public class Using_threadlocal {
    // Using ThreadLocal/Menggunakan ThreadLokal

    /*
     * Alat yang berguna dalam Java Concurrency adalah ThreadLocal – ini
     * memungkinkan Anda memiliki variabel yang unik untuk thread tertentu. Jadi,
     * jika kode yang sama berjalan di thread yang berbeda, eksekusi ini tidak akan
     * berbagi nilai, melainkan masing-masing
     * thread memiliki variabelnya sendiri yang bersifat lokal pada thread.
     * 
     * Misalnya, ini sering digunakan untuk menetapkan konteks (seperti informasi
     * otorisasi) dalam menangani permintaan di servlet. Anda mungkin melakukan
     * sesuatu seperti ini:
     * 
     * private static final ThreadLocal<MyUserContext> contexts = new
     * ThreadLocal<>();
     * public static MyUserContext getContext() {
     * return contexts.get(); // get returns the variable unique to this thread
     * }
     * public void doGet(...) {
     * MyUserContext context = magicGetContextFromRequest(request);
     * contexts.put(context); // save that context to our thread-local - other
     * threads
     * // making this call don't overwrite ours
     * try {
     * // business logic
     * } finally {
     * contexts.remove(); // 'ensure' removal of thread-local variable
     * }
     * }
     */

    /*
     * Sekarang, alih-alih meneruskan MyUserContext ke setiap metode, Anda bisa
     * menggunakan MyServlet.getContext()
     * di mana Anda membutuhkannya. Tentu saja, hal ini memperkenalkan variabel yang
     * perlu didokumentasikan, tetapi thread-safe menghilangkan banyak kerugian
     * dalam menggunakan variabel dengan cakupan tinggi.
     * 
     * Keuntungan utama di sini adalah bahwa setiap thread memiliki variabel lokal
     * thread sendiri dalam wadah contexts tersebut. Selama Anda menggunakannya dari
     * titik masuk yang ditentukan (seperti menuntut agar setiap servlet
     * mempertahankan konteksnya, atau mungkin dengan menambahkan filter servlet),
     * Anda dapat mengandalkan konteks ini untuk selalu ada saat Anda
     * membutuhkannya.
     */

    // --------------------------
    private static final ThreadLocal<MyUserContext> contexts = new ThreadLocal<>();

    public static MyUserContext getContext() {
        return contexts.get(); // get returns the variable unique to this thread
    }

public void doGet(...) {
 MyUserContext context = magicGetContextFromRequest(request);
 contexts.put(context); // save that context to our thread-local - other threads
 // making this call don't overwrite ours
 try {
 // business logic
 } finally {
 contexts.remove(); // 'ensure' removal of thread-local variable
 }
}

    public static void main(String[] args) throws InterruptedException {
    }
}
