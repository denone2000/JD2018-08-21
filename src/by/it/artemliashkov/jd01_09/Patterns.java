package by.it.artemliashkov.jd01_09;

public class Patterns {
    static final String OPERATION = "[-+/*]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";                     //-?\d(.\d+)?  //"-?[0-9]+\\.?[0-9]*"
    static final String VECTOR = "\\{((-?\\d(.\\d+)?),?)+}";               //"\\{((-?[0-9]+\\.?[0-9]*),?)+\\}"
    static final String MATRIX = "\\{((\\{((-?\\d(.\\d+)?),?)+}),?)+}";    //"\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+\\},?)+\\}"
}
