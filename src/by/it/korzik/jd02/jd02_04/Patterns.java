package by.it.korzik.jd02.jd02_04;

public class Patterns{
    static final String operation="(?<![{,+=*/(-])([+*/=-])";
    static final String SCALAR="-?[0-9]+(\\.?[0-9])*";
    static final String VECTOR="\\{(("+SCALAR+"),?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";
}
