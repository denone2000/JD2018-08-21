package by.it.nesterovich.jd02_04;

class Patterns {
    static final String OPERATION = "(?<=[^-+*/=,{])[-=+*/]";                              //[-=+/*]
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";                                     //"-?[0-9]+\\.?[0-9]*"
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?\\s?)+\\}";                    //"\\{((-?[0-9]+\\.?[0-9]*),?)+\\}"  // "\\{((-?\\d(.\\d+)?),?)+}"
    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?\\s?)+\\},?\\s?)+\\}";     //"\\{((\\{((-?\\d(.\\d+)?),?)+}),?)+}"
}
