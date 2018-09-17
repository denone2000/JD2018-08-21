package by.it.bindyuk.calc;

public class Patterns {
    static final String OPERATION = "[-=+*/]";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?),?)+}";
    static final String MATRIX = "\\{((\\{((-?\\d+(.\\d+)?),?)+}),?)+}";
}
