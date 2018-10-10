package by.it.nesterovich.jd02_04;

class Patterns {
    static final String OPERATION = "(?<=[^-+*/=,{])[-=+*/]";                              //[-=+/*]
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";                                     //"-?[0-9]+\\.?[0-9]*"
    static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+\\}";                          //"\\{((-?[0-9]+\\.?[0-9]*),?)+\\}"  // "\\{((-?\\d(.\\d+)?),?)+}"
    static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+\\}";                              //"\\{((\\{((-?\\d(.\\d+)?),?)+}),?)+}"
}
