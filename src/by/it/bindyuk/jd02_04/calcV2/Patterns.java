package by.it.bindyuk.jd02_04.calcV2;

public class Patterns {
    static final String OPERATION = "(?<=[^+*/,{-])[=*+/-]";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?),?)+}";
    static final String MATRIX = "\\{((\\{((-?\\d+(.\\d+)?),?)+}),?)+}";
}
