public class Synchronized {
    // synchronized

    /*
     * Pengubah tersinkronisasi digunakan untuk mengontrol akses metode tertentu
     * atau blok oleh beberapa thread. Hanya satu thread yang dapat masuk ke dalam
     * suatu metode atau blok yang dinyatakan tersinkronisasi. kata kunci
     * tersinkronisasi berfungsi pada kunci intrinsik suatu objek, dalam kasus
     * metode tersinkronisasi kunci objek saat ini dan metode statis menggunakan
     * objek kelas. Setiap thread yang mencoba mengeksekusi blok tersinkronisasi
     * harus mendapatkan kunci objek terlebih dahulu.
     */

    /*
     * class Shared
     * {
     * int i;
     * synchronized void SharedMethod()
     * {
     * Thread t = Thread.currentThread();
     * for(int i = 0; i <= 1000; i++)
     * {
     * System.out.println(t.getName()+" : "+i);
     * }
     * }
     * void SharedMethod2()
     * {
     * synchronized (this)
     * {
     * System.out.println("Thais access to currect object is synchronize "+this);
     * }
     * }
     * }
     * public class ThreadsInJava
     * {
     * public static void main(String[] args)
     * {
     * final Shared s1 = new Shared();
     * Thread t1 = new Thread("Thread - 1")
     * {
     * 
     * @Override
     * public void run()
     * {
     * s1.SharedMethod();
     * }
     * };
     * Thread t2 = new Thread("Thread - 2")
     * {
     * 
     * @Override
     * public void run()
     * {
     * s1.SharedMethod();
     * }
     * };
     * t1.start();
     * t2.start();
     * }
     * }
     */

