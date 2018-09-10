package by.it.basumatarau.jd01_09;

public class RegExPatterns {
    public static final String OPERATOR = "((?<=([\\d{}]\\s?))[-+*/])|^[.]";
    public static final String SCALAR = "((?<=[\\D\\s])([-]?\\d+[.]?\\d*))|(^((-)?\\d*[.]?\\d*))";
    public static final String VECTOR = "\\{(("+SCALAR+")(, ?)?)+}";
    public static final String MATRIX = "\\{(("+VECTOR+")(, ?)?)+}";
}
