package by.it.bindyuk.jd02_06.calcV3;

public class Patterns {
    static final String OPERATION = "(?<=[^+*/,{-])[=*+/-]";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?),?\\s?)+}";
    static final String MATRIX = "\\{((\\{((-?\\d+(.\\d+)?),?)+}),?)+}";
}
