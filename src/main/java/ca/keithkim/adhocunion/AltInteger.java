package ca.keithkim.adhocunion;

public final class AltInteger implements IntegerOrString, BooleanOrInteger {
    private final int i;

    AltInteger(int i) {
        this.i = i;
    }

    public int get() {
        return i;
    }
}
