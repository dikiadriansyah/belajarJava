
// Kelas yang mengimplementasikan interface I
class Myclass implements I {
    @Override
    public void method() {
        System.out.println("Implementation of method in MyClass");
    }

    // Anda dapat memilih untuk meng-overwrite atau tidak meng-implementasikan
    // staticMethod
    // karena static method dapat dipanggil langsung melalui interface I.
}