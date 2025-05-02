package ca.keithkim.adhocunion;

public final class AltBoolean implements BooleanOrInteger {
    private final boolean b;

    AltBoolean(boolean b) {
        this.b = b;
    }

    public boolean get() {
        return b;
    }
}
