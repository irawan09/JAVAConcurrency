package reference1.Optional.Chaining;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {

    void accept(T r);

    default Consumer<T> thenAccept(Consumer<T> next){
        Objects.requireNonNull(next);

        return (T t) -> {
           this.accept(t);
           next.accept(t);
        };
    }
}
