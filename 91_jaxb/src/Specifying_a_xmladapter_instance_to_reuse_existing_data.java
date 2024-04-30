public class Specifying_a_xmladapter_instance_to_reuse_existing_data {
    // Specifying a XmlAdapter instance to (re)use existing data/ Menentukan
    // instance XmlAdapter untuk menggunakan (kembali) data yang ada

    /*
     * Terkadang contoh data tertentu harus digunakan. Rekreasi tidak diinginkan dan
     * referensi data static akan berbau kode.
     * 
     * Dimungkinkan untuk menentukan instance XmlAdapter yang harus digunakan oleh
     * Unmarshaller, yang memungkinkan pengguna untuk menggunakannya
     * XmlAdapters tanpa konstruktor zero-arg dan/atau meneruskan data ke adaptor.
     */

    // contoh

    // User class

    // Kelas berikut berisi nama dan gambar pengguna.

    /*
     * import java.awt.image.BufferedImage;
     * import javax.xml.bind.annotation.XmlAttribute;
     * import javax.xml.bind.annotation.XmlRootElement;
     * import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
     * 
     * @XmlRootElement
     * public class User {
     * 
     * private String name;
     * private BufferedImage image;
     * 
     * @XmlAttribute
     * public String getName() {
     * return name;
     * }
     * public void setName(String name) {
     * this.name = name;
     * }
     * 
     * @XmlJavaTypeAdapter(value=ImageCacheAdapter.class)
     * 
     * @XmlAttribute
     * public BufferedImage getImage() {
     * return image;
     * }
     * public void setImage(BufferedImage image) {
     * this.image = image;
     * }
     * public User(String name, BufferedImage image) {
     * this.name = name;
     * this.image = image;
     * }
     * public User() {
     * this("", null);
     * }
     * }
     */

    // Adapter

    /*
     * Untuk menghindari pembuatan gambar yang sama di memori dua kali (serta
     * mengunduh data lagi), adaptor menyimpan gambar dalam peta.
     */

    // Version ≤ Java SE 7

    /*
     * Untuk kode Java 7 yang valid, ganti metode getImage dengan
     * 
     * public BufferedImage getImage(URL url) {
     * BufferedImage image = imageCache.get(url);
     * if (image == null) {
     * try {
     * image = ImageIO.read(url);
     * } catch (IOException ex) {
     * Logger.getLogger(ImageCacheAdapter.class.getName()).log(Level.SEVERE, null,
     * ex);
     * return null;
     * }
     * imageCache.put(url, image);
     * reverseIndex.put(image, url);
     * }
     * return image;
     * }
     * import java.awt.image.BufferedImage;
     * import java.io.IOException;
     * import java.net.URL;
     * import java.util.HashMap;
     * import java.util.Map;
     * import java.util.logging.Level;
     * import java.util.logging.Logger;
     * import javax.imageio.ImageIO;
     * import javax.xml.bind.annotation.adapters.XmlAdapter;
     * public class ImageCacheAdapter extends XmlAdapter<String, BufferedImage> {
     * private final Map<URL, BufferedImage> imageCache = new HashMap<>();
     * private final Map<BufferedImage, URL> reverseIndex = new HashMap<>();
     * public BufferedImage getImage(URL url) {
     * // using a single lookup using Java 8 methods
     * return imageCache.computeIfAbsent(url, s -> {
     * try {
     * BufferedImage img = ImageIO.read(s);
     * reverseIndex.put(img, s);
     * return img;
     * } catch (IOException ex) {
     * Logger.getLogger(ImageCacheAdapter.class.getName()).log(Level.SEVERE, null,
     * ex);
     * return null;
     * }
     * });
     * }
     * 
     * @Override
     * public BufferedImage unmarshal(String v) throws Exception {
     * return getImage(new URL(v));
     * }
     * 
     * @Override
     * public String marshal(BufferedImage v) throws Exception {
     * return reverseIndex.get(v).toExternalForm();
     * }
     * }
     */

    // contoh XMLs

    /*
     * 2 xml berikut adalah untuk Jon Skeet dan rekan earth 2-nya, yang keduanya
     * terlihat persis sama dan karenanya menggunakan avatar yang sama.
     * 
     * <?xml version="1.0" encoding="UTF-8"?>
     * <user name="Jon Skeet"
     * image="https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=328
     * &amp;d=identicon&amp;r
     * =PG"/>
     * <?xml version="1.0" encoding="UTF-8"?>
     * <user name="Jon Skeet (Earth 2)"
     * image="https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=328
     * &amp;d=identicon&amp;r
     * =PG"/>
     */

    // Menggunakan adaptor

    /*
     * ImageCacheAdapter adapter = new ImageCacheAdapter();
     * JAXBContext context = JAXBContext.newInstance(User.class);
     * Unmarshaller unmarshaller = context.createUnmarshaller();
     * // specifiy the adapter instance to use for every
     * // @XmlJavaTypeAdapter(value=ImageCacheAdapter.class)
     * unmarshaller.setAdapter(ImageCacheAdapter.class, adapter);
     * User result1 = (User)
     * unmarshaller.unmarshal(Main.class.getResource("user.xml"));
     * // unmarshal second xml using the same adapter instance
     * Unmarshaller unmarshaller2 = context.createUnmarshaller();
     * unmarshaller2.setAdapter(ImageCacheAdapter.class, adapter);
     * User result2 = (User)
     * unmarshaller2.unmarshal(Main.class.getResource("user2.xml"));
     * System.out.println(result1.getName());
     * System.out.println(result2.getName());
     * // yields true, since image is reused
     * System.out.println(result1.getImage() == result2.getImage());
     */

    public static void main(String[] args) {

        ImageCacheAdapter adapter = new ImageCacheAdapter();
        JAXBContext context = JAXBContext.newInstance(User3.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // specifiy the adapter instance to use for every
        // @XmlJavaTypeAdapter(value=ImageCacheAdapter.class)
        unmarshaller.setAdapter(ImageCacheAdapter.class, adapter);
        User3 result1 = (User3) unmarshaller.unmarshal(Main.class.getResource("user.xml"));
        // unmarshal second xml using the same adapter instance

        Unmarshaller unmarshaller2 = context.createUnmarshaller();
        unmarshaller2.setAdapter(ImageCacheAdapter.class, adapter);
        User3 result2 = (User3) unmarshaller2.unmarshal(Main.class.getResource("user2.xml"));
        System.out.println(result1.getName());
        System.out.println(result2.getName());
        // yields true, since image is reused
        System.out.println(result1.getImage() == result2.getImage());

    }
}
