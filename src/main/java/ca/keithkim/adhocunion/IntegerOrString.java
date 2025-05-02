package ca.keithkim.adhocunion;

public sealed interface IntegerOrString permits AltInteger, AltString {}