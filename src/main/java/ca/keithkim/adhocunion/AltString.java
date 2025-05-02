package ca.keithkim.adhocunion;

public final class AltString implements IntegerOrString {
    private final String s;

    AltString(String s) {
        this.s = s;
    }

    public String get() {
        return s;
    }
}