    public static void main(String[] args) throws Exception {
        final Shared s1 = new Shared();
        Thread t1 = new Thread("Thread - 1") {
            @Override
            public void run() {
                s1.SharedMethod();
            }
        };
        Thread t2 = new Thread("Thread - 2") {
            @Override
            public void run() {
                s1.SharedMethod();
            }
        };
        t1.start();
        t2.start();
        /*
         * output:
         * Thread - 1 : 0
         * Thread - 1 : 1
         * Thread - 1 : 2
         * Thread - 1 : 3
         * Thread - 1 : 4
         * Thread - 1 : 5
         * Thread - 1 : 6
         * Thread - 1 : 7
         * Thread - 1 : 8
         * Thread - 1 : 9
         * Thread - 1 : 10
         * Thread - 1 : 11
         * Thread - 1 : 12
         * Thread - 1 : 13
         * Thread - 1 : 14
         * Thread - 1 : 15
         * Thread - 1 : 16
         * Thread - 1 : 17
         * Thread - 1 : 18
         * Thread - 1 : 19
         * Thread - 1 : 20
         * Thread - 1 : 21
         * Thread - 1 : 22
         * Thread - 1 : 23
         * Thread - 1 : 24
         * Thread - 1 : 25
         * Thread - 1 : 26
         * Thread - 1 : 27
         * Thread - 1 : 28
         * Thread - 1 : 29
         * Thread - 1 : 30
         * Thread - 1 : 31
         * Thread - 1 : 32
         * Thread - 1 : 33
         * Thread - 1 : 34
         * Thread - 1 : 35
         * Thread - 1 : 36
         * Thread - 1 : 37
         * Thread - 1 : 38
         * Thread - 1 : 39
         * Thread - 1 : 40
         * Thread - 1 : 41
         * Thread - 1 : 42
         * Thread - 1 : 43
         * Thread - 1 : 44
         * Thread - 1 : 45
         * Thread - 1 : 46
         * Thread - 1 : 47
         * Thread - 1 : 48
         * Thread - 1 : 49
         * Thread - 1 : 50
         * Thread - 1 : 51
         * Thread - 1 : 52
         * Thread - 1 : 53
         * Thread - 1 : 54
         * Thread - 1 : 55
         * Thread - 1 : 56
         * Thread - 1 : 57
         * Thread - 1 : 58
         * Thread - 1 : 59
         * Thread - 1 : 60
         * Thread - 1 : 61
         * Thread - 1 : 62
         * Thread - 1 : 63
         * Thread - 1 : 64
         * Thread - 1 : 65
         * Thread - 1 : 66
         * Thread - 1 : 67
         * Thread - 1 : 68
         * Thread - 1 : 69
         * Thread - 1 : 70
         * Thread - 1 : 71
         * Thread - 1 : 72
         * Thread - 1 : 73
         * Thread - 1 : 74
         * Thread - 1 : 75
         * Thread - 1 : 76
         * Thread - 1 : 77
         * Thread - 1 : 78
         * Thread - 1 : 79
         * Thread - 1 : 80
         * Thread - 1 : 81
         * Thread - 1 : 82
         * Thread - 1 : 83
         * Thread - 1 : 84
         * Thread - 1 : 85
         * Thread - 1 : 86
         * Thread - 1 : 87
         * Thread - 1 : 88
         * Thread - 1 : 89
         * Thread - 1 : 90
         * Thread - 1 : 91
         * Thread - 1 : 92
         * Thread - 1 : 93
         * Thread - 1 : 94
         * Thread - 1 : 95
         * Thread - 1 : 96
         * Thread - 1 : 97
         * Thread - 1 : 98
         * Thread - 1 : 99
         * Thread - 1 : 100
         * Thread - 2 : 0
         * Thread - 2 : 1
         * Thread - 2 : 2
         * Thread - 2 : 3
         * Thread - 2 : 4
         * Thread - 2 : 5
         * Thread - 2 : 6
         * Thread - 2 : 7
         * Thread - 2 : 8
         * Thread - 2 : 9
         * Thread - 2 : 10
         * Thread - 2 : 11
         * Thread - 2 : 12
         * Thread - 2 : 13
         * Thread - 2 : 14
         * Thread - 2 : 15
         * Thread - 2 : 16
         * Thread - 2 : 17
         * Thread - 2 : 18
         * Thread - 2 : 19
         * Thread - 2 : 20
         * Thread - 2 : 21
         * Thread - 2 : 22
         * Thread - 2 : 23
         * Thread - 2 : 24
         * Thread - 2 : 25
         * Thread - 2 : 26
         * Thread - 2 : 27
         * Thread - 2 : 28
         * Thread - 2 : 29
         * Thread - 2 : 30
         * Thread - 2 : 31
         * Thread - 2 : 32
         * Thread - 2 : 33
         * Thread - 2 : 34
         * Thread - 2 : 35
         * Thread - 2 : 36
         * Thread - 2 : 37
         * Thread - 2 : 38
         * Thread - 2 : 39
         * Thread - 2 : 40
         * Thread - 2 : 41
         * Thread - 2 : 42
         * Thread - 2 : 43
         * Thread - 2 : 44
         * Thread - 2 : 45
         * Thread - 2 : 46
         * Thread - 2 : 47
         * Thread - 2 : 48
         * Thread - 2 : 49
         * Thread - 2 : 50
         * Thread - 2 : 51
         * Thread - 2 : 52
         * Thread - 2 : 53
         * Thread - 2 : 54
         * Thread - 2 : 55
         * Thread - 2 : 56
         * Thread - 2 : 57
         * Thread - 2 : 58
         * Thread - 2 : 59
         * Thread - 2 : 60
         * Thread - 2 : 61
         * Thread - 2 : 62
         * Thread - 2 : 63
         * Thread - 2 : 64
         * Thread - 2 : 65
         * Thread - 2 : 66
         * Thread - 2 : 67
         * Thread - 2 : 68
         * Thread - 2 : 69
         * Thread - 2 : 70
         * Thread - 2 : 71
         * Thread - 2 : 72
         * Thread - 2 : 73
         * Thread - 2 : 74
         * Thread - 2 : 75
         * Thread - 2 : 76
         * Thread - 2 : 77
         * Thread - 2 : 78
         * Thread - 2 : 79
         * Thread - 2 : 80
         * Thread - 2 : 81
         * Thread - 2 : 82
         * Thread - 2 : 83
         * Thread - 2 : 84
         * Thread - 2 : 85
         * Thread - 2 : 86
         * Thread - 2 : 87
         * Thread - 2 : 88
         * Thread - 2 : 89
         * Thread - 2 : 90
         * Thread - 2 : 91
         * Thread - 2 : 92
         * Thread - 2 : 93
         * Thread - 2 : 94
         * Thread - 2 : 95
         * Thread - 2 : 96
         * Thread - 2 : 97
         * Thread - 2 : 98
         * Thread - 2 : 99
         * Thread - 2 : 100
         */
    }
}
