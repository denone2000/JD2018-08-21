package by.it.basumatarau.calc;

public class RegExPatterns {
    public static final String OPERATOR = "((?<=([\\w{}]\\s?))[-+=*/])|^[.]";
    public static final String SCALAR = "((?<=[\\D\\s])([-]?\\d+[.]?\\d*))|(^((-)?\\d*[.]?\\d*))";
    public static final String VECTOR = "\\{(("+SCALAR+")(, ?)?)+}";
    public static final String MATRIX = "\\{(("+VECTOR+")(, ?)?)+}";
}
