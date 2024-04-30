public class Generate_Cryptographically_random_data {
    // Generate Cryptographically Random Data/Hasilkan Data Acak Secara Kriptografis

    // Untuk menghasilkan sampel data acak secara kriptografis:
    /*
     * final byte[] sample = new byte[16];
     * new SecureRandom().nextBytes(sample);
     * System.out.println("Sample: " + DatatypeConverter.printHexBinary(sample));
     */

    // Menghasilkan output yang mirip dengan:
    // Sample: E4F14CEA2384F70B706B53A6DF8C5EFE

    /*
     * Perhatikan bahwa panggilan ke nextBytes() dapat diblokir saat entropi
     * dikumpulkan bergantung pada algoritme yang digunakan.
     * Untuk menentukan algoritme dan penyedia:
     * 
     * final byte[] sample = new byte[16];
     * final SecureRandom randomness = SecureRandom.getInstance("SHA1PRNG", "SUN");
     * randomness.nextBytes(sample);
     * System.out.println("Provider: " + randomness.getProvider());
     * System.out.println("Algorithm: " + randomness.getAlgorithm());
     * System.out.println("Sample: " + DatatypeConverter.printHexBinary(sample));
     */

    // Menghasilkan output yang mirip dengan:
    /*
     * Provider: SUN version 1.8
     * Algorithm: SHA1PRNG
     * Sample: C80C44BAEB352FD29FBBE20489E4C0B9
     */
    public static void main(String[] args) throws Exception {

    }
}
