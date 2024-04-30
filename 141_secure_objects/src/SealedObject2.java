import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
// import java.security.KeyGenerator;
import java.security.*;
import javax.crypto.*;

public class SealedObject2 {
    // SealedObject (javax.crypto.SealedObject)

    /*
     * Kelas ini memungkinkan seorang programmer untuk membuat suatu objek dan
     * melindungi kerahasiaannya dengan algoritma kriptografi.
     * 
     * Mengingat objek Serializable apa pun, seseorang dapat membuat SealedObject
     * yang merangkum objek asli, dalam format serial (yaitu, "salinan dalam"), dan
     * menyegel (mengenkripsi) konten serialnya, menggunakan algoritma kriptografi
     * seperti AES,
     * DES, untuk melindungi kerahasiaannya. Konten terenkripsi nantinya dapat
     * didekripsi (dengan algoritma yang sesuai menggunakan kunci dekripsi yang
     * benar) dan de-serialisasi, menghasilkan objek asli.
     */

    /*
     * Serializable obj = new String("John");
     * // Generate key
     * KeyGenerator kgen = KeyGenerator.getInstance("AES");
     * kgen.init(128);
     * SecretKey aesKey = kgen.generateKey();
     * Cipher cipher = Cipher.getInstance("AES");
     * cipher.init(Cipher.ENCRYPT_MODE, aesKey);
     * SealedObject sealedObject = new SealedObject(obj, cipher);
     * System.out.println("sealedObject-" + sealedObject);
     * System.out.println("sealedObject Data-" + sealedObject.getObject(aesKey));
     */
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ------------
        Serializable obj = new String("John");
        // Generate key
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        SecretKey aesKey = kgen.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        SealedObject sealedObject = new SealedObject(obj, cipher);

        System.out.println("sealedObject-" + sealedObject);
        System.out.println("sealedObject Data-" + sealedObject.getObject(aesKey));
        /*
         * output:
         * sealedObject-javax.crypto.SealedObject@69ea3742
         * sealedObject Data-John
         */
    }

}