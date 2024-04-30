import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Fork_join_tasks_in_java extends RecursiveTask<Integer> {
    // Fork/Join Tasks in Java/ Fork/Gabung Tugas di Java

    /*
     * Kerangka kerja fork/join di Java sangat ideal untuk masalah yang dapat dibagi
     * menjadi bagian-bagian yang lebih kecil dan diselesaikan secara paralel.
     * Langkah-langkah mendasar dari masalah fork/join adalah:
     * 
     * 1. Bagilah masalah menjadi beberapa bagian
     * 2. Selesaikan setiap bagian secara paralel satu sama lain
     * 3. Gabungkan setiap sub-solusi menjadi satu solusi keseluruhan
     */

    /*
     * ForkJoinTask adalah antarmuka yang mendefinisikan masalah seperti itu. Secara
     * umum diharapkan Anda akan membuat subkelas salah satunya
     * implementasi abstrak (biasanya RecursiveTask) daripada mengimplementasikan
     * antarmuka secara langsung.
     * 
     * Dalam contoh ini, kita akan menjumlahkan kumpulan bilangan bulat, membaginya
     * hingga kita mendapatkan ukuran batch yang tidak lebih dari
     * sepuluh.
     */

    /*
     * import java.util.List;
     * import java.util.concurrent.RecursiveTask;
     * public class SummingTask extends RecursiveTask<Integer> {
     * private static final int MAX_BATCH_SIZE = 10;
     * private final List<Integer> numbers;
     * private final int minInclusive, maxExclusive;
     * public SummingTask(List<Integer> numbers) {
     * this(numbers, 0, numbers.size());
     * }
     * // This constructor is only used internally as part of the dividing process
     * private SummingTask(List<Integer> numbers, int minInclusive, int
     * maxExclusive) {
     * this.numbers = numbers;
     * this.minInclusive = minInclusive;
     * this.maxExclusive = maxExclusive;
     * }
     * 
     * @Override
     * public Integer compute() {
     * if (maxExclusive - minInclusive > MAX_BATCH_SIZE) {
     * // This is too big for a single batch, so we shall divide into two tasks
     * int mid = (minInclusive + maxExclusive) / 2;
     * SummingTask leftTask = new SummingTask(numbers, minInclusive, mid);
     * SummingTask rightTask = new SummingTask(numbers, mid, maxExclusive);
     * // Submit the left hand task as a new task to the same ForkJoinPool
     * leftTask.fork();
     * // Run the right hand task on the same thread and get the result
     * int rightResult = rightTask.compute();
     * // Wait for the left hand task to complete and get its result
     * int leftResult = leftTask.join();
     * // And combine the result
     * return leftResult + rightResult;
     * } else {
     * // This is fine for a single batch, so we will run it here and now
     * int sum = 0;
     * for (int i = minInclusive; i < maxExclusive; i++) {
     * sum += numbers.get(i);
     * }
     * return sum;
     * }
     * }
     * }
     */

    // Sebuah instance dari tugas ini sekarang dapat diteruskan ke sebuah instance
    // dari ForkJoinPool

    /*
     * // Because I am not specifying the number of threads
     * // it will create a thread for each available processor
     * ForkJoinPool pool = new ForkJoinPool();
     * // Submit the task to the pool, and get what is effectively the Future
     * ForkJoinTask<Integer> task = pool.submit(new SummingTask(numbers));
     * // Wait for the result
     * int result = task.join();
     */

    // --------------------------------

    private static final int MAX_BATCH_SIZE = 10;
    private final List<Integer> numbers;
    private final int minInclusive, maxExclusive;

    public Fork_join_tasks_in_java(List<Integer> numbers) {
        this(numbers, 0, numbers.size());
    }

    // This constructor is only used internally as part of the dividing process
    private Fork_join_tasks_in_java(List<Integer> numbers, int minInclusive, int maxExclusive) {
        this.numbers = numbers;
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }

    @Override
    public Integer compute() {
        if (maxExclusive - minInclusive > MAX_BATCH_SIZE) {
            // This is too big for a single batch, so we shall divide into two tasks
            int mid = (minInclusive + maxExclusive) / 2;
            Fork_join_tasks_in_java leftTask = new Fork_join_tasks_in_java(numbers, minInclusive, mid);
            Fork_join_tasks_in_java rightTask = new Fork_join_tasks_in_java(numbers, mid, maxExclusive);
            // Submit the left hand task as a new task to the same ForkJoinPool
            leftTask.fork();
            // Run the right hand task on the same thread and get the result
            int rightResult = rightTask.compute();
            // Wait for the left hand task to complete and get its result
            int leftResult = leftTask.join();
            // And combine the result
            return leftResult + rightResult;
        } else {
            // This is fine for a single batch, so we will run it here and now
            int sum = 0;
            for (int i = minInclusive; i < maxExclusive; i++) {
                sum += numbers.get(i);
            }
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------------

        // Create a list of numbers to sum
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        // Because I am not specifying the number of threads
        // it will create a thread for each available processor
        ForkJoinPool pool = new ForkJoinPool();
        // Submit the task to the pool, and get what is effectively the Future
        ForkJoinTask<Integer> task = pool.submit(new Fork_join_tasks_in_java(numbers));
        // Wait for the result
        int result = task.join();
        // Print the result
        System.out.println("Sum: " + result); // output: Sum 120
    }
}
