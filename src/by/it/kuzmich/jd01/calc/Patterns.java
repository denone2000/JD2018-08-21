package by.it.kuzmich.jd01.calc;

public class Patterns{
    static final String operation="[-+/*]";
    static final String SCALAR="-?[0-9]+(\\.?[0-9])*";
    static final String VECTOR="\\{(("+SCALAR+"),?)+}";
    static final String MATRIX="\\{("+VECTOR+",?)+}";
}
