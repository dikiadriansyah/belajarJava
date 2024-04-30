import org.json.JSONObject;

public class Jsonobjectnull {
    // JSONObject.NULL

    /*
     * Jika Anda perlu menambahkan properti dengan nilai null, Anda harus
     * menggunakan JSONObject.NULL final statis yang telah ditentukan sebelumnya dan
     * bukan referensi null Java standar.
     * 
     * JSONObject.NULL adalah nilai penjaga yang digunakan untuk secara eksplisit
     * mendefinisikan properti dengan nilai kosong.
     * 
     * JSONObject obj = new JSONObject();
     * obj.put("some", JSONObject.NULL); //Creates: {"some":null}
     * System.out.println(obj.get("some"));//prints: null
     */

    /*
     * catatan:
     * JSONObject.NULL.equals(null); //returns true
     *
     */

    // Yang jelas merupakan pelanggaran kontrak Java.equals():
    // Untuk nilai referensi non-null x, x.equals(null) harus menghasilkan false

    public static void main(String[] args) throws Exception {

    }
}
