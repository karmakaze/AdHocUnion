# AdHocUnion
Ad-hoc unions for Java (and other languages with only sealed nominal types)

Declare the ad-hoc unions that you want to use:
```java
sealed interface BooleanOrInteger permits AltBoolean, AltInteger {}
sealed interface IntegerOrString permits AltInteger, AltString {}
```

Then wrap each type that you want to participate in one or more ad-hoc unions:
```java
final class AltBoolean implements BooleanOrInteger {
    private final boolean b;
    AltBoolean(boolean b) { this.b = b; }
    public boolean get() { return b; }
}

final class AltInteger implements BooleanOrInteger, IntegerOrString {
    private final int i;
    AltBoolean(int i) { this.i = i; }
    public int get() { return i; }
}

final class AltString implements IntegerOrString {
    private final String s;
    AltBoolean(String s) { this.s = s; }
    public String get() { return s; }
}
```

This compiles and works in Java 17+ (where sealed types were fully introduced), as long as:
- Each class listed in the permits clause exists and is in the same package, or you explicitly use the permits clause and be in the same named module.
- The implementing classes (AltBoolean, AltInteger, AltString) are final (sealed or non-sealed).

Then they can be used as follows:
```java
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
}
```
Missing a switch case will produce a compile-time error.

See `OptionalOrList<T>` for an example of unifying capabilities with different implementations.
