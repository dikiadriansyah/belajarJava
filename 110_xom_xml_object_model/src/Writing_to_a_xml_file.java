import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.Serializer;

public class Writing_to_a_xml_file {
    // Writing to a XML File/Menulis ke File XML

    /*
     * Menulis ke File XML menggunakan XOM sangat mirip dengan membacanya kecuali
     * dalam kasus ini kita membuat instance alih-alih mengambilnya dari root.
     * 
     * Untuk membuat Elemen baru gunakan constructor Element (nama String). Anda
     * ingin membuat elemen root sehingga Anda dapat dengan mudah menambahkannya ke
     * Document.
     * 
     * 
     * Element root = new Element("root");
     */

    // Kelas Elemen memiliki beberapa metode praktis untuk mengedit elemen. Mereka
    // tercantum di bawah ini:
    /*
     * appendChild(String name) - ini pada dasarnya akan menetapkan nilai elemen
     * menjadi nama.
     * appendChild(Node node) - ini akan menjadikan simpul sebagai elemen induk.
     * (Elemen adalah node sehingga Anda dapat mengurai elemen).
     * addAttribute(Attribute attribute) - akan menambahkan atribut ke elemen.
     * 
     */

    /*
     * Kelas Atribut memiliki beberapa konstruktor berbeda. Yang paling sederhana
     * adalah Atribut (Nama string, Nilai string).
     * 
     * Setelah semua elemen Anda ditambahkan ke elemen root, Anda dapat mengubahnya
     * menjadi Document. Document akan mengambil Element sebagai argumen di
     * konstruktornya.
     */

    /*
     * Anda dapat menggunakan Serializer untuk menulis XML Anda ke file. Anda perlu
     * membuat aliran keluaran baru untuk diurai di
     * constructor of Serializer.
     */

    /*
     * FileOutputStream fileOutputStream = new FileOutputStream(file);
     * Serializer serializer = new Serializer(fileOutputStream, "UTF-8");
     * serializer.setIndent(4);
     * serializer.write(doc);
     */

    // contoh:

    // kode:

    /*
     * import java.io.File;
     * import java.io.FileOutputStream;
     * import java.io.IOException;
     * import java.io.UnsupportedEncodingException;
     * import nu.xom.Attribute;
     * import nu.xom.Builder;
     * import nu.xom.Document;
     * import nu.xom.Element;
     * import nu.xom.Elements;
     * import nu.xom.ParsingException;
     * import nu.xom.Serializer;
     * 
     * public class XMLWriter{
     * 
     * public static void main(String[] args) throws UnsupportedEncodingException,
     * IOException{
     * // root element <example>
     * Element root = new Element("example");
     * 
     * // make a array of people to store
     * Person[] people = {new Person("Smith", "Dan", "years", "green", 23),
     * new Person("Autry", "Bob", "months", "N/A", 3)};
     * 
     * // add all the people
     * for (Person person : people){
     * 
     * // make the main person element <person>
     * Element personElement = new Element("person");
     * 
     * // make the name element and it's children: first and last
     * Element nameElement = new Element("name");
     * Element firstNameElement = new Element("first");
     * Element lastNameElement = new Element("last");
     * 
     * // make age element
     * Element ageElement = new Element("age");
     * 
     * // make favorite color element
     * Element favColorElement = new Element("fav_color");
     * 
     * // add value to names
     * firstNameElement.appendChild(person.getFirstName());
     * lastNameElement.appendChild(person.getLastName());
     * 
     * // add names to name
     * nameElement.appendChild(firstNameElement);
     * nameElement.appendChild(lastNameElement);
     * 
     * // add value to age
     * ageElement.appendChild(String.valueOf(person.getAge()));
     * 
     * // add unit attribute to age
     * ageElement.addAttribute(new Attribute("unit", person.getAgeUnit()));
     * 
     * // add value to favColor
     * favColorElement.appendChild(person.getFavoriteColor());
     * 
     * // add all contents to person
     * personElement.appendChild(nameElement);
     * personElement.appendChild(ageElement);
     * personElement.appendChild(favColorElement);
     * 
     * // add person to root
     * root.appendChild(personElement);
     * }
     * 
     * // create doc off of root
     * Document doc = new Document(root);
     * 
     * // the file it will be stored in
     * File file = new File("out.xml");
     * if (!file.exists()){
     * file.createNewFile();
     * }
     * 
     * // get a file output stream ready
     * FileOutputStream fileOutputStream = new FileOutputStream(file);
     * 
     * // use the serializer class to write it all
     * Serializer serializer = new Serializer(fileOutputStream, "UTF-8");
     * serializer.setIndent(4);
     * serializer.write(doc);
     * }
     * private static class Person {
     * private String lName, fName, ageUnit, favColor;
     * private int age;
     * public Person(String lName, String fName, String ageUnit, String favColor,
     * int age){
     * this.lName = lName;
     * this.fName = fName;
     * this.age = age;
     * this.ageUnit = ageUnit;
     * this.favColor = favColor;
     * }
     * public String getLastName() { return lName; }
     * public String getFirstName() { return fName; }
     * public String getAgeUnit() { return ageUnit; }
     * public String getFavoriteColor() { return favColor; }
     * public int getAge() { return age; }
     * }
     * 
     * }
     */

    // Ini akan menjadi isi dari "out.xml":

    public static void main(String[] args) throws UnsupportedEncodingException,
            IOException {
        // root element <example>
        Element root = new Element("example");

        // make a array of people to store
        Person[] people = { new Person("Smith", "Dan", "years", "green", 23),
                new Person("Autry", "Bob", "months", "N/A", 3) };

        // add all the people
        for (Person person : people) {

            // make the main person element <person>
            Element personElement = new Element("person");

            // make the name element and it's children: first and last
            Element nameElement = new Element("name");
            Element firstNameElement = new Element("first");
            Element lastNameElement = new Element("last");

            // make age element
            Element ageElement = new Element("age");

            // make favorite color element
            Element favColorElement = new Element("fav_color");

            // add value to names
            firstNameElement.appendChild(person.getFirstName());
            lastNameElement.appendChild(person.getLastName());

            // add names to name
            nameElement.appendChild(firstNameElement);
            nameElement.appendChild(lastNameElement);

            // add value to age
            ageElement.appendChild(String.valueOf(person.getAge()));

            // add unit attribute to age
            ageElement.addAttribute(new Attribute("unit", person.getAgeUnit()));

            // add value to favColor
            favColorElement.appendChild(person.getFavoriteColor());

            // add all contents to person
            personElement.appendChild(nameElement);
            personElement.appendChild(ageElement);
            personElement.appendChild(favColorElement);

            // add person to root
            root.appendChild(personElement);
        }

        // create doc off of root
        Document doc = new Document(root);

        // the file it will be stored in
        File file = new File("out.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        // get a file output stream ready
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        // use the serializer class to write it all
        Serializer serializer = new Serializer(fileOutputStream, "UTF-8");
        serializer.setIndent(4);
        serializer.write(doc);
    }

    private static class Person {
        private String lName, fName, ageUnit, favColor;
        private int age;

        public Person(String lName, String fName, String ageUnit, String favColor, int age) {
            this.lName = lName;
            this.fName = fName;
            this.age = age;
            this.ageUnit = ageUnit;
            this.favColor = favColor;
        }

        public String getLastName() {
            return lName;
        }

        public String getFirstName() {
            return fName;
        }

        public String getAgeUnit() {
            return ageUnit;
        }

        public String getFavoriteColor() {
            return favColor;
        }

        public int getAge() {
            return age;
        }
    }

}
