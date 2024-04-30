import java.util.concurrent.CompletableFuture;

public class simple_example_of_completablefuture {
    // Simple Example of CompletableFuture/Contoh Sederhana dari CompletableFuture

    /*
     * Pada contoh di bawah, metode calculateShippingPrice menghitung biaya
     * pengiriman, yang memerlukan beberapa waktu pemrosesan. Dalam contoh dunia
     * nyata, ini misalnya. menghubungi server lain yang mengembalikan harga
     * berdasarkan berat produk dan metode pengiriman.
     * 
     * Dengan memodelkannya secara asinkron melalui CompletableFuture, kita dapat
     * melanjutkan pekerjaan berbeda dalam metode ini (yaitu menghitung biaya
     * pengemasan).
     * 
     * 
     */

    /*
     * public static void main(String[] args) {
     * int price = 15; // Let's keep it simple and work with whole number prices
     * here
     * int weightInGrams = 900;
     * 
     * calculateShippingPrice(weightInGrams) // Here, we get the future
     * .thenAccept(shippingPrice -> { // And then immediately work on it!
     * // This fluent style is very useful for keeping it concise
     * System.out.println("Your total price is: " + (price + shippingPrice));
     * });
     * System.out.println("Please stand by. We are calculating your total price.");
     * }
     * 
     * 
     * public static CompletableFuture<Integer> calculateShippingPrice(int
     * weightInGrams) {
     * return CompletableFuture.supplyAsync(() -> {
     * // supplyAsync is a factory method that turns a given
     * // Supplier<U> into a CompletableFuture<U>
     * // Let's just say each 200 grams is a new dollar on your shipping costs
     * int shippingCosts = weightInGrams / 200;
     * 
     * try {
     * Thread.sleep(2000L); // Now let's simulate some waiting time...
     * } catch(InterruptedException e) { //We can safely ignore that }
     * return shippingCosts; // And send the costs back!
     * });
     * }
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        int price = 15; // Let's keep it simple and work with whole number prices here
        int weightInGrams = 900;

        calculateShippingPrice(weightInGrams) // Here, we get the future
                .thenAccept(shippingPrice -> { // And then immediately work on it!
                    // This fluent style is very useful for keeping it concise
                    System.out.println("Your total price is: " + (price + shippingPrice));
                });

        System.out.println("Please stand by. We are calculating your total price.");

        // To prevent the program from exiting before CompletableFuture completes
        try {
            Thread.sleep(3000L); // Wait for CompletableFuture to complete (additional 1 second)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * output:
         * Please stand by. We are calculating your total price.
         * Your total price is: 19
         */

    }

    public static CompletableFuture<Integer> calculateShippingPrice(int weightInGrams) {
        return CompletableFuture.supplyAsync(() -> {
            // supplyAsync is a factory method that turns a given
            // Supplier<U> into a CompletableFuture<U>
            // Let's just say each 200 grams is a new dollar on your shipping costs
            int shippingCosts = weightInGrams / 200;

            try {
                Thread.sleep(2000L); // Now let's simulate some waiting time...
            } catch (InterruptedException e) {
                /* We can safely ignore that */ }
            return shippingCosts; // And send the costs back!
        });
    }

}
