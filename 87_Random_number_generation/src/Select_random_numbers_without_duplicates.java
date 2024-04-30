public class Select_random_numbers_without_duplicates {
    // Select random numbers without duplicates/Pilih nomor acak tanpa duplikat

    /**
     * returns a array of random numbers with no duplicates
     * 
     * @param range
     *            the range of possible numbers for ex. if 100 then it can be
     *            anywhere from 1-100
     * @param length
     *            the length of the array of random numbers
     * @return array of random numbers with no duplicates.
     */

    /*
     * public static int[] getRandomNumbersWithNoDuplicates(int range, int length){
     * if (length<range){
     * // this is where all the random numbers
     * int[] randomNumbers = new int[length];
     * 
     * // loop through all the random numbers to set them
     * for (int q = 0; q < randomNumbers.length; q++){
     * 
     * // get the remaining possible numbers
     * int remainingNumbers = range-q;
     * 
     * // get a new random number from the remainingNumbers
     * int newRandSpot = (int) (Math.random()*remainingNumbers);
     * 
     * newRandSpot++;
     * 
     * // loop through all the possible numbers
     * for (int t = 1; t < range+1; t++){
     * 
     * // check to see if this number has already been taken
     * boolean taken = false;
     * for (int number : randomNumbers){
     * if (t==number){
     * taken = true;
     * break;
     * }
     * }
     * 
     * // if it hasnt been taken then remove one from the spots
     * if (!taken){
     * newRandSpot--;
     * 
     * // if we have gone though all the spots then set the value
     * if (newRandSpot==0){
     * randomNumbers[q] = t;
     * }
     * }
     * }
     * }
     * return randomNumbers;
     * } else {
     * // invalid can't have a length larger then the range of possible numbers
     * }
     * return null;
     * }
     */

    /*
     * Metode ini bekerja dengan mengulang array yang memiliki ukuran panjang yang
     * diminta dan menemukan sisa panjang angka yang mungkin. Ini menetapkan nomor
     * acak dari kemungkinan nomor newRandSpot dan menemukan nomor tersebut dalam
     * nomor tersisa yang tidak diambil. Hal ini dilakukan dengan mengulang rentang
     * tersebut dan memeriksa apakah nomor tersebut telah diambil.
     * 
     * Misal rangenya 5 dan length 3 dan kita sudah memilih angka 2. Maka kita
     * punya 4
     * angka yang tersisa sehingga kita mendapatkan angka acak antara 1 dan 4 dan
     * kita mengulangi range(5) dengan melewatkan angka apa pun yang
     * telah kita used(2).
     * 
     * Sekarang misalkan angka berikutnya yang dipilih antara 1 & 4 adalah 3. Pada
     * putaran pertama kita mendapatkan 1 yang belum diambil sehingga kita dapat
     * menghilangkan 1 dari 3 sehingga menjadi 2. Sekarang pada putaran kedua kita
     * mendapatkan 2 yang telah diambil jadi kami tidak melakukan apa pun.
     * Kita mengikuti pola ini sampai kita mendapatkan 4 dimana setelah kita
     * menghapus 1 maka menjadi 0 jadi kita atur new randomNumber menjadi 4.
     */

    public static int[] getRandomNumbersWithNoDuplicates(int range, int length) {
        if (length < range) {
            // this is where all the random numbers
            int[] randomNumbers = new int[length];

            // loop through all the random numbers to set them
            for (int q = 0; q < randomNumbers.length; q++) {

                // get the remaining possible numbers
                int remainingNumbers = range - q;

                // get a new random number from the remainingNumbers
                int newRandSpot = (int) (Math.random() * remainingNumbers);

                newRandSpot++;

                // loop through all the possible numbers
                for (int t = 1; t < range + 1; t++) {

                    // check to see if this number has already been taken
                    boolean taken = false;
                    for (int number : randomNumbers) {
                        if (t == number) {
                            taken = true;
                            break;
                        }
                    }

                    // if it hasnt been taken then remove one from the spots
                    if (!taken) {
                        newRandSpot--;

                        // if we have gone though all the spots then set the value
                        if (newRandSpot == 0) {
                            randomNumbers[q] = t;
                        }
                    }
                }
            }
            return randomNumbers;
        } else {
            // invalid can't have a length larger then the range of possible numbers
        }
        return null;
    }

    public static void main(String[] args) {
        int range = 10;
        int length = 5;
        int[] randomNumbers = getRandomNumbersWithNoDuplicates(range, length);
        System.out.println("Angka Random dengan tidak duplikat: ");
        for (int randomNumber : randomNumbers) {
            System.out.println(randomNumber + " ");
        }
        /*
         * output:
         * Angka Random dengan tidak duplikat:
         * 8
         * 4
         * 5
         * 6
         * 1
         */
    }
}
