import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String value();
}
