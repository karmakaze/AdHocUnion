package ca.keithkim.adhocunion;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        BooleanOrInteger booleanOrInteger1 = new AltBoolean(true);
        print(booleanOrInteger1);

        BooleanOrInteger booleanOrInteger2 = new AltInteger(2);
        print(booleanOrInteger2);

        IntegerOrString integerOrString1 = new AltInteger(1);
        print(integerOrString1);

        IntegerOrString integerOrString2 = new AltString("Hello");
        print(integerOrString2);

        OptionalOrList<String> optionalOrList1 = new AltOptional<>(Optional.of("Welcome!"));
        print(optionalOrList1);

        OptionalOrList<String> optionalOrList2 = new AltList<>(List.of("Hello", "world."));
        print(optionalOrList2);
    }

    public static void print(BooleanOrInteger booleanOrInteger) {
        switch (booleanOrInteger) {
            case AltBoolean b -> System.out.println(b.get());
            case AltInteger i -> System.out.println(i.get());
        }
    }

    public static void print(IntegerOrString integerOrString) {
        switch (integerOrString) {
            case AltInteger i -> System.out.println(i.get());
            case AltString s -> System.out.println(s.get());
        }
    }

    public static <T> void print(OptionalOrList<T> optionalOrList) {
        switch (optionalOrList) {
            case AltOptional<T> o -> System.out.println(o.get().orElse(null));
            case AltList<T> l -> System.out.println(l.get());
        }
    }
}
