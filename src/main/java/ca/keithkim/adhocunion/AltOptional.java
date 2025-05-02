package ca.keithkim.adhocunion;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public final class AltOptional<T> implements OptionalOrList<T> {
    private final Optional<T> optional;

    public AltOptional(Optional<T> optional) {
        this.optional = optional;
    }

    public Optional<T> get() {
        return optional;
    }

    @Override
    public boolean isEmpty() {
        return !optional.isPresent();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        optional.ifPresent(action);
    }

    @Override
    public <R> AltOptional<R> map(Function<? super T, ? extends R> mapper) {
        return new AltOptional<R>(optional.map(mapper));
    }

    @Override
    public Stream<T> stream() {
        return optional.stream();
    }
}
