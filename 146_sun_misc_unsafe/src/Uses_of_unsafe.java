public class Uses_of_unsafe {
    // Uses of Unsafe/Penggunaan Tidak Aman

    // Beberapa kegunaan unsafe adalah sebagai berikut:
    /*
     * Use
     * Off heap / direct memory allocation,
     * reallocation and deallocation
     * 
     * Memory fences
     * 
     * Parking current thread
     * 
     * Direct field and or memory access
     * 
     * Throwing unchecked exceptions
     * 
     * CAS and Atomic Operations
     * 
     * Setting out memory setMemory
     * 
     * Volatile or concurrent operations
     * 
     */

    /*
     * API
     * allocateMemory(bytes), reallocateMemory(address, bytes) and
     * freeMemory(address)
     * 
     * loadFence(), storeFence(), fullFence()
     * 
     * park(isAbsolute, time), unpark(thread)
     * 
     * get*and put* familiy of methods
     * 
     * throwException(e)
     * 
     * compareAndSwap* family of methods
     * 
     * setMemory
     * 
     * get*Volatile, put*Volatile, putOrdered*
     * 
     * 
     * 
     */

    /*
     * Kelompok metode get dan put bersifat relatif terhadap objek tertentu. Jika
     * objeknya null maka objek tersebut diperlakukan sebagai alamat absolut.
     * 
     * // Putting a value to a field
     * protected static long fieldOffset =
     * UNSAFE.objectFieldOffset(getClass().getField("theField"));
     * UNSAFE.putLong(this, fieldOffset , newValue);
     * // Puting an absolute value
     * UNSAFE.putLong(null, address, newValue);
     * UNSAFE.putLong(address, newValue);
     * 
     */

    /*
     * Beberapa metode hanya didefinisikan untuk int dan long. Anda dapat
     * menggunakan metode ini pada float dan double menggunakan
     * floatToRawIntBits, intBitsToFloat,doubleToRawLongBits,longBitsToDouble
     */
    public static void main(String[] args) throws Exception {
        // Putting a value to a field
        protected static long fieldOffset = UNSAFE.objectFieldOffset(getClass().getField("theField"));
        UNSAFE.putLong(this, fieldOffset, newValue);
        // Puting an absolute value
        UNSAFE.putLong(null, address, newValue);
        UNSAFE.putLong(address, newValue);
    }
}
