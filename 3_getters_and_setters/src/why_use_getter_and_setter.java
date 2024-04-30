public class why_use_getter_and_setter {
    public static void main(String[] args) {
        CountHolder obj = new CountHolder();
        obj.setCount(2);
        System.out.println("Hai, Dunia! Umur saya adalah " + obj.getCount());

    }
}

// penjelasan:
// awalnya membuat 2 file java yaitu CountHolder.java, dan
// why_use_getter_and_setter.java,
// selanjutnya pada file countHolder.java berisi private int count; metode
// getCount(), dan metode getCount()
// selanjutnya di file why_use_getter_.java berisi public static void main(){},
// selanjutnya metode main(){} berisi variabel bernama obj dengan nilai keyword
// new CountHolder(),
// selanjutnya variabel obj dikolaborasi metode .setCount()
