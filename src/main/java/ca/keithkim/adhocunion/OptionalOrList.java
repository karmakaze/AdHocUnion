package ca.keithkim.adhocunion;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public sealed interface OptionalOrList<T> permits AltList, AltOptional
{
    boolean isEmpty();

    void forEach(Consumer<? super T> action);

    <R> OptionalOrList<R> map(Function<? super T, ? extends R> mapper);

    Stream<T> stream();
}
