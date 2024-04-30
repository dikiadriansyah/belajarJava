public class Abstract_class_and_interface_usage {
    /*
     * Abstract class and Interface usage: "Is-a" relation vs "Has-a" capability /
     * Kelas abstrak dan penggunaan Antarmuka: Relasi "Is-a" vs kemampuan "Has-a".
     */

    /*
     * Kapan menggunakan kelas abstrak: Untuk menerapkan perilaku yang sama atau
     * berbeda di antara beberapa objek terkait.
     * 
     * Kapan menggunakan antarmuka: untuk mengimplementasikan kontrak dengan
     * beberapa objek yang tidak terkait
     * 
     * Kelas abstrak membuat relasi "is a" sementara antarmuka menyediakan kemampuan
     * "memiliki".
     * 
     * Hal ini dapat dilihat pada kode di bawah ini:
     * 
     * public class InterfaceAndAbstractClassDemo{
     * public static void main(String args[]){
     * 
     * Dog dog = new Dog("Jack",16);
     * Cat cat = new Cat("Joe",20);
     * 
     * System.out.println("Dog:"+dog);
     * System.out.println("Cat:"+cat);
     * 
     * dog.remember();
     * dog.protectOwner();
     * Learn dl = dog;
     * dl.learn();
     * 
     * cat.remember();
     * cat.protectOwner();
     * 
     * Climb c = cat;
     * c.climb();
     * 
     * Man man = new Man("Ravindra",40);
     * System.out.println(man);
     * 
     * Climb cm = man;
     * cm.climb();
     * Think t = man;
     * t.think();
     * Learn l = man;
     * l.learn();
     * Apply a = man;
     * a.apply();
     * }
     * }
     * abstract class Animal{
     * String name;
     * int lifeExpentency;
     * public Animal(String name,int lifeExpentency ){
     * this.name = name;
     * this.lifeExpentency=lifeExpentency;
     * }
     * public abstract void remember();
     * public abstract void protectOwner();
     * 
     * public String toString(){
     * return this.getClass().getSimpleName()+":"+name+":"+lifeExpentency;
     * }
     * }
     * class Dog extends Animal implements Learn{
     * public Dog(String name,int age){
     * super(name,age);
     * }
     * public void remember(){
     * System.out.println(this.getClass().getSimpleName()
     * +" can remember for 5 minutes");
     * }
     * public void protectOwner(){
     * System.out.println(this.getClass().getSimpleName()+ " will protect owner");
     * }
     * public void learn(){
     * System.out.println(this.getClass().getSimpleName()+ " can learn:");
     * }
     * }
     * class Cat extends Animal implements Climb {
     * public Cat(String name,int age){
     * super(name,age);
     * }
     * public void remember(){
     * System.out.println(this.getClass().getSimpleName() +
     * " can remember for 16 hours");
     * }
     * public void protectOwner(){
     * System.out.println(this.getClass().getSimpleName()+ " won't protect owner");
     * }
     * public void climb(){
     * System.out.println(this.getClass().getSimpleName()+ " can climb");
     * }
     * }
     * interface Climb{
     * void climb();
     * }
     * interface Think {
     * void think();
     * }
     * interface Learn {
     * void learn();
     * }
     * interface Apply{
     * void apply();
     * }
     * class Man implements Think,Learn,Apply,Climb{
     * String name;
     * int age;
     * public Man(String name,int age){
     * this.name = name;
     * this.age = age;
     * }
     * public void think(){
     * System.out.println("I can think:"+this.getClass().getSimpleName());
     * }
     * public void learn(){
     * System.out.println("I can learn:"+this.getClass().getSimpleName());
     * }
     * public void apply(){
     * System.out.println("I can apply:"+this.getClass().getSimpleName());
     * }
     * public void climb(){
     * System.out.println("I can climb:"+this.getClass().getSimpleName());
     * }
     * public String toString(){
     * return "Man :"+name+":Age:"+age;
     * }
     * }
     * 
     */

    /*
     * output:
     * output:
     * Dog:Dog:Jack:16
     * Cat:Cat:Joe:20
     * Dog can remember for 5 minutes
     * Dog will protect owner
     * Dog can learn:
     * Cat can remember for 16 hours
     * Cat won't protect owner
     * Cat can climb
     * Man :Ravindra:Age:40
     * I can climb:Man
     * I can think:Man
     * I can learn:Man
     * I can apply:Man
     */

    /*
     * Catatan utama:
     * 1. Animal adalah kelas abstrak dengan atribut bersama: nama dan harapan hidup
     * serta metode abstrak:
     * remember() dan protectOwner(). Anjing dan Kucing adalah Hewan yang telah
     * mengimplementasikan fungsi ingat() dan
     * metode protectOwner().
     * 2. Kucing bisa climb() tetapi Anjing tidak bisa. Anjing bisa think()
     * tetapi Kucing tidak bisa. Kemampuan khusus ini ditambahkan ke Cat
     * dan Dog berdasarkan implementasi.
     * 3. Manusia bukanlah Binatang tetapi ia dapat Berpikir, Belajar, Menerapkan,
     * dan Mendaki.
     * 4. Kucing bukan Manusia tapi bisa Memanjat.
     * 5. Anjing bukan Manusia tapi bisa Belajar
     * 6. Manusia bukanlah Kucing atau Anjing tetapi dapat memiliki beberapa
     * kemampuan dari dua kemampuan terakhir tanpa memperluasnya
     * Hewan, Kucing, atau Anjing. Ini dilakukan dengan Antarmuka.
     * 7. Meskipun Animal adalah kelas abstrak, ia memiliki konstruktor, tidak
     * seperti antarmuka.
     */

    /*
     * TL;DR:
     * Kelas yang tidak terkait dapat memiliki kemampuan melalui antarmuka, namun
     * kelas terkait mengubah perilaku melalui perluasan kelas dasar.
     * 
     * Lihat halaman dokumentasi Java untuk memahami mana yang akan digunakan dalam
     * kasus penggunaan tertentu.
     */

    /*
     * Pertimbangkan untuk menggunakan kelas abstrak jika...
     * 1. Anda ingin berbagi kode di antara beberapa kelas yang terkait erat.
     * 2. Anda berharap bahwa kelas yang memperluas kelas abstrak Anda memiliki
     * banyak metode atau bidang yang umum, atau memerlukan
     * pengubah akses selain publik (seperti dilindungi dan pribadi).
     * 3. Anda ingin mendeklarasikan bidang non-statis atau non-final.
     */

    /*
     * Pertimbangkan untuk menggunakan antarmuka jika...
     * 1. Anda mengharapkan kelas yang tidak terkait akan mengimplementasikan
     * antarmuka Anda. Misalnya, banyak objek yang tidak berhubungan bisa
     * mengimplementasikan antarmuka Serializable.
     * 2. Anda ingin menentukan perilaku tipe data tertentu tetapi tidak memikirkan
     * siapa yang mengimplementasikannya
     * perilaku.
     * 3. Anda ingin memanfaatkan tipe pewarisan berganda.
     */

    public static void main(String[] args) {
        // Dog dog = new Dog("Jack", 16);
        // Cat cat = new Cat("Joe", 20);

        // System.out.println("Dog:" + dog);
        // System.out.println("Cat:" + cat);

        // dog.remember();
        // dog.protectOwner();
        // Learn dl = dog;
        // dl.learn();

        // cat.remember();
        // cat.protectOwner();

        // Climb c = cat;
        // c.climb();

        // Man man = new Man("Ravindra", 40);
        // System.out.println(man);

        // Climb cm = man;
        // cm.climb();
        // Think t = man;
        // t.think();
        // Learn l = man;
        // l.learn();
        // Apply a = man;
        // a.apply();

        /*
         * output:
         * Dog:Dog:Jack:16
         * Cat:Cat:Joe:20
         * 
         * Dog can remember for 5 minutes
         * Dog will protect owner
         * Dog can learn:
         * Cat can remember for 16 hours
         * Cat won't protect owner
         * Cat can climb
         * Man :Ravindra:Age:40
         * 
         * I can climb:Man
         * I can think:Man
         * I can learn:Man
         * I can apply:Man
         */
    }

}
