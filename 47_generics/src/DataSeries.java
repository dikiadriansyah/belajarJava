import java.util.*;

public interface DataSeries<T, DS extends DataSeries<T, DS>> {
    DS add(DS values);

    List<T> data();
}
