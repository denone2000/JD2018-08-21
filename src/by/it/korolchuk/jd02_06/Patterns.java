package by.it.korolchuk.jd02_06;

public class Patterns {
    static final String OPERATION = "(?<=[^-+*/=,{\\s])[-+*/=]";
    static final String SCALAR = "-?(\\d+)(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d(.\\d+)?),?)+}";
    static final String MATRIX = "\\{((\\{((-?\\d(.\\d+)?),?)+}),?)+}";
}
