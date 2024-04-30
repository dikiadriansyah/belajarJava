import java.io.Serializable;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignedObject;

public class SignedObject2 {
    // SignedObject (java.security.SignedObject)

    /*
     * SignedObject adalah kelas yang bertujuan untuk membuat objek runtime autentik
     * yang integritasnya tidak dapat dikompromikan tanpa terdeteksi.
     * 
     * Lebih khusus lagi, SignedObject berisi objek Serializable lainnya, objek yang
     * ditandatangani (yang akan) ditandatangani dan tanda tangannya.
     */

    public static void main(String[] args) throws Exception {
        // Create a key
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        keyGen.initialize(1024, random);
        // create a private key
        PrivateKey signingKey = keyGen.generateKeyPair().getPrivate();
        // create a Signature
        Signature signingEngine = Signature.getInstance("DSA");
        signingEngine.initSign(signingKey);
        // create a simple object
        Serializable obj = new String("John");
        // sign our object
        SignedObject signedObject = new SignedObject(obj, signingKey, signingEngine);
        System.out.println("signedObject-" + signedObject); // output: signedObject-java.security.SignedObject@90f6bfd
        System.out.println("signedObject Data-" + signedObject.getObject()); // output: signedObject Data-John

    }
}
