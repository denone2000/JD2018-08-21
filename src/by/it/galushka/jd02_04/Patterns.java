package by.it.galushka.jd02_04;


public class Patterns {

    static final String OPERATORS = "(?<=[^{,=*/+-])([+/*=-])";
    static final String OPERATORS_MATRIX = "[+/*-]";
    static final String SCALAR = "-?\\d+(\\.\\d+)?";
//    static final String SCALAR = "(\\d+(\\.\\d+)?)?";
    static final String VECTOR = "(\\{(\\d+(\\.\\d+)?\\,?\\s?)+})?";
    static final String MATRIX = "\\{(\\{(-?[0-9]+(\\.[0-9]+)?\\,?\\s?)+\\}\\,?\\s?)+\\}";
    static final String SINGLE_BRACKETS = "\\([A-z0-9]+(\\.[A-z0-9]+)?[-+/*][A-z0-9]+(\\.[A-z0-9]+)?\\)";
    static final String BRACKET = "(";
}
