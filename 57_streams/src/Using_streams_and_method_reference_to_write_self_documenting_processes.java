import java.util.ArrayList;
import java.util.List;

public class Using_streams_and_method_reference_to_write_self_documenting_processes {
    // Using Streams and Method References to Write Self-Documenting Processes /
    // Menggunakan Aliran dan Referensi Metode untuk Menulis Proses
    // Mendokumentasikan Diri

    /*
     * Referensi metode membuat kode dokumentasi mandiri yang sangat baik, dan
     * menggunakan referensi metode dengan Streams membuat proses rumit menjadi
     * mudah dibaca dan dipahami. Perhatikan kode berikut:
     * 
     * public interface Ordered {
     * default int getOrder(){
     * return 0;
     * }
     * }
     * public interface Valued<V extends Ordered> {
     * boolean hasPropertyTwo();
     * V getValue();
     * }
     * public interface Thing<V extends Ordered> {
     * boolean hasPropertyOne();
     * Valued<V> getValuedProperty();
     * }
     * public <V extends Ordered> List<V> myMethod(List<Thing<V>> things) {
     * List<V> results = new ArrayList<V>();
     * for (Thing<V> thing : things) {
     * if (thing.hasPropertyOne()) {
     * Valued<V> valued = thing.getValuedProperty();
     * if (valued != null && valued.hasPropertyTwo()){
     * V value = valued.getValue();
     * if (value != null){
     * results.add(value);
     * }
     * }
     * }
     * }
     * results.sort((a, b)->{
     * return Integer.compare(a.getOrder(), b.getOrder());
     * });
     * return results;
     * }
     */

    /*
     * Metode terakhir ini ditulis ulang menggunakan Streams dan referensi metode
     * jauh lebih mudah dibaca dan setiap langkah proses dipahami dengan cepat dan
     * mudah - tidak hanya lebih singkat, ini juga menunjukkan sekilas antarmuka dan
     * kelas mana yang bertanggung jawab atas kode di setiap langkah:
     */

    /*
     * public <V extends Ordered> List<V> myMethod(List<Thing<V>> things) {
     * return things.stream()
     * .filter(Thing::hasPropertyOne)
     * .map(Thing::getValuedProperty)
     * .filter(Objects::nonNull)
     * .filter(Valued::hasPropertyTwo)
     * .map(Valued::getValue)
     * .filter(Objects::nonNull)
     * .sorted(Comparator.comparing(Ordered::getOrder))
     * .collect(Collectors.toList());
     * }
     */

    public interface Ordered {
        default int getOrder() {
            return 0;
        }
    }

    public interface Valued<V extends Ordered> {
        boolean hasPropertyTwo();

        V getValue();
    }

    public interface Thing<V extends Ordered> {
        boolean hasPropertyOne();

        Valued<V> getValuedProperty();
    }

    public static <V extends Ordered> List<V> myMethod(List<Thing<V>> things) {
        List<V> results = new ArrayList<>();
        for (Thing<V> thing : things) {
            if (thing.hasPropertyOne()) {
                Valued<V> valued = thing.getValuedProperty();
                if (valued != null && valued.hasPropertyTwo()) {
                    V value = valued.getValue();
                    if (value != null) {
                        results.add(value);
                    }
                }
            }
        }
        results.sort((a, b) -> Integer.compare(a.getOrder(), b.getOrder()));
        return results;
    }

    public static void main(String[] args) {
        // Contoh penggunaan
        List<Thing<OrderedImpl>> things = new ArrayList<>();

        // Tambahkan beberapa objek Thing
        things.add(new ThingImpl(true, new ValuedImpl(true, new OrderedImpl(1))));
        things.add(new ThingImpl(false, null));
        things.add(new ThingImpl(true, new ValuedImpl(true, new OrderedImpl(2))));

        // Panggil metode myMethod
        List<OrderedImpl> results = myMethod(things);

        // Tampilkan hasil
        for (OrderedImpl result : results) {
            System.out.println(result.getOrder());
        }

        /*
         * output:
         * 1
         * 2
         * 
         */

    }

    // Implementasi interface Ordered
    public static class OrderedImpl implements Ordered {
        private final int order;

        public OrderedImpl(int order) {
            this.order = order;
        }

        @Override
        public int getOrder() {
            return order;
        }
    }

    // Implementasi interface Valued
    public static class ValuedImpl implements Valued<OrderedImpl> {
        private final boolean propertyTwo;
        private final OrderedImpl value;

        public ValuedImpl(boolean propertyTwo, OrderedImpl value) {
            this.propertyTwo = propertyTwo;
            this.value = value;
        }

        @Override
        public boolean hasPropertyTwo() {
            return propertyTwo;
        }

        @Override
        public OrderedImpl getValue() {
            return value;
        }
    }

    // Implementasi interface Thing
    public static class ThingImpl implements Thing<OrderedImpl> {
        private final boolean propertyOne;
        private final Valued<OrderedImpl> valuedProperty;

        public ThingImpl(boolean propertyOne, Valued<OrderedImpl> valuedProperty) {
            this.propertyOne = propertyOne;
            this.valuedProperty = valuedProperty;
        }

        @Override
        public boolean hasPropertyOne() {
            return propertyOne;
        }

        @Override
        public Valued<OrderedImpl> getValuedProperty() {
            return valuedProperty;
        }
    }

}
