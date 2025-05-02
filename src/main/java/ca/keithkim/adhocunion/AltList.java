package ca.keithkim.adhocunion;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public final class AltList<T> implements OptionalOrList<T> {
    private final List<T> list;

    AltList(List<T> list) {
        this.list = list;
    }

    public List<T> get() {
        return list;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        list.forEach(action);
    }

    @Override
    public <R> OptionalOrList<R> map(Function<? super T, ? extends R> mapper) {
        return new AltList<R>((List<R>) list.stream().map(mapper).toList());
    }

    @Override
    public Stream<T> stream() {
        return list.stream();
    }
}
