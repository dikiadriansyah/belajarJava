import java.util.Optional;

public class Foo {
    Optional<Bar> getBar() {
        return Optional.of(new Bar());
    }
}
