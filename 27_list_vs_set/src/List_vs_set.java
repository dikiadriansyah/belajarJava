import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class List_vs_set {

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        System.out.println("List example .....");
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("1");
        for (String temp : list) {
            System.out.println(temp);
        }

        System.out.println("Set example .....");
        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("1");
        set.add("2");
        set.add("5");

        for (String temp : set) {
            System.out.println(temp);
        }

        /*
         * output:
         * List example .....
         * 1
         * 2
         * 3
         * 4
         * 1
         * Set example .....
         * 1
         * 2
         * 3
         * 4
         * 5
         */

    }
}
