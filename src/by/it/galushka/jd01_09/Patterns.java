package by.it.galushka.jd01_09;


public class Patterns {

    static final String OPERATORS = "[-+*/]";
    static final String SCALAR = "(-?\\d+(\\.\\d+)?)?";
    static final String VECTOR = "(\\{(\\d+(\\.\\d+)?\\,?\\s?)+})?";
    static final String MATRIX = "\\{\\s?(\\{(\\d+(\\.\\d+)?\\,?\\s?)+}\\,?\\s?)+\\s?}";
}
