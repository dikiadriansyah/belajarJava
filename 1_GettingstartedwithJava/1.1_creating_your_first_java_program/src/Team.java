
// berikut contoh lain yg menunjukkan OO paradigm. mari kita buat model tim
// sepak bola dengan satu (ya, satu!) anggota.
// mungkin ada lebih banyak, tetapi kita akan membahasnya saat kita membahas
// array.

// Pertama, mari kita tentukan kelas Team kita:
// public class Team {
// Member member;
// public Team(Member member) { // who is in this Team / siapa yg ada di tim ini?
// this.member = member; // one 'member' is in this Team / satu 'anggota' ada di Tim ini!
// }
// }

// sekarang, mari kita definisikan member class kita:

// class Member {
// private String name;
// private String type;
// private int level; // note the data type here / perhatikan tipe datanya disini
// private int rank; // note the data type here as well / perhatikan juga tipe data di sini

// public Member(String name, String type, int level, int rank) {
// this.name = name;
// this.type = type;
// this.level = level;
// this.rank = rank;
// }
// }

// mengapa kami menggunakan private disini? Nah. jika seseorang ingin mengetahui
// nama anda, mereka harus bertanya langsung kepada anda, alih-alih merogoh saku
// anda dan mengeluarkan kartu jaminan sosial anda.

// private ini melakukan sesuatu seperti itu: mencegah entitas luar mengakses
// variabel anda.
// anda hanya dapat mengembalikan anggota pribadi melalui getter
// functions(ditampilkan dibawah).

// setelah menyatukan semuanya, dan menambahkan getter dan metode utama seperti
// yg telah dibahas sebelumnya, kita memiliki:

public class Team { // bagian class
    Member member;

    public Team(Member member) {
        this.member = member;
    }

    // here's our main method
    public static void main(String[] args) { // main method
        Member myMember = new Member("Dhiki", "Gold", 10, 1);
        Team myTeam = new Team(myMember);
        System.out.println(myTeam.member.getName());
        System.out.println(myTeam.member.getType());
        System.out.println(myTeam.member.getLevel());
        System.out.println(myTeam.member.getRank());
    }
}

class Member {

    // membuat variabel
    private String name;
    private String type;
    private int level;
    private int rank;

    public Member(String name, String type, int level, int rank) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.rank = rank;
    }

    /*
     * let's define our getter functions here / mari kita tentukan fungsi pengambil
     * kita di sini
     */
    public String getName() { // what is your name?
        return this.name; // my name is ...
    }

    public String getType() { // what is your type?
        return this.type; // my type is ...
    }

    public int getLevel() { // what is your level?
        return this.level; // my level is ...
    }

    public int getRank() { // what is your rank?
        return this.rank; // my rank is
    }
}

// hasil:
// Aurieel
// light
// 10
// 1

// penjelasan:
// awalnya membuat public class Team{} yg berisi atribut member, public
// Team(){}, main method(){},
// selanjutnya

// sekali lagi, metode utama di dalam kelas Test adalah titik masuk ke program
// kita.
// tanpa metode main, kita tidak dapat memberi tahu Java Virtual Machine (JVM)
// dari mana memulai eksekusi program.

// 1 - karena kelas AppPertama memiliki sedikit hubungan dengan kelas
// sistem(System class),
// kelas tersebut hanya dapa mengakses data publik (public data)