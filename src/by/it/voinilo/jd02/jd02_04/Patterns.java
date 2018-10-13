package by.it.voinilo.jd02.jd02_04;

public class Patterns {
    static final String OPERATION="(?<=[^-+*/=,{])[-=+*/]";
    static final String SCALAR="-?\\d+(.\\d+)?";
    static final String VECTOR="\\{((-?\\d+(.\\d+)?),?)+}";
    static final String MATRIX="\\{((\\{((-?\\d+(.\\d+)?),?)+}),?)+}";

}
